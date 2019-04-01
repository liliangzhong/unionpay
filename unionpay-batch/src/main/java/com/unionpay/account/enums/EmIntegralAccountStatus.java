package com.unionpay.account.enums;

/**
 * 
 * <p>Title: EmIntegralAccountStatus</p>
 * <p>Description:积分账户状态</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月18日 下午5:38:01
 * @version 1.0
 *
 */
public enum EmIntegralAccountStatus
{
    /**可用**/
	AVAILABLE {public String getAccountStatus() {return "00";}},
	
	/**禁用**/
	NOT_AVAILABLE{public String getAccountStatus() {return "01";}};
    
    public abstract String getAccountStatus();
}
