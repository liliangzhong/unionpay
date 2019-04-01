package com.unionpay.account.enums;

/**
 * 
 * <p>Title: EmMerchStatus</p>
 * <p>Description:商户状态</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月13日 下午8:21:21
 * @version 1.0
 *
 */
public enum EmMerchStatus
{
    /**
     * 待审核  check pending
     */
	CHECK_PENDING{public String getStatusId() {return "0";}},
	
	/**
	 * 审核通过
	 */
	AUDIT_PASS{public String getStatusId() {return "1";}},
	
	/**
	 * 禁用
	 */
	PROHIBIT{public String getStatusId() {return "2";}};
	
	public abstract String getStatusId();
}
