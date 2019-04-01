package com.unionpay.account.model;

import com.unionpay.dao.model.UpIntegralAccount;

/**
 * 
 * <p>Title: ValidateDataSignRsp</p>
 * <p>Description:校验账户数据是否被篡改响应实体类</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月19日 上午10:04:37
 * @version 1.0
 *
 */
public class ValidateDataSignRsp extends BaseResponse
{
    /**
     * 账户对象
     */
	private UpIntegralAccount integralAccount;
	
	/**
	 * 验签标志
	 */
	private Boolean signFlag;
	
	/**
	 * 机构密钥
	 */
	private String secretKey;

	public UpIntegralAccount getIntegralAccount()
	{
		return integralAccount;
	}

	public Boolean getSignFlag()
	{
		return signFlag;
	}

	public void setIntegralAccount(UpIntegralAccount integralAccount)
	{
		this.integralAccount = integralAccount;
	}

	public void setSignFlag(Boolean signFlag)
	{
		this.signFlag = signFlag;
	}

	public String getSecretKey()
	{
		return secretKey;
	}

	public void setSecretKey(String secretKey)
	{
		this.secretKey = secretKey;
	}
}
