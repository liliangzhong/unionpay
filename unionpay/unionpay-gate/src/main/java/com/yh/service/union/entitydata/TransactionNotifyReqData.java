package com.yh.service.union.entitydata;

/**
 * 
 * <p>Title: TransactionNotifyReqData</p>
 * <p>Description:交易通知数据实体</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年2月25日 下午3:28:16
 * @version 1.0
 *
 */
public class TransactionNotifyReqData
{
    /**
     * 云闪付商户号
     */
	private String merId;
	
	/**
	 * 交易金额
	 */
	private String txnAmt;
	
	/**
	 * 交易币种
	 */
	private String currencyCode;
	
	/**
	 * 订单号
	 */
	private String orderNo;
	
	/**
	 * 支付时间
	 */
	private String payTime;
	
	/**
	 * 服务商自定义域
	 */
	private String reqReserved;
	
	/**
	 * 订单信息
	 */
	private String orderInfo;
	
	/**
	 * 银联应答码
	 */
	private String respCode;
	
	/**
	 * 响应信息
	 */
	private String respMsg;

	public String getMerId()
	{
		return merId;
	}

	public String getTxnAmt()
	{
		return txnAmt;
	}

	public String getCurrencyCode()
	{
		return currencyCode;
	}

	public String getOrderNo()
	{
		return orderNo;
	}

	public String getPayTime()
	{
		return payTime;
	}

	public String getReqReserved()
	{
		return reqReserved;
	}

	public String getOrderInfo()
	{
		return orderInfo;
	}

	public String getRespCode()
	{
		return respCode;
	}

	public String getRespMsg()
	{
		return respMsg;
	}

	public void setMerId(String merId)
	{
		this.merId = merId;
	}

	public void setTxnAmt(String txnAmt)
	{
		this.txnAmt = txnAmt;
	}

	public void setCurrencyCode(String currencyCode)
	{
		this.currencyCode = currencyCode;
	}

	public void setOrderNo(String orderNo)
	{
		this.orderNo = orderNo;
	}

	public void setPayTime(String payTime)
	{
		this.payTime = payTime;
	}

	public void setReqReserved(String reqReserved)
	{
		this.reqReserved = reqReserved;
	}

	public void setOrderInfo(String orderInfo)
	{
		this.orderInfo = orderInfo;
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
