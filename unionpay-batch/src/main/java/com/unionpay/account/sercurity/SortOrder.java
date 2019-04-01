package com.unionpay.account.sercurity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SortOrder 
{	
	private static Logger log = LoggerFactory.getLogger(SortOrder.class);
	
	/**
	 * 使用 Map按key进行排序
	 * @param map
	 * @return
	 */
	public static Map<String, String> sortMapByKey(Map<String, String> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}

		Map<String, String> sortMap = new TreeMap<String, String>(
				new MapKeyComparator());

		sortMap.putAll(map);

		return sortMap;
	}
	
	/**
	 * 将map集合转化为xml文件
	 * @param map
	 * @return
	 */
	public static String callMapToXML(Map<String, String> map)
	{  
        log.info("将Map转成Xml, Map：" + map.toString());  
        StringBuffer sb = new StringBuffer();  
        sb.append("<xml>");  
        mapToXMLTest2(map, sb);  
        sb.append("</xml>");  
        log.info("将Map转成Xml, Xml：" + sb.toString());  
        return sb.toString();  
    }  
    
	private static void mapToXMLTest2(Map map, StringBuffer sb)
	{  
        Set set = map.keySet();  
        for (Iterator it = set.iterator(); it.hasNext();) 
        {  
            String key = (String) it.next();  
            Object value = map.get(key);  
            if (null == value)  
                value = "";  
            if (value.getClass().getName().equals("java.util.ArrayList"))
            {  
                ArrayList list = (ArrayList) map.get(key);  
                sb.append("<" + key + ">");  
                for (int i = 0; i < list.size(); i++) 
                {  
                    HashMap hm = (HashMap) list.get(i);  
                    mapToXMLTest2(hm, sb);  
                }  
                sb.append("</" + key + ">");
            }
            else 
            {  
                if (value instanceof HashMap) 
                {  
                    sb.append("<" + key + ">");  
                    mapToXMLTest2((HashMap) value, sb);  
                    sb.append("</" + key + ">");  
                } 
                else 
                {  
                    sb.append("<" + key + ">" + value + "</" + key + ">");  
                }  
            }  
        }  
    }
}