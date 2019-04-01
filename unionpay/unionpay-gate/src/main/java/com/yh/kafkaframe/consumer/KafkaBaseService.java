package com.yh.kafkaframe.consumer;

import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;

/**
 * 
 * <p>Title: KafkaBaseService</p>
 * <p>Description: kafka服务消费基类</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年2月26日 下午7:59:13
 * @version 1.0
 *
 */
public abstract class KafkaBaseService
{
	private static final Logger logger = Logger.getLogger(KafkaBaseService.class);
	
	//定义消息队列（默认设置消息队列长度为50000）
	//private Queue<MessageExt> messageQueue = new ConcurrentLinkedQueue<MessageExt>();
	private BlockingQueue<ConsumerRecord<String, String>> messageQueue = 
			new LinkedBlockingQueue<ConsumerRecord<String, String>>(1000);
	
	//定义线程对象列表
	private Vector<WorkThread> vctWorker = new Vector<WorkThread>();
	
	//定义系统默认的工作线程数量(可以自行指定每个业务逻辑处理类的线程数量)
	private int threadSize = 4;
	
	//定义自己定于的消息topic
	private Vector<String> vctTopic = new Vector<String>();
	
	//装载自己需要定于的消息主题(子类必须实现)
	public abstract void loadTopics();
	
	//定义一个通用的业务逻辑处理类(子类必须实现)
	public abstract void doService(ConsumerRecord<String, String> message,long threadID);
	
	public Vector<String> getVctTopic()
	{
		return vctTopic;
	}
	
	public BlockingQueue<ConsumerRecord<String, String>> getMessageQueue()
	{
		return messageQueue;
	}

	public int getThreadSize()
	{
		return threadSize;
	}

	public void setThreadSize(int threadSize) 
	{
		this.threadSize = threadSize;
	}

	public boolean isMySubMessage(String topic)
	{
		//Logger.getLogger(this.getClass()).info("topic = " + topic);
		if(vctTopic != null)
		{
			if(vctTopic.size()>0)
			{
				for(int i=0;i<vctTopic.size();i++)
				{
					String str = vctTopic.get(i);
					//if(str.equals(topic)){
					if(str.indexOf(topic)>=0)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	//将消息压入工作队列
	public void putMessage2WorkQueue(ConsumerRecord<String, String> message)
	{
		if(null != messageQueue)
		{
			//messageQueue.offer(message);
			try
			{
				messageQueue.put(message);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("消息入队列异常~~~~," + e.toString());
			}
		}
	}
	
	//指定创建多少个线程进行业务处理(工作线程和业务逻辑类建立关联关系)
	public void startService(KafkaBaseService localService, int threadSize) 
	{
		for(int i = 0; i < threadSize; i++)
		{	
			WorkThread worker = new WorkThread();
			worker.setMyOwnService(localService);
			worker.start();
			vctWorker.add(worker);
			logger.info("业务逻辑服务类 " + localService.getClass().toString() + ": thread " + i + " 启动成功");
		}
	}
}
