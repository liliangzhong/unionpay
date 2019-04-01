package com.unionpay.account.model;

/**
 * 
 * <p>Title: IntegralAccountUpdReq</p>
 * <p>Description:积分账户变动请求实体</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月18日 下午3:12:06
 * @version 1.0
 *
 */
public class IntegralAccountUpdReq
{
	/**积分账户编号**/
    private String integralAccountNo;

    /**收单机构编号**/
    private String orgCode;

    /**商户号**/
    private String merchId;

    /**未激活积分余额**/
    private Long activeNoIntegral;
   
    /**可用余额**/
    private Long availableBalance;
    
    /**消费标志  22-支出  23-收入**/
    private String paymentFlag;
    
    /**交易发生额**/
    private Long transIntegral;

	public String getIntegralAccountNo()
	{
		return integralAccountNo;
	}

	public String getOrgCode()
	{
		return orgCode;
	}

	public String getMerchId()
	{
		return merchId;
	}

	public Long getActiveNoIntegral()
	{
		return activeNoIntegral;
	}

	public Long getAvailableBalance()
	{
		return availableBalance;
	}

	public void setIntegralAccountNo(String integralAccountNo)
	{
		this.integralAccountNo = integralAccountNo;
	}

	public void setOrgCode(String orgCode)
	{
		this.orgCode = orgCode;
	}

	public void setMerchId(String merchId)
	{
		this.merchId = merchId;
	}

	public void setActiveNoIntegral(Long activeNoIntegral)
	{
		this.activeNoIntegral = activeNoIntegral;
	}

	public void setAvailableBalance(Long availableBalance)
	{
		this.availableBalance = availableBalance;
	}

	public String getPaymentFlag()
	{
		return paymentFlag;
	}

	public void setPaymentFlag(String paymentFlag)
	{
		this.paymentFlag = paymentFlag;
	}

	public Long getTransIntegral()
	{
		return transIntegral;
	}

	public void setTransIntegral(Long transIntegral)
	{
		this.transIntegral = transIntegral;
	}
}
