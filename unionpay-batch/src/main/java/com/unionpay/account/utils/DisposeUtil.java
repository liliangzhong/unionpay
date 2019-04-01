package com.unionpay.account.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;


/**
 * 
 * <p>Title: DisposeUtil</p>
 * <p>Description: 报文必填字段校验工具类</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月13日 下午7:54:22
 * @version 1.0
 *
 */
public class DisposeUtil
{
    private static Logger logger = LoggerFactory.getLogger(DisposeUtil.class);
    /**
     * 遍历对象属性值判断字段值是否为空，若对象中存在可空的字段，则可用集合封装，填写正确字段名，可跳过检测
     *
     * @param object
     * @param fields
     * @return
     */
    public static void dispose(Object object, List<String> fields) throws Exception
    {
        logger.debug(" 字段非空校验 开始 【object： " + object + "】");
        Field[] field = object.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
        for (int j = 0; j < field.length; j++) 
        { // 遍历所有属性
            String name = field[j].getName(); // 获取属性的名字
            if (fields == null) 
            {
                fields = new ArrayList<String>();
            }
            fields.add("serialVersionUID");
            if (!fields.contains(name)) 
            {
                name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
                Method m = object.getClass().getMethod("get" + name);
                Object value = m.invoke(object); // 调用getter方法获取属性值
                if (null == value || StringUtils.isEmpty(String.valueOf(value)))
                {
                    logger.error("请求参数" + name + "为空");
                    throw new Exception("【参数: " + name + " 为空 】");
                }
            }
        }
        logger.debug(" 字段非空校验 结束 ");
    }

    /**
     * 获取本机IP
     * @return
     */
    public static String  getServerIp()
    {
        InetAddress addr = null;
        try 
        {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        byte[] ipAddr = addr.getAddress();
        String ipAddrStr = "";
        for (int i = 0; i < ipAddr.length; i++) 
        {
            if (i > 0) 
            {
                ipAddrStr += ".";
            }
            ipAddrStr += ipAddr[i] & 0xFF;
        }
        return ipAddrStr;
    }
}
