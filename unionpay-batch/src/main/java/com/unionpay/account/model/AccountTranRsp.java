package com.unionpay.account.model;

/**
 * 
 * <p>Title: AccountTranRsp</p>
 * <p>Description:新增账户变动流水信息响应实体</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月18日 上午11:15:28
 * @version 1.0
 *
 */
public class AccountTranRsp extends BaseResponse
{   
	/**账户号**/
    private String integralAccountNo;
    
    /**账户变动流水号**/
    private String transId;
    
	public String getTransId()
	{
		return transId;
	}

	public void setTransId(String transId)
	{
		this.transId = transId;
	}

	public String getIntegralAccountNo()
	{
		return integralAccountNo;
	}

	public void setIntegralAccountNo(String integralAccountNo)
	{
		this.integralAccountNo = integralAccountNo;
	}
}
