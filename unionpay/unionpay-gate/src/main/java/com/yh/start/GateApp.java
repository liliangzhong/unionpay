package com.yh.start;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import com.yh.kafkaframe.consumer.BaseKfkaConsumer;
import com.yh.kafkaframe.consumer.KafkaBaseService;
import com.yh.rocketmqframe.producer.RocketmqProducer;
import com.yh.rocketmqframe.utils.MySys;
import com.yh.service.union.service.BigDataBaseConsumerService;
import com.yh.utils.LoadConfig;

/**
 * 
 * <p>Title: GateApp</p>
 * <p>Description: 内部网关启动类</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年2月25日 下午2:44:48
 * @version 1.0
 *
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
@ImportResource({"applicationContext.xml"})
@SpringBootApplication
public class GateApp extends SpringBootServletInitializer
{
    private static final Logger logger = Logger.getLogger(GateApp.class);
    
    public static void main(String[] args )
    {
        logger.info("***********start the union-gateway service*************");
        
        //启动内部网关应用服务
    	SpringApplication springApplication = new SpringApplicationBuilder().sources(GateApp.class).web(true).build();
        ApplicationContext ctx =   springApplication.run(args);
        logger.info("***********start spring boot service success***********" + ctx.getApplicationName());
        
        //启动kafka消费者服务
        //startKafkaConsumer();
        
        //启动rocketmq生产者服务对象
        //startRocketmqProducer();
    }
    
    //启动kafka消费者服务
    public static void  startKafkaConsumer()
    {
    	try
    	{
    		String groupId = LoadConfig.getProperties("groupId");
            String brokerAdr = LoadConfig.getProperties("kafka_broker_adr");
            String topic = LoadConfig.getProperties("BIGDATA_BASE_TRANS");
            if(StringUtils.isBlank(groupId) || StringUtils.isBlank(brokerAdr)
            		|| StringUtils.isBlank(topic))
            {
            	logger.error("kafka配置信息出现问题，请检查config配置文件的kafka配置项信息是否正确");
            	logger.error("*********start the kafka consumer service fail*************");
            	return;
            }
            BaseKfkaConsumer consumer = new BaseKfkaConsumer(brokerAdr, groupId);
            String consumerThreads = LoadConfig.getProperties("service_thread_size");
            if(StringUtils.isBlank(consumerThreads))
            	consumerThreads = "20"; //配置文件不配置此参数,默认开启20个消费的工作线程。  
            KafkaBaseService bigDataBaseConsumerService = new BigDataBaseConsumerService(topic);
            bigDataBaseConsumerService.setThreadSize(Integer.valueOf(consumerThreads));
            consumer.serviceRegister(bigDataBaseConsumerService);
            
            consumer.start();
    	}
    	catch(Exception e)
    	{
    		logger.error("start kafka consumer program exception", e);
    	}
    }
    
    //启动rocketmq生产者
    public static void startRocketmqProducer()
    {
    	String message = null;
    	try
    	{
    		String nameserver_ip = LoadConfig.getProperties("nameserver_ip");
    		RocketmqProducer producer = new RocketmqProducer(nameserver_ip);		
    			
    		//存为公共变量副本
    		MySys.setRocketmqProducer(producer);
    		Logger.getLogger(GateApp.class).info("init rocketmq producer ok"); 
    	}
    	catch(Exception e)
    	{
    		message = "启动rocketmq生产者服务失败";
    		logger.error(message, e);
    	}
    }
    
    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) 
    {
        return builder.sources(this.getClass());
    }
}
