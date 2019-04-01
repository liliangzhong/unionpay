package com.unionpay.account.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unionpay.account.enums.EmErrorCode;
import com.unionpay.account.interfaces.AccountTranService;
import com.unionpay.account.model.AccountTranReq;
import com.unionpay.account.model.AccountTranRsp;
import com.unionpay.account.utils.BeanConverter;
import com.unionpay.account.utils.DisposeUtil;
import com.unionpay.account.utils.SnowflakeIdWorker;
import com.unionpay.dao.model.UpAccountTran;
import com.unionpay.dao.repository.UpAccountTranMapper;


/**
 * 
 * <p>Title: AccountTranServiceImpl</p>
 * <p>Description:积分账户变动流水信息服务层实现</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月18日 上午10:57:51
 * @version 1.0
 *
 */
@Service
public class AccountTranServiceImpl implements AccountTranService
{
    private final static Logger logger = LoggerFactory.getLogger(AccountTranServiceImpl.class);
    
    @Autowired
    private UpAccountTranMapper accountTranMapper;
	
	@Override
	public AccountTranRsp insertAccountTran(AccountTranReq accountTranReq)
	{
		String errorMessage = null;
		AccountTranRsp accountTranRsp = new AccountTranRsp();
		try
		{
			List<String> lists = new ArrayList<String>();
			lists.add("tranId");
			lists.add("tranTime");
			lists.add("remark");
			DisposeUtil.dispose(accountTranReq, lists);
			UpAccountTran record = BeanConverter.convertBean(accountTranReq, UpAccountTran.class);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String createdTimeStr = sf.format(new Date());
			Date createdTime = sf.parse(createdTimeStr);
			SnowflakeIdWorker idWorker = new SnowflakeIdWorker(11, 22);
			String transId = String.valueOf(idWorker.nextId());
			record.setCreatedTime(createdTime);
			record.setTranId(transId);
			int addResult = accountTranMapper.insert(record);
			if(addResult <= 0)
			{
				errorMessage = "新增账户变动流水失败";
				accountTranRsp.setRspCode(EmErrorCode.ADD_DB_EXCEPTION.getId());
				accountTranRsp.setRspMessage(errorMessage);
				logger.error(errorMessage + "  请求入库数据====》   " + accountTranReq);
				return accountTranRsp;
			}
			accountTranRsp.setTransId(transId);
			accountTranRsp.setRspCode(EmErrorCode.SUCCESS.getId());
			accountTranRsp.setIntegralAccountNo(accountTranReq.getIntegralAccountNo());
		}
		catch(Exception e)
		{
			errorMessage = "新增积分账户变动流水处理失败==> ";
			accountTranRsp.setRspCode(EmErrorCode.ADD_DB_EXCEPTION.getId());
			accountTranRsp.setRspMessage(errorMessage + e.getMessage());
			logger.error(errorMessage + "  请求入库数据====》   " + accountTranReq);
		}
		return accountTranRsp;
	}

	@Override
	public int updateAccountTran(UpAccountTran accountTran)
	{
		return accountTranMapper.updateByPrimaryKey(accountTran);
	}

	@Override
	public UpAccountTran findAccountTranInfo(UpAccountTran accountTran)
	{
		return accountTranMapper.selectByPrimaryKey(accountTran.getTranId());
	}

}
