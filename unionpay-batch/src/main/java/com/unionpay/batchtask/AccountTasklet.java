package com.unionpay.batchtask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.account.enums.EmTransStatus;
import com.unionpay.account.enums.EmTransType;
import com.unionpay.account.interfaces.IntegralAccountService;
import com.unionpay.account.model.AccountTranReq;
import com.unionpay.account.model.ValidateDataSignReq;
import com.unionpay.account.model.ValidateDataSignRsp;
import com.unionpay.account.sercurity.SignUtils;
import com.unionpay.account.utils.BeanConverter;
import com.unionpay.account.utils.SnowflakeIdWorker;
import com.unionpay.dao.model.UpAccountTran;
import com.unionpay.dao.model.UpIntegralAccount;
import com.unionpay.dao.repository.UpAccountTranMapper;
import com.unionpay.dao.repository.UpIntegralAccountMapper;

public class AccountTasklet implements Tasklet
{
    private static final Logger logger = LoggerFactory.getLogger(AccountTasklet.class);
    
    private static final Integer handBaseNum = 5000;
	
    @Autowired
    private UpIntegralAccountMapper upIntegralAccountMapper;
    @Autowired
    private IntegralAccountService integralAccountService;
//    @Autowired
//    private AccountTranService accountTranService;
    @Autowired
    private UpAccountTranMapper accountTranMapper;
    
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception
	{
		logger.info("===============启用账户跑批任务=================");
		Map<String, Object> parameters = chunkContext.getStepContext().getJobParameters();
		Long total = upIntegralAccountMapper.findAccountTotal(parameters);
		logger.info("查询商户账户信息的总记录数===>" + total);
		if(total == null || total == 0)
			return RepeatStatus.FINISHED;
		logger.info("==============批处理业务开始=====================");
		Integer pageSize = handBaseNum;
		Long totalPage = total / handBaseNum;
		Long currPage = (totalPage == 0 || totalPage == 1) ? 1 : totalPage + 1; //总页数
		Long currIndex = null;
		List<UpIntegralAccount> listsAccount = null;
		logger.info("============完成基础数据准备=============" + currPage);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		try
		{
			for(long i = 1; i <= currPage; i ++)
			{
				currIndex = (i-1) * pageSize;
				dataMap.put("currIndex", currIndex);
				dataMap.put("pageSize", pageSize);
				dataMap.put("changeDate", parameters.get("changeDate"));
				listsAccount = upIntegralAccountMapper.findListAccount(dataMap);
				handleIntegralComput(listsAccount);
			}
		}
		catch(Exception e)
		{
			logger.error("批处理任务处理失败", e);
		}
		logger.info("ExitStatus=" + contribution.getExitStatus() + 
		";FilterCount=" + contribution.getFilterCount() + 
		";ReadCount=" + contribution.getReadCount() + 
		";SkipCount=" + contribution.getSkipCount() + 
		";WriteCount=" + contribution.getWriteCount() + 
		";WriteSkipCount=" + contribution.getWriteSkipCount() + 
		";ProcessSkipCount=" + contribution.getProcessSkipCount());
		logger.info("JobParameters=" + chunkContext.getStepContext().getJobParameters());
		logger.info("JobExecutionContext=" + chunkContext.getStepContext().getJobExecutionContext());
		logger.info("PartitionPlan=" + chunkContext.getStepContext().getPartitionPlan());
		logger.info("StepExecution=" + chunkContext.getStepContext().getStepExecution());
		logger.info("StepContext=" + chunkContext.getStepContext().getId());
		return RepeatStatus.FINISHED;
	}
	
	public Map<String, String> handleIntegralComput(List<UpIntegralAccount> listsAccount)
	{
		String errorMessage = null;
		Map<String, String> resultMap = new HashMap<String, String>();
		logger.info("========进入业务处理方法=================" + listsAccount);
		if(listsAccount == null || listsAccount.size() == 0)
		{
			resultMap.put("code", "00");
			return resultMap;
		}
		try
		{
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String newDate = sf.format(new Date());
			Date accountChangeTime = sf.parse(newDate);
			String changeDate = newDate.substring(0, 10);
			for(UpIntegralAccount upIntegralAccount : listsAccount)
			{
				Long activeNoIntegral = upIntegralAccount.getActiveNoIntegral();
				if(activeNoIntegral == 0)
					continue;
				Long availableBalance = upIntegralAccount.getAvailableBalance();
				Long newAvailableBalance = activeNoIntegral + availableBalance;
				upIntegralAccount.setAvailableBalance(newAvailableBalance); //可用积分余额
				upIntegralAccount.setActiveNoIntegral(new Long(0));  //清零
				upIntegralAccount.setChangeDate(changeDate);
				upIntegralAccount.setAccountChangeTime(accountChangeTime);
				ValidateDataSignReq validateDataSignReq = new ValidateDataSignReq();
				validateDataSignReq.setMerchId(upIntegralAccount.getMerchId());
				validateDataSignReq.setOrgCode(upIntegralAccount.getOrgCode());
				ValidateDataSignRsp validateDataSignRsp = 
						integralAccountService.checkAccountSign(validateDataSignReq);
				if(validateDataSignRsp.getRspCode() != 100000)
				{
					resultMap.put("code", "02");
					resultMap.put("message", validateDataSignRsp.getRspMessage());
					continue;
				}
				else if(!validateDataSignRsp.getSignFlag())
				{
					resultMap.put("code", "03");
					resultMap.put("message", validateDataSignRsp.getRspMessage());
					continue;
				}
				String secretKey = validateDataSignRsp.getSecretKey();
				String newSign = SignUtils.getAccountSign(upIntegralAccount, secretKey);
				if(newSign == null)
					continue;
				upIntegralAccount.setTemper(newSign);
				AccountTranReq accountTran = BeanConverter.convertBean(upIntegralAccount, AccountTranReq.class);
				accountTran.setEndBalance(newAvailableBalance);
				accountTran.setPointAmount(activeNoIntegral);
				accountTran.setInitialBalance(availableBalance);
				accountTran.setStatus(EmTransStatus.SUCCESS_TRANS.getTransStatus());
				accountTran.setTranRemark("商户积分账户日终批处理-未激活积分转化为可用积分");
				accountTran.setRemark("商户积分账户日终批处理");
				accountTran.setTranTime(accountChangeTime);
				insertDB(upIntegralAccount, accountTran);
			}
		}
		catch(Exception e)
		{
			errorMessage = "处理分页商户积分账户失败";
			logger.error(errorMessage, e);
			resultMap.put("code", "01");
			resultMap.put("message", errorMessage);
		}
		return resultMap;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void insertDB(UpIntegralAccount upIntegralAccount, AccountTranReq accountTranReq) throws Exception
	{
		if(upIntegralAccount == null || accountTranReq == null)
			return;
		upIntegralAccountMapper.updateByPrimaryKey(upIntegralAccount);
		UpAccountTran record = BeanConverter.convertBean(accountTranReq, UpAccountTran.class);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createdTimeStr = sf.format(new Date());
		Date createdTime = sf.parse(createdTimeStr);
		SnowflakeIdWorker idWorker = new SnowflakeIdWorker(11, 22);
		String transId = String.valueOf(idWorker.nextId());
		record.setCreatedTime(createdTime);
		record.setTranId(transId);
		record.setTranType(EmTransType.RECHARGE.getTransType());
		int addResult = accountTranMapper.insert(record);
		if(addResult <= 0)
			throw new Exception("账户变动流水入库失败");
	}
}
