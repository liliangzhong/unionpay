package com.unionpay.account.enums;

/**
 * 
 * <p>Title: EmAccountType</p>
 * <p>Description:账户类型</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月18日 下午5:42:43
 * @version 1.0
 *
 */
public enum EmAccountType
{
    /**积分账户**/
	INTEGRAL_ACCOUNT {public String getAccountTypeId() {return "10";}};
	
	public abstract String getAccountTypeId();
}
