package com.unionpay.account.interfaces;

import com.unionpay.account.model.AccountTranReq;
import com.unionpay.account.model.AccountTranRsp;
import com.unionpay.dao.model.UpAccountTran;

/**
 * 
 * <p>Title: AccountTranService</p>
 * <p>Description: 积分账户变动流水服务层接口</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月18日 上午10:41:17
 * @version 1.0
 *
 */
public interface AccountTranService
{
    /**
     * 
     * <p>Title: core</p>
     * <p>Description:新增积分账户流水信息，录入场景:商户完成任务和交易奖励获取积分或兑换权益消耗积分时需要调用此接口服务</p>
     * @param accountTran
     * @return
     * int
     * @author li liang zhong
     * @date 2019年3月18日 上午10:43:20
     * @version 1.0
     */
	public AccountTranRsp insertAccountTran(AccountTranReq accountTran);
	
	/**
	 * 
	 * <p>Title: core</p>
	 * <p>Description:更新积分账户流水信息，场景:依赖外部接口确认积分交易状态时，需要调用此接口服务</p>
	 * @param accountTran
	 * @return
	 * int
	 * @author li liang zhong
	 * @date 2019年3月18日 上午10:45:55
	 * @version 1.0
	 */
	public int updateAccountTran(UpAccountTran accountTran);
	
	/**
	 * 
	 * <p>Title: core</p>
	 * <p>Description: 查询账户变动流水信息，场景:商户积分账户遇到被冻结时，需要通过账户变动流水恢复正确的账户信息</p>
	 * @param accountTran
	 * @return
	 * AccountTran
	 * @author li liang zhong
	 * @date 2019年3月18日 上午10:52:17
	 * @version 1.0
	 */
	public UpAccountTran findAccountTranInfo(UpAccountTran accountTran);
}
