package com.yh.service.union.entitydata;

/**
 * 
 * <p>Title: TransactionNotifyRspData</p>
 * <p>Description: 交易通知响应银联数据</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年2月25日 下午3:46:55
 * @version 1.0
 *
 */
public class TransactionNotifyRspData
{
    /**
     * 响应银联应答码
     */
	private String respCode;
	
	/**
	 * 响应银联应答描述
	 */
	private String respMsg;

	public String getRespCode()
	{
		return respCode;
	}

	public String getRespMsg()
	{
		return respMsg;
	}

	public void setRespCode(String respCode)
	{
		this.respCode = respCode;
	}

	public void setRespMsg(String respMsg)
	{
		this.respMsg = respMsg;
	}
}
