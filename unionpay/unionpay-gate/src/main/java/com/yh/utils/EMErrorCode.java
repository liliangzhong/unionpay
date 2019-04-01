package com.yh.utils;

/**
 * 
 * <p>Title: EMErrorCode</p>
 * <p>Description:错误码定义</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年2月25日 下午3:50:12
 * @version 1.0
 *
 */
public enum EMErrorCode
{
    /**
     * 处理成功
     */
	SUCCESS {public String getMessageId() {return "100000";}},
	
	/**
     * 网络超时异常
     */
	NETWORK_TIMEOUT {public String getMessageId() {return "100001";}},
	
	/**
	 * 程序处理异常
	 */
	PROGRAM_PROCESS_EXCEPTION {public String getMessageId() {return "100002";}};
	
	public abstract String getMessageId();
}
