package com.unionpay.account.enums;

/**
 * 
 * <p>Title: EmErrorCode</p>
 * <p>Description:业务处理错误码</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月13日 下午7:34:11
 * @version 1.0
 *
 */
public enum EmErrorCode
{
    /**
     * 处理成功
     */
	SUCCESS{public int getId() {return 100000;}},
	
	/**
     * 网络超时
     */
	NETWORK_TIMEOUT{public int getId() {return 100001;}},
	
	/**
	 * 程序处理异常
	 */
	PROGRAM_HANDLE_EXCEPTION{public int getId() {return 100002;}},
	
	/**
	 * 系统异常
	 */
	SYSTEM_EXCEPTION{public int getId() {return 100003;}},
	
	/**
	 * 商户无权限
	 */
	MERCHANT_NO_QUTHORITY{public int getId(){return 100004;}},
	
	/**
	 * 配置项异常
	 */
	COFIGURE_EXCEPTION{public int getId() {return 100005;}},
	
	/**
	 * 验证签名失败
	 */
	VALIDATE_SIGN_FAIL{public int getId() {return 100006;}},
	
	/**
	 * 业务错误
	 */
	BUSINESS_EXCEPTION{public int getId() {return 100007;}},
	
	/**
	 * 数据入库失败
	 */
	ADD_DB_EXCEPTION{public int getId() {return 100008;}},
	
	/**
	 * 机构密钥异常
	 */
	ORG_SECRET_KEY_EXCEPTION{public int getId() {return 100009;}},
	
	/**
	 * 生成账户签名异常
	 */
	SIGN_ERROR_EXCEPTION{public int getId() {return 100010;}},
	
	/**
	 * 数据不存在
	 */
	DATA_NOT_EXISTENT{public int getId() {return 100011;}},
	
	/**
	 * 商户积分账户信息被篡改
	 */
	ACCOUNT_INFO_EXCEPTION{public int getId() {return 100012;}},
	
	/**
	 * 请求参数异常
	 */
	REQUEST_DATA_EXCEPTION{public int getId() {return 100013;}},
	
	/**
	 * 更新DB异常
	 */
	UPDATE_DB_EXCEPTION{public int getId() {return 100014;}};
	
	public abstract int getId();
}
