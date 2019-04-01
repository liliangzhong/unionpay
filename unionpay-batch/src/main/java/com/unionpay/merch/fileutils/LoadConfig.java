package com.unionpay.merch.fileutils;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p>Title: LoadConfig</p>
 * <p>Description: </p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月4日 下午5:29:30
 * @version 1.0
 *
 */
public class LoadConfig
{
	private static Logger log = LoggerFactory.getLogger(LoadConfig.class);
	
	private static Properties prop = null;
    static
    {
    	prop = new Properties();
    	try
    	{
    		prop.load(Thread.currentThread().
    				getContextClassLoader().getResourceAsStream("application.properties"));
    	}
    	catch(Exception e)
    	{
    		log.error("load config.properties fail", e);
    	}
    }
    
    public final static String getProperties(String keyName)
    {
    	return prop.getProperty(keyName);
    }
}
