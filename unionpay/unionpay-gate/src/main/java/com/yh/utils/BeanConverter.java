package com.yh.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class BeanConverter
{
	public static <T> T convertBean(Object bean, Class<T> clazz) {
        try {
            T result = clazz.newInstance();
            BeanUtils.copyProperties(bean, result);
            
            return result;
        }
        catch (RuntimeException ex) {
            throw ex;
        }
        catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
    
    public static <T> List<T> convertList(List<?> list, Class<? extends T> clazz) {
        try {
            List<T> result = new ArrayList<T>(list.size());
            for (Object bean : list) {
                T obj = clazz.newInstance();
                BeanUtils.copyProperties(bean, obj);
                result.add(obj);
            }
            
            return result;
        }
        catch (RuntimeException ex) {
            throw ex;
        }
        catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

}
