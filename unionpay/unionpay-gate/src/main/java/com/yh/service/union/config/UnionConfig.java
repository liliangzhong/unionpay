package com.yh.service.union.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


/**
 * 
 * <p>Title: UnionConfig</p>
 * <p>Description: load config utils</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2018年3月13日 上午11:22:08
 * @version 1.0
 *
 */
public class UnionConfig
{
    private static Logger log = LoggerFactory.getLogger(UnionConfig.class);
    
    public static final String UP_REGISTER_URL = "http://60.190.227.167:8082/member/register";
    public static final String UP_CANCLE_URL = "http://60.190.227.167:8082/member/unregister";
    public static final String UP_APPLAY_QRCODE_URL = "http://60.190.227.167:8082/qrcode/get";
    public static final String UP_PAY_SUCCCESS_NOTIFY_URL = "http://60.190.227.167:8082/trip/consume_nofity";
    
    private static Properties prop = null;
    
    static
    {
    	prop = new Properties();
    	try
    	{
    		prop.load(Thread.currentThread().
    				getContextClassLoader().getResourceAsStream("union.properties"));
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
