package com.unionpay.merch.model;

/**
 * 
 * <p>Title: BaseResponse</p>
 * <p>Description:服务实体响应基类</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月28日 上午9:51:02
 * @version 1.0
 *
 */
public class BaseResponse
{
    /**
     * 请求响应码
     */
	private String rspCode;
    
    /**
     * 请求响应错误信息
     */
	private String rspMessage;

	public String getRspCode()
	{
		return rspCode;
	}

	public String getRspMessage()
	{
		return rspMessage;
	}

	public void setRspCode(String rspCode)
	{
		this.rspCode = rspCode;
	}

	public void setRspMessage(String rspMessage)
	{
		this.rspMessage = rspMessage;
	}
}
