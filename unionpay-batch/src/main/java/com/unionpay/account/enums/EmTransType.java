package com.unionpay.account.enums;

/**
 * 
 * <p>Title: EmTransType</p>
 * <p>Description:交易类型</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月18日 下午10:26:39
 * @version 1.0
 *
 */
public enum EmTransType
{
	/**
	 * 22-消费  23-撤销  24-冲正  25-退货 26-充值
	 */
	PAYMENT{public String getTransType() {return "22";}},
	
	/**
	 * 撤销
	 */
	REVOKE{public String getTransType() {return "23";}},
	
	/**
	 * 冲正
	 */
	CORRECT{public String getTransType() {return "24";}},
	
	/**
	 * 退货
	 */
	REFUND{public String getTransType() {return "25";}},
	
	/**
	 * 充值
	 */
	RECHARGE{public String getTransType() {return "26";}};
	
	public abstract String getTransType();
}
