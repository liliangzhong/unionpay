package com.unionpay.account.enums;

/**
 * 
 * <p>Title: EmConsumptionMark</p>
 * <p>Description:积分收支标志</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月18日 下午7:43:51
 * @version 1.0
 *
 */
public enum EmConsumptionMark
{
    /**
     * 收入
     */
	INTEGRAL_INCOM{public String getPaymentFlagId() {return "22";}},
	
	/**
	 * 支出
	 */
	INTEGRAL_PAY{public String getPaymentFlagId() {return "23";}};
	
	public abstract String getPaymentFlagId();
}
