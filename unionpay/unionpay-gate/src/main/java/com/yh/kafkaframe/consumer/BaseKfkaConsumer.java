package com.yh.kafkaframe.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.log4j.Logger;

public class BaseKfkaConsumer extends Thread
{
    private static final Logger log = Logger.getLogger(BaseKfkaConsumer.class);
    //消费者对象
    private static KafkaConsumer<String,String> consumer = null;
    //定义消费者订阅的topc集合
    public static Vector<KafkaBaseService> vctService = new Vector<KafkaBaseService>();
    //定义接收发送消息对象
    private ConsumerRecords<String, String> records = null;
    //定义消费数据缓冲区，等待的时间，单位为毫秒
    private static long timeOut = 30000;
    
    public BaseKfkaConsumer(String brokerAddress, String groupId)
    {
    	Properties configs = initConfig(brokerAddress, groupId);
        consumer = new KafkaConsumer<String, String>(configs);
    }

    private  Properties initConfig(String brokerAddress, String groupId)
    {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerAddress);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return properties;
    }
    
    public void stopKafkaConsumer()
    {
    	if(consumer != null)
    		consumer.close();
    }
    
    private void routeMessageByTopic(ConsumerRecord<String, String> records)
	{
		if(null != records)
		{
			String topic = records.topic();
			for(int i=0;i< vctService.size();i++)
			{
				KafkaBaseService serv = vctService.get(i);
				if(serv.isMySubMessage(topic))
				{
					serv.putMessage2WorkQueue(records);
					return;
			    }
			}
		}
		log.error("kafka消息没有被处理");
	}
    
    //注册业务服务类
  	public void serviceRegister(KafkaBaseService service)
  	{
  		if(vctService != null)
  		{
  			//装载子类订阅的消息,将子类添加到服务列表中
  			service.loadTopics();
  			vctService.add(service);
  			
  			//通知consumer对业务消息进行订阅
  			Vector<String> vctTopic = service.getVctTopic();
  			if(vctTopic.size() > 0)
  			{
  				for(int i=0; i<vctTopic.size(); i++)
  				{
  					String topic = vctTopic.get(i);
  					try
  					{
  						if(topic.indexOf("&") >= 0)
  						{
  							//只订阅自己模块关心的topic消息(同时指定topic和tag)
  							String str [] = topic.split("&");
  							consumer.subscribe(Arrays.asList(topic));
  							Logger.getLogger(this.getClass()).info("业务逻辑服务类 " + service.getClass().toString()+ " 订阅的消息  topic = " + str[0] + ",tag = " + str[1] );
  						}
  						else
  						{
  							//订阅该topic的全部tag
  							consumer.subscribe(Arrays.asList(topic));							
  							Logger.getLogger(this.getClass()).info("业务逻辑服务类 " + service.getClass().toString()+ " 订阅的消息  topic = " + topic + ",tag = *" );
  						}	
  					}
  					catch (Exception e) 
  					{
  						Logger.getLogger(this.getClass()).error(e.toString());
  					}
  				}
  				//激活业务对象;传入本地对象指针和线程数
  				service.startService(service, service.getThreadSize());
  				Logger.getLogger(this.getClass()).info("业务逻辑服务类 " + service.getClass().toString() 
  						+ " 成功启动,创建了 " + service.getThreadSize() + " 个工作线程");
  			}
  			else
  			{
  				Logger.getLogger(this.getClass()).error("业务逻辑服务类" + service.getClass().toString() + " 注册失败。订阅的消息主题为空");
  				Logger.getLogger(this.getClass()).error("业务逻辑服务类" + service.getClass().toString() + " 没有被成功启动...");
  			}		
  		}
  	}
  	
	@Override
	public void run()
	{
		String message = null;
		try
		{
			while(consumer != null)
			{
				records = consumer.poll(timeOut);
			    for (TopicPartition partition : records.partitions())
    	        {
    	            List<ConsumerRecord<String, String>> partitionRecords = records.records(partition);
    	            for (ConsumerRecord<String, String> record : partitionRecords)
    	            {
    	            	routeMessageByTopic(record);
    	            }
    	            consumer.commitSync();//同步
    	        }
			}
			/*
			 * for (ConsumerRecord<String, String> record : records)
			 * //消费信息交给工作线程处理 { routeMessageByTopic(record); }
			 */
		}
		catch(Exception e)
		{
			message = "kafka消费线程处理失败";
			log.error(message, e);
		}
		finally
		{
			stopKafkaConsumer();
		}
	}
}
