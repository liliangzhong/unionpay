package com.unionpay.account.model;

public class IntegralAccountAddRsp extends BaseResponse
{
	/**积分账户编号**/
    private String integralAccountNo;
    
    /**账户类型**/
    private String accountType;
    
    /**收单机构编号**/
    private String orgCode;

    /**商户号**/
    private String merchId;
    
    /**账户状态**/
    private String accountStatus;

	public String getIntegralAccountNo()
	{
		return integralAccountNo;
	}

	public String getAccountType()
	{
		return accountType;
	}

	public void setIntegralAccountNo(String integralAccountNo)
	{
		this.integralAccountNo = integralAccountNo;
	}

	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}

	public String getOrgCode()
	{
		return orgCode;
	}

	public String getMerchId()
	{
		return merchId;
	}

	public String getAccountStatus()
	{
		return accountStatus;
	}

	public void setOrgCode(String orgCode)
	{
		this.orgCode = orgCode;
	}

	public void setMerchId(String merchId)
	{
		this.merchId = merchId;
	}

	public void setAccountStatus(String accountStatus)
	{
		this.accountStatus = accountStatus;
	}
}
