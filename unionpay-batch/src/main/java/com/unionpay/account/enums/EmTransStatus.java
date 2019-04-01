package com.unionpay.account.enums;

/**
 * 
 * <p>Title: EmTransStatus</p>
 * <p>Description:积分账户变动状态枚举</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月18日 下午10:11:36
 * @version 1.0
 *
 */
public enum EmTransStatus
{
    /**
     * 账户处理成功
     */
	SUCCESS_TRANS{public String getTransStatus() {return "00";}},
	
	/**
	 * 未知
	 */
	UNKKNOWN_TRANS{public String getTransStatus() {return "02";}},
	
	/**
	 * 交易失败
	 */
	FAIL_TRANS{public String getTransStatus() {return "01";}};
	
	public abstract String getTransStatus();
}
