package com.unionpay.account.sercurity;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.unionpay.dao.model.UpIntegralAccount;

public class SignUtils 
{
    private static Logger log = LoggerFactory.getLogger(SignUtils.class);
    
	
	//生成sign签名
	public static String getSign(Map<String, String> resultMap, String merch_key)
	{
		if(resultMap == null || merch_key == null || "".equals(merch_key))
		return null;
		
		Map<String, String> sortMap = new HashMap<String, String>();
		String sign = null;
		try
		{
    		//将map集合按照字典排序
    		sortMap = SortOrder.sortMapByKey(resultMap);
    		if(sortMap.containsKey("sign") || sortMap.get("sign") != null)
    		sortMap.remove("sign");
    		String sortData = sortMap.toString();
        	String ps = sortData.replaceAll(", ", "&"); //,转换成&
        	String pa = ps.substring(1, ps.length()-1);
        	String signKeys = "&key=" + merch_key;
      	    sign = MD5.sign(pa, signKeys, "utf-8").toUpperCase();
		}
		catch(Exception e)
		{
			String errorMessage = "生成sign签名发生异常";
			log.error(errorMessage, e);
			return null;
		}
		return sign;
	}
	
	//获取唯一账号,标志位+手机号+6位随机数
	public static String getAccountNo(String flag, String mobile)
	{
		String message = null;
		String results = null;
		try
		{
			results = "6" + flag + mobile + generateRandomArray(6);
		}
		catch(Exception e)
		{
			message = "获取单号失败";
			log.error(message, e);
			return null;
		}
		return results;
	}
	
	/** 
     * 随机生成 num位数字字符数组 
     *  
     * @param num 
     * @return 
     */  
    public  static String generateRandomArray(int num)
    {  
        String chars = "0123456789";  
        StringBuffer results = new StringBuffer();
        for (int i = 0; i < num; i++) 
        {  
            int rand = (int) (Math.random() * 10); 
            results.append(chars.charAt(rand));
        }  
        return results.toString();  
    }
    
    public static String getAccountSign(UpIntegralAccount record, String secretKey)
    {
    	String errorMessage = null;
    	String sign = null;
    	try
    	{
    		Map<String, String> signMap = new HashMap<String, String>();
			signMap.put("integralAccountNo", record.getIntegralAccountNo());
			signMap.put("accountType", record.getAccountType());
			signMap.put("orgCode", record.getOrgCode());
			signMap.put("merchId", record.getMerchId());
			signMap.put("accountStatus", record.getAccountStatus());
			signMap.put("availableBalance", record.getAvailableBalance().toString());  //可用积分余额
			signMap.put("accountChangeTime", record.getAccountChangeTime().toString());
			sign = getSign(signMap, secretKey);
    	}
    	catch(Exception e)
    	{
    		errorMessage = "获取账户签名失败";
    		log.error(errorMessage, e);
    	}
    	return sign;
    }
}
