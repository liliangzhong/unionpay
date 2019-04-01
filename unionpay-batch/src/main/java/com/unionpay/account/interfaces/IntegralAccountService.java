package com.unionpay.account.interfaces;

import com.unionpay.account.model.IntegralAccountAddReq;
import com.unionpay.account.model.IntegralAccountAddRsp;
import com.unionpay.account.model.IntegralAccountFindReq;
import com.unionpay.account.model.IntegralAccountFindRsp;
import com.unionpay.account.model.IntegralAccountUpdReq;
import com.unionpay.account.model.IntegralAccountUpdRsp;
import com.unionpay.account.model.ValidateDataSignReq;
import com.unionpay.account.model.ValidateDataSignRsp;

/**
 * 
 * <p>Title: IntegralAccountService</p>
 * <p>Description:积分账户服务层接口</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月18日 下午2:43:14
 * @version 1.0
 *
 */
public interface IntegralAccountService
{
    /**
     * 
     * <p>Title: core</p>
     * <p>Description:新增积分账户请求服务接口</p>
     * @param integralAccountAddReq
     * @return
     * IntegralAccountAddRsp
     * @author li liang zhong
     * @date 2019年3月18日 下午3:06:38
     * @version 1.0
     */
	public IntegralAccountAddRsp insertIntegralAccount(IntegralAccountAddReq integralAccountAddReq);
	
	/**
	 * 
	 * <p>Title: core</p>
	 * <p>Description:更新积分账户请求服务接口</p>
	 * @param integralAccountUpdReq{integralAccountNo-积分账户编号:可选；orgCode-收单机构机构号:必填
	 * activeNoIntegral-未激活积分，当参数paymentFlag=23时，此参数必填
	 * }
	 * @return
	 * IntegralAccountUpdRsp
	 * @author li liang zhong
	 * @date 2019年3月18日 下午3:15:28
	 * @version 1.0
	 */
	public IntegralAccountUpdRsp updateIntegralAccount(IntegralAccountUpdReq integralAccountUpdReq);
	
	/**
	 * 
	 * <p>Title: core</p>
	 * <p>Description:查询积分账户信息</p>
	 * @param integralAccount
	 * @return
	 * IntegralAccountFindRsp
	 * @author li liang zhong
	 * @date 2019年3月18日 下午3:22:48
	 * @version 1.0
	 */
	public IntegralAccountFindRsp findIntegralAccount(IntegralAccountFindReq integralAccountFindReq);
	
	/**
	 * 
	 * <p>Title: core</p>
	 * <p>Description:检查积分账户的数据是否被篡改</p>
	 * @param validateDataSignReq{orgCode-机构号:必填 ；merchId-商户号:必填；integralAccountNo-账户号:可选}
	 * @return
	 * ValidateDataSignRsp{rspCode!=100000:表示商户账户数据不符合逻辑关联关系，比如：商户不存在或商户所属机构密钥不存在或商户账户不存在;
	 *                     signFlag=false:表示商户账户的数据被篡改;
	 *                     integralAccount:商户账户基本信息;
	 *                     secretKey:商户所属机构密钥}
	 * @author li liang zhong
	 * @date 2019年3月19日 上午9:45:05
	 * @version 1.0
	 */
	public ValidateDataSignRsp checkAccountSign(ValidateDataSignReq validateDataSignReq);
}
