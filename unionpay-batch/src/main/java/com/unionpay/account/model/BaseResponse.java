package com.unionpay.account.model;

/**
 * 
 * <p>Title: BaseResponse</p>
 * <p>Description:公共响应基类</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月14日 上午10:44:00
 * @version 1.0
 *
 */
public class BaseResponse
{
    /**
     * 响应编码
     */
	private Integer rspCode;
	
	/**
	 * 响应错误信息
	 */
	private String rspMessage;

	public Integer getRspCode()
	{
		return rspCode;
	}

	public String getRspMessage()
	{
		return rspMessage;
	}

	public void setRspCode(Integer rspCode)
	{
		this.rspCode = rspCode;
	}

	public void setRspMessage(String rspMessage)
	{
		this.rspMessage = rspMessage;
	}
}
