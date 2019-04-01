package com.unionpay.merch.enums;

/**
 * 
 * <p>Title: EmErrorCode</p>
 * <p>Description:错误码定义</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月28日 上午10:24:10
 * @version 1.0
 *
 */
public enum EmErrorCode
{
    /**
     * 成功
     */
	SUCESS{public String getErrorCode() {return "100000";}},
	
	/**
	 * 失败
	 */
	FAIL{public String getErrorCode() {return "100001";}};
	
	public abstract String getErrorCode();
}
