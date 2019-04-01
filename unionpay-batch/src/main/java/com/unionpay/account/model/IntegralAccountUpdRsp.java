package com.unionpay.account.model;

import java.util.Date;

/**
 * 
 * <p>Title: IntegralAccountUpdRsp</p>
 * <p>Description:积分账户变更响应实体</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月18日 下午3:09:42
 * @version 1.0
 *
 */
public class IntegralAccountUpdRsp extends BaseResponse
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

    /**冻结余额**/
    private Long blockedBalance;

    /**账户状态**/
    private String accountStatus;

    /**账户变动时间**/
    private Date accountChangeTime;

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

	public Long getBlockedBalance()
	{
		return blockedBalance;
	}

	public String getAccountStatus()
	{
		return accountStatus;
	}

	public Date getAccountChangeTime()
	{
		return accountChangeTime;
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

	public void setBlockedBalance(Long blockedBalance)
	{
		this.blockedBalance = blockedBalance;
	}

	public void setAccountStatus(String accountStatus)
	{
		this.accountStatus = accountStatus;
	}

	public void setAccountChangeTime(Date accountChangeTime)
	{
		this.accountChangeTime = accountChangeTime;
	}
}
