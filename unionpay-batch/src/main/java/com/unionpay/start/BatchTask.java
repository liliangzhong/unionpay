package com.unionpay.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
@ImportResource({"applicationContext.xml"})
@SpringBootApplication
public class BatchTask
{
    public static Logger logger = LoggerFactory.getLogger(BatchTask.class);

    public static void main(String[] args) throws Exception 
    {
        String errorMessage = null;
        try
        {
        	SpringApplication springApplication = new SpringApplicationBuilder().sources(BatchTask.class).web(true).build();
        	springApplication.run(args);
        }
        catch(Exception e)
        {
        	errorMessage = "********************启动批处理任务服务失败********************";
        	logger.error(errorMessage, e);
        }
    }
}