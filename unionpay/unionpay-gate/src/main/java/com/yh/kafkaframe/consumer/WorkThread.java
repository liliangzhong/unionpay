package com.yh.kafkaframe.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;


public class WorkThread  extends Thread 
{
	private KafkaBaseService localService = null;
	
	public void setMyOwnService(KafkaBaseService service)
	{
		localService = service;
		setName("WorkThread-" + getId());
	}

	public void run() 
	{
    	ConsumerRecord<String, String> records = null;
		while(true)
		{
			try
			{
				records = localService.getMessageQueue().take();
			} 
			catch (InterruptedException e1)
			{
				e1.printStackTrace();
			}
			if(records == null)
			{
				try
				{
					sleep(1000);
				} 
				catch (InterruptedException e) 
				{
					Logger.getLogger(this.getClass()).error(e.toString());
				}
				continue;
			}
			else
				localService.doService(records,this.getId());
		}
	};
}
