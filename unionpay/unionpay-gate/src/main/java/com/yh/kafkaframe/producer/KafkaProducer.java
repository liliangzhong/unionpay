package com.yh.kafkaframe.producer;

import java.util.Properties;
import java.util.UUID;

import org.apache.kafka.clients.consumer.ConsumerConfig;

import com.alibaba.fastjson.JSONObject;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * 
 * <p>Title: KafkaProducer</p>
 * <p>Description: 测试kafka发送专用服务类，并没有实际生产应用。</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月6日 下午7:59:08
 * @version 1.0
 *
 */
public class KafkaProducer
{
    public static void main(String[] args)
    {
    	String topic = "BIGDATA_BASE_TRANS";
    	Properties props = new Properties();
    	props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "222.222.56.94:1092");
        kafka.javaapi.producer.Producer<Integer, String> producer;
        producer = new kafka.javaapi.producer.Producer<Integer, String>(new ProducerConfig(props));
        JSONObject sendData = new JSONObject();
        sendData.put("merchId", String.valueOf(System.currentTimeMillis()));
        sendData.put("orderId", UUID.randomUUID().toString().replaceAll("-", ""));
        System.out.println("Send:" + sendData);
        try 
        {
        	producer.send(new KeyedMessage<Integer, String>(topic, sendData.toString()));
        	Thread.sleep(1000);
        	System.out.println("========================发送成功=========================");
        }
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
}
