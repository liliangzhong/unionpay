package com.yh.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * <p>Title: CommonUtil</p>
 * <p>Description: 生成请求流水号</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2018年3月12日 下午5:00:09
 * @version 1.0
 *
 */
public class CommonUtil
{
	static AtomicLong index = new AtomicLong(1);

	static AtomicLong STANDARD_REQ_SERIAL_INDEX = new AtomicLong(1);

	public static final String genUID()
	{
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String getClientType(String uid) 
	{
		return uid.substring(uid.length() - 2);
	}
	
	public static String genSeriaL20(String s_machine_index)
	{
		String now_yyMMddHHmm = formatDate2Str(new Date(), "yyyyMMddHHmmss");
		try 
		{
			s_machine_index = leftPadding(s_machine_index, 3);
		} 
		catch (Exception e)
		{
			s_machine_index = "001";
		}

		Long currentValue = index.getAndIncrement();
		if (currentValue > 9999999)
		{
			index.set(1);
			currentValue = index.getAndIncrement();
		}
		String curIndexStr = leftPadding(String.valueOf(currentValue), 7);
		return now_yyMMddHHmm + s_machine_index + curIndexStr;
	}

	public static String leftPadding(String str, int toLength) 
	{
		int length = str.length();
		if (length < toLength)
		{
			for (int i = 0; i < toLength - length; i++)
			{
				str = "0" + str;
			}
		}
		return str;
	}
	public static  String formatDate2Str(Date sDate,String format)
	{
		if (sDate == null) return null;
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(sDate);
	
	
	}
	
	
	public static void main(String[] args) 
	{
		for (int i = 0 ; i < 1;  i++)
		{
			System.out.println(genSeriaL20("18"));
		}
		int count = 18;
		String salSeqNo = String.format("%016d",count);
		System.out.println(salSeqNo);
	}
	
	/*
	 * 获取用户user_id,平台内保证唯一：手机号+秒+毫秒
	 */
	public static String getUserId(String mobile_phone)
	{
		SimpleDateFormat sf = new SimpleDateFormat("ssSSS");
		StringBuffer sb = new StringBuffer();
		sb.append(mobile_phone).append(sf.format(new Date()));
		return sb.toString();
	}
}
