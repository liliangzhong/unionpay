package com.unionpay.account.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

/**
 * 
 * <p>Title: BeanConverter</p>
 * <p>Description:对象字段复制工具类</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月13日 下午7:54:58
 * @version 1.0
 *
 */
public class BeanConverter
{
	public static <T> T convertBean(Object bean, Class<T> clazz)
	{
        try 
        {
            T result = clazz.newInstance();
            BeanUtils.copyProperties(bean, result);
            return result;
        }
        catch (RuntimeException ex) 
        {
            throw ex;
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
    
    public static <T> List<T> convertList(List<?> list, Class<? extends T> clazz) 
    {
        try
        {
            List<T> result = new ArrayList<T>(list.size());
            for (Object bean : list) 
            {
                T obj = clazz.newInstance();
                BeanUtils.copyProperties(bean, obj);
                result.add(obj);
            }
            return result;
        }
        catch (RuntimeException ex) 
        {
            throw ex;
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}
