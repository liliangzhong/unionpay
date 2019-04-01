package com.unionpay.account.model;

import com.unionpay.dao.model.UpIntegralAccount;

public class IntegralAccountFindRsp extends UpIntegralAccount
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
