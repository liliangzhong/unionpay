package com.unionpay.account.enums;

/**
 * 
 * <p>Title: EmKeyType</p>
 * <p>Description:密钥类型枚举</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月18日 下午5:32:46
 * @version 1.0
 *
 */
public enum EmKeyType
{
    /**MD5**/
	MD5_KEY{public String getKeyId() {return "01";}},
	
	/**RSASH256**/
	RSASH256_KEY{public String getKeyId() {return "02";}},
	
	/**AES**/
	AES_KEY{public String getKeyId() {return "03";}};
	
	public abstract String getKeyId();
}
