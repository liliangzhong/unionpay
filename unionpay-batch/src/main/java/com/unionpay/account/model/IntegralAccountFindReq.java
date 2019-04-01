package com.unionpay.account.model;

/**
 * 
 * <p>Title: IntegralAccountFindReq</p>
 * <p>Description:查询积分账户请求实体类</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月19日 上午8:51:40
 * @version 1.0
 *
 */
public class IntegralAccountFindReq
{
    /**
     * 账号
     */
	private String integralAccountNo;
	
	/**
	 * 收单机构编号
	 */
	private String orgCode;
	
	/**
	 * 商户号
	 */
	private String merchId;

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
}
