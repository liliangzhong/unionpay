package com.yh.rocketmqframe.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.rocketmq.common.message.Message;

/**
 * 
 * <p>Title: RocketMQSend</p>
 * <p>Description: </p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月6日 上午9:27:31
 * @version 1.0
 *
 */
public class RocketMQSend
{
    private static final Logger logger = Logger.getLogger(RocketMQSend.class);
    
    public static boolean sendRocketmqMessage(String tags, String keys, String message, String topic)
    {
    	String errorMessage = null;
    	try
    	{
    		if(StringUtils.isBlank(tags) || StringUtils.isBlank(keys) 
    				|| StringUtils.isBlank(message) || StringUtils.isBlank(topic))
    			return false;
    		byte[] bytes = message.getBytes();
    		Message msg = new Message(topic, tags, keys, bytes);
    		MySys.getRocketmqProducer().sendMessage(msg);
    	}
    	catch(Exception e)
    	{
    		errorMessage = "发送RMQ消息失败";
    		logger.error(errorMessage, e);
    		return false;
    	}
    	return true;
    }
}
