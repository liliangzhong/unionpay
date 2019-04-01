package com.yh.rocketmqframe.utils;

import com.yh.rocketmqframe.producer.RocketmqProducer;

public class MySys
{
    private static RocketmqProducer rocketmqProducer;  //rocketMQ 生产者服务对象

	public static RocketmqProducer getRocketmqProducer()
	{
		return rocketmqProducer;
	}

	public static void setRocketmqProducer(RocketmqProducer rocketmqProducer)
	{
		MySys.rocketmqProducer = rocketmqProducer;
	}
}
