package com.yh.rocketmqframe.producer;

import org.apache.log4j.Logger;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * 
 * <p>Title: RocketmqProducer</p>
 * <p>Description: </p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月5日 下午5:42:35
 * @version 1.0
 *
 */
public class RocketmqProducer
{
	private static String my_nameServerIP;
	private static DefaultMQProducer producer = null;

	public RocketmqProducer(String nameServerIP)
	{
		my_nameServerIP = nameServerIP;

		// 指定是生产者的模块名称(producerGroup,如果模块分布式部署多个，用这个参数来进行分类)
		producer = new DefaultMQProducer();
		producer.setInstanceName(Long.toString(System.currentTimeMillis()));
		
		//注意：生产者的名字必须保证是 "模块名_producer";否则程序会出错
		String producerGroupName = "quickPay_producer";  //rocketmq单机版部署注销
		producer.setProducerGroup(producerGroupName);    //rocketmq单机版部署注销

		// 指定消息中间件服务器NameServer
		//producer.setNamesrvAddr(my_nameServerIP + ":9876");
		producer.setNamesrvAddr(my_nameServerIP);
		try
		{
			producer.start();
		} 
		catch (MQClientException e)
		{
			producer.shutdown();
			Logger.getLogger(this.getClass()).error(e.toString());
		}
		Logger.getLogger(this.getClass()).info("producer is running,serv = " + my_nameServerIP + ",instanceName = " + producer.getInstanceName());
	}

	public static void destroy() 
	{
		if (null != producer) 
		{
			producer.shutdown();
		}
	}

	public SendResult sendMessage(Message msg) 
	{
		if(null != producer)
		{			
			SendResult sendResult = null;			
			try 
			{
				sendResult = producer.send(msg);		
			} catch (Exception e)
			{
				Logger.getLogger(this.getClass()).error(e.toString());
			}			
			return sendResult;
		}
		return null;
	}
	
	public DefaultMQProducer getLocalProducer ()
	{	
		return producer;	
	}
}
