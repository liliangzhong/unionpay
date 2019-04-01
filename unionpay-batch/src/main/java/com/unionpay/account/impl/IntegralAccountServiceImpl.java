package com.unionpay.account.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.account.enums.EmAccountType;
import com.unionpay.account.enums.EmConsumptionMark;
import com.unionpay.account.enums.EmErrorCode;
import com.unionpay.account.enums.EmIntegralAccountStatus;
import com.unionpay.account.enums.EmKeyType;
import com.unionpay.account.enums.EmTransStatus;
import com.unionpay.account.enums.EmTransType;
import com.unionpay.account.interfaces.AccountTranService;
import com.unionpay.account.interfaces.IntegralAccountService;
import com.unionpay.account.model.AccountTranReq;
import com.unionpay.account.model.AccountTranRsp;
import com.unionpay.account.model.IntegralAccountAddReq;
import com.unionpay.account.model.IntegralAccountAddRsp;
import com.unionpay.account.model.IntegralAccountFindReq;
import com.unionpay.account.model.IntegralAccountFindRsp;
import com.unionpay.account.model.IntegralAccountUpdReq;
import com.unionpay.account.model.IntegralAccountUpdRsp;
import com.unionpay.account.model.ValidateDataSignReq;
import com.unionpay.account.model.ValidateDataSignRsp;
import com.unionpay.account.sercurity.SignUtils;
import com.unionpay.account.utils.BeanConverter;
import com.unionpay.account.utils.DisposeUtil;
import com.unionpay.account.utils.SnowflakeIdWorker;
import com.unionpay.dao.model.InterfaceKey;
import com.unionpay.dao.model.UpIntegralAccount;
import com.unionpay.dao.repository.InterfaceKeyMapper;
import com.unionpay.dao.repository.UpIntegralAccountMapper;

/**
 * 
 * <p>Title: IntegralAccountServiceImpl</p>
 * <p>Description:积分账户服务层接口实现处理</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月18日 下午3:24:04
 * @version 1.0
 *
 */
@Service
public class IntegralAccountServiceImpl implements IntegralAccountService
{
    private final static Logger logger = LoggerFactory.getLogger(IntegralAccountServiceImpl.class);
	
    @Autowired
    private UpIntegralAccountMapper integralAccountMapper;
    @Autowired
    private InterfaceKeyMapper interfaceKeyMapper;
    @Autowired
    private AccountTranService accountTranService;
    
    
	@Override
	@Transactional(rollbackFor=Exception.class)
	public IntegralAccountAddRsp insertIntegralAccount(IntegralAccountAddReq integralAccountAddReq)
	{
		String errorMessage = null;
		IntegralAccountAddRsp integralAccountAddRsp = new IntegralAccountAddRsp();
		try
		{
			/*************参数校验********************/
			List<String> fields = new ArrayList<String>();
			fields.add("accountChangeTime");
			fields.add("accountStatus");
			fields.add("blockedBalance");
			fields.add("availableBalance");
			fields.add("activeNoIntegral");
			fields.add("accountType");
			fields.add("integralAccountNo");
			DisposeUtil.dispose(integralAccountAddReq, fields);
			/***************账户去重判断****************/
			UpIntegralAccount findAccount = new UpIntegralAccount();
			findAccount.setOrgCode(integralAccountAddReq.getOrgCode());
			findAccount.setMerchId(integralAccountAddReq.getMerchId());
			UpIntegralAccount findResult = integralAccountMapper.findAccount(findAccount);
			if(findResult != null && findResult.getIntegralAccountNo() != null)
			{
				errorMessage = "商户积分账户已存在";
				integralAccountAddRsp = BeanConverter.convertBean(findResult, IntegralAccountAddRsp.class);
				integralAccountAddRsp.setRspCode(EmErrorCode.SUCCESS.getId());
				return integralAccountAddRsp;
			}
			/****************生成账户防篡改签名*****************/
			InterfaceKey interfaceKey = new InterfaceKey();
			interfaceKey.setBranchId(integralAccountAddReq.getOrgCode());
			interfaceKey.setKeyType(EmKeyType.MD5_KEY.getKeyId()); //01-MD5 02-RSA256 03-AES
			List<InterfaceKey> listInterfaceKeys = interfaceKeyMapper.selectInterfaceKeyList(interfaceKey);
			if(listInterfaceKeys == null || listInterfaceKeys.get(0) == null
					|| listInterfaceKeys.size() == 0)
			{
				errorMessage = "查询机构编号【" + integralAccountAddReq.getOrgCode() + "】的密钥为空";
				logger.error(errorMessage + "===>新建商户积分账户失败");
				integralAccountAddRsp.setRspCode(EmErrorCode.ORG_SECRET_KEY_EXCEPTION.getId());
				integralAccountAddRsp.setRspMessage(errorMessage);
				throw new Exception(errorMessage);
			}
			UpIntegralAccount record = BeanConverter.convertBean(integralAccountAddReq, UpIntegralAccount.class);
			SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(13, 23);
			String integralAccountNo =  "62"+ String.valueOf(snowflakeIdWorker.nextId());
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date createdTime = sf.parse(sf.format(new Date()));
			record.setAvailableBalance(new Long(0));
			record.setBlockedBalance(new Long(0));
			record.setAccountType(EmAccountType.INTEGRAL_ACCOUNT.getAccountTypeId());       //10-积分账户
			record.setAccountStatus(EmIntegralAccountStatus.AVAILABLE.getAccountStatus());     //00-可用 01-禁用 ; 账户状态,默认可用
			record.setIntegralAccountNo(integralAccountNo);
			record.setCreatedTime(createdTime);
			record.setAccountChangeTime(createdTime);  //账户新建时的账户变动时间和创建时间一致
			InterfaceKey interfaceKeyResult = listInterfaceKeys.get(0);
			String secretKey = interfaceKeyResult.getKeyContent();
			String temper = SignUtils.getAccountSign(record, secretKey);
			if(StringUtils.isBlank(temper))
			{
				errorMessage = "生成商户[" + integralAccountAddReq.getMerchId() + "]账户签名失败";
				logger.error(errorMessage + "==>新建商户请求参数===》" + integralAccountAddReq);
				integralAccountAddRsp.setRspCode(EmErrorCode.ADD_DB_EXCEPTION.getId());
				integralAccountAddRsp.setRspMessage(errorMessage);
				throw new Exception(errorMessage);
			}
			record.setTemper(temper);
			/*************************积分入账入库,账户变动流水入库*************************/
			int addResult = integralAccountMapper.insert(record);
			if(addResult <= 0)
			{
				errorMessage = "商户[" + integralAccountAddReq.getMerchId() + "]新建账户失败";
				logger.error(errorMessage + "==>新建商户请求参数===》" + integralAccountAddReq);
				integralAccountAddRsp.setRspCode(EmErrorCode.ADD_DB_EXCEPTION.getId());
				integralAccountAddRsp.setRspMessage(errorMessage);
				throw new Exception(errorMessage);
			}
			AccountTranReq addAccountTran = BeanConverter.convertBean(record, AccountTranReq.class);
			addAccountTran.setInitialBalance(new Long(0));     //期初余额
			addAccountTran.setPointAmount(integralAccountAddReq.getActiveNoIntegral());  //交易发生额
			addAccountTran.setEndBalance(integralAccountAddReq.getActiveNoIntegral());             //期末余额
			addAccountTran.setStatus(EmTransStatus.SUCCESS_TRANS.getTransStatus());                     //交易状态
			addAccountTran.setTranRemark("商户入网系统匹配积分规则自动获取积分");             //交易摘要
			addAccountTran.setTranType(EmTransType.RECHARGE.getTransType());                 //交易类型
			addAccountTran.setIntegralAccountNo(integralAccountNo); //交易主账号
			addAccountTran.setTranTime(record.getCreatedTime());    //交易完成时间
			AccountTranRsp accountTranRsp = accountTranService.insertAccountTran(addAccountTran);
			if(EmErrorCode.SUCCESS.getId() != accountTranRsp.getRspCode())
			{
				errorMessage = "新增账户充值流水失败===》" + accountTranRsp.getRspMessage();
				logger.error(errorMessage);
				integralAccountAddRsp.setRspCode(EmErrorCode.ADD_DB_EXCEPTION.getId());
				integralAccountAddRsp.setRspMessage(errorMessage);
				throw new Exception(errorMessage);
			}
			integralAccountAddRsp = BeanConverter.convertBean(record, IntegralAccountAddRsp.class);
			integralAccountAddRsp.setRspCode(EmErrorCode.SUCCESS.getId());
		}
		catch(Exception e)
		{
			errorMessage = "新增商户积分账户失败==>";
			logger.error(errorMessage, e);
			integralAccountAddRsp.setRspCode(EmErrorCode.PROGRAM_HANDLE_EXCEPTION.getId());
			integralAccountAddRsp.setRspMessage(errorMessage + e.getMessage());
			return integralAccountAddRsp;
		}
		return integralAccountAddRsp;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public IntegralAccountUpdRsp updateIntegralAccount(IntegralAccountUpdReq integralAccountUpdReq)
	{
		String errorMessage = null;
		IntegralAccountUpdRsp integralAccountUpdRsp = new IntegralAccountUpdRsp();
		try
		{
			/*********************参数校验**********************/
			List<String> fields = new ArrayList<String>();
			fields.add("activeNoIntegral");
			fields.add("availableBalance");
			DisposeUtil.dispose(integralAccountUpdReq, fields);
			
			/*********************校验账户信息是否被篡改***********************/
			UpIntegralAccount record = BeanConverter.convertBean(integralAccountUpdReq, UpIntegralAccount.class);
			ValidateDataSignReq validateDataSignReq = BeanConverter.convertBean(integralAccountUpdReq, ValidateDataSignReq.class);
			ValidateDataSignRsp validateDataSignRsp = checkAccountSign(validateDataSignReq);
			if(EmErrorCode.SUCCESS.getId() != validateDataSignRsp.getRspCode())
			{
				integralAccountUpdRsp = BeanConverter.convertBean(validateDataSignRsp, IntegralAccountUpdRsp.class);
				return integralAccountUpdRsp;
			}
			else if(!validateDataSignRsp.getSignFlag())
			{
				integralAccountUpdRsp = BeanConverter.convertBean(validateDataSignRsp, IntegralAccountUpdRsp.class);
				integralAccountUpdRsp.setRspCode(EmErrorCode.VALIDATE_SIGN_FAIL.getId());
				return integralAccountUpdRsp;
			}
			UpIntegralAccount accountResult = validateDataSignRsp.getIntegralAccount();
			String secretKey = validateDataSignRsp.getSecretKey();
			
			/*********************积分入账或扣除*****************************/
			//收入/支出 积分
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date accountChangeTime = sf.parse(sf.format(new Date()));
			record.setAccountChangeTime(accountChangeTime);
			String paymentFlag = integralAccountUpdReq.getPaymentFlag();
			Long updIntegral = new Long(0);
			Long transIntegral = integralAccountUpdReq.getTransIntegral();
			if(paymentFlag.equalsIgnoreCase(EmConsumptionMark.INTEGRAL_INCOM.getPaymentFlagId()))
			{
				updIntegral = accountResult.getActiveNoIntegral() + transIntegral;
				record.setActiveNoIntegral(updIntegral);
			}
			else if(paymentFlag.equalsIgnoreCase(EmConsumptionMark.INTEGRAL_PAY.getPaymentFlagId()))
			{
				updIntegral = accountResult.getAvailableBalance() - transIntegral;
				record.setAvailableBalance(updIntegral);
			}
			else
			{
				errorMessage = "参数[paymentFlag]的值有误";
				logger.error(errorMessage);
				integralAccountUpdRsp.setRspCode(EmErrorCode.REQUEST_DATA_EXCEPTION.getId());
				integralAccountUpdRsp.setRspMessage(errorMessage);
				return integralAccountUpdRsp;
			}
			/**************重新生成账户安全信息签名并更新账户信息*********************/
			String newSign = SignUtils.getAccountSign(record, secretKey);
			record.setTemper(newSign);
			int updateResult = integralAccountMapper.updateByPrimaryKey(record);
			if(updateResult <= 0)
			{
				errorMessage = "商户[" + integralAccountUpdReq.getMerchId() + "]更新账户失败";
				logger.error(errorMessage + "==>更新商户账户请求参数===》" + integralAccountUpdReq);
				integralAccountUpdRsp.setRspCode(EmErrorCode.UPDATE_DB_EXCEPTION.getId());
				integralAccountUpdRsp.setRspMessage(errorMessage);
				throw new Exception(errorMessage);
			}
			/***********************新增账户变动流水**************************/
			AccountTranReq addAccountTran = BeanConverter.convertBean(record, AccountTranReq.class);
			addAccountTran.setInitialBalance(accountResult.getActiveNoIntegral());     //期初余额
			addAccountTran.setPointAmount(integralAccountUpdReq.getActiveNoIntegral());  //交易发生额
			addAccountTran.setEndBalance(updIntegral);             //期末余额
			addAccountTran.setStatus(EmTransStatus.SUCCESS_TRANS.getTransStatus());                     //交易状态
			//addAccountTran.setTranRemark("商户入网系统匹配积分规则自动获取积分");             //交易摘要
			addAccountTran.setTranType(EmTransType.PAYMENT.getTransType());                 //交易类型
			addAccountTran.setIntegralAccountNo(integralAccountUpdReq.getIntegralAccountNo()); //交易主账号
			addAccountTran.setTranTime(record.getCreatedTime());    //交易完成时间
			AccountTranRsp accountTranRsp = accountTranService.insertAccountTran(addAccountTran);
			if(EmErrorCode.SUCCESS.getId() != accountTranRsp.getRspCode())
			{
				errorMessage = "新增账户充值流水失败===》" + accountTranRsp.getRspMessage();
				logger.error(errorMessage);
				integralAccountUpdRsp.setRspCode(EmErrorCode.ADD_DB_EXCEPTION.getId());
				integralAccountUpdRsp.setRspMessage(errorMessage);
				throw new Exception(errorMessage);
			}
			/************构造响应对象返回********************/
			integralAccountUpdRsp = BeanConverter.convertBean(record, IntegralAccountUpdRsp.class);
			integralAccountUpdRsp.setRspCode(EmErrorCode.SUCCESS.getId());
		}
		catch(Exception e)
		{
			errorMessage = "更新积分账户失败==>";
			logger.error(errorMessage, e);
			integralAccountUpdRsp.setRspCode(EmErrorCode.PROGRAM_HANDLE_EXCEPTION.getId());
			integralAccountUpdRsp.setRspMessage(errorMessage + e.getMessage());
			return integralAccountUpdRsp;
		}
		return integralAccountUpdRsp;
	}

	@Override
	public IntegralAccountFindRsp findIntegralAccount(IntegralAccountFindReq integralAccountFindReq)
	{
		String errorMessage = null;
		IntegralAccountFindRsp integralAccountFindRsp = new IntegralAccountFindRsp();
		try
		{
			List<String> fields = new ArrayList<String>();
			fields.add("integralAccountNo");
			DisposeUtil.dispose(integralAccountFindReq, fields);
			ValidateDataSignReq validateDataSignReq = BeanConverter.convertBean(integralAccountFindReq, ValidateDataSignReq.class);
			ValidateDataSignRsp validateDataSignRsp = checkAccountSign(validateDataSignReq);
			if(EmErrorCode.SUCCESS.getId() != validateDataSignRsp.getRspCode())
			{
				integralAccountFindRsp = BeanConverter.convertBean(validateDataSignRsp, IntegralAccountFindRsp.class);
				return integralAccountFindRsp;
			}
			else if(!validateDataSignRsp.getSignFlag())
			{
				integralAccountFindRsp = BeanConverter.convertBean(validateDataSignRsp, IntegralAccountFindRsp.class);
				integralAccountFindRsp.setRspCode(EmErrorCode.VALIDATE_SIGN_FAIL.getId());
				return integralAccountFindRsp;
			}
			UpIntegralAccount accountResult = validateDataSignRsp.getIntegralAccount();
			integralAccountFindRsp = BeanConverter.convertBean(accountResult, IntegralAccountFindRsp.class);
			integralAccountFindRsp.setRspCode(EmErrorCode.SUCCESS.getId());
		}
		catch(Exception e)
		{
			errorMessage = "查询积分账户信息失败";
			integralAccountFindRsp.setRspCode(EmErrorCode.PROGRAM_HANDLE_EXCEPTION.getId());
			integralAccountFindRsp.setRspMessage(errorMessage + e.getMessage());
			logger.error(errorMessage, e);
		}
		return integralAccountFindRsp;
	}

	@Override
	public ValidateDataSignRsp checkAccountSign(ValidateDataSignReq record)
	{
		String errorMessage = null;
		ValidateDataSignRsp validateDataSignRsp = new ValidateDataSignRsp();
		try
		{
			List<String> fields = new ArrayList<String>();
			fields.add("integralAccountNo");
			DisposeUtil.dispose(record, fields);
			UpIntegralAccount integralAccount = BeanConverter.convertBean(record, UpIntegralAccount.class);
			String integralAccountNo = record.getIntegralAccountNo();
			UpIntegralAccount accountResult = null;
			if(StringUtils.isNotBlank(integralAccountNo))
				accountResult = integralAccountMapper.selectByPrimaryKey(integralAccountNo);
			else
				accountResult = integralAccountMapper.findAccount(integralAccount);
			if(accountResult == null || accountResult.getIntegralAccountNo() == null)
			{
				errorMessage = "查询商户[" + record.getMerchId() + "]的账户信息不存在";
				logger.error(errorMessage);
				validateDataSignRsp.setRspCode(EmErrorCode.DATA_NOT_EXISTENT.getId());
				validateDataSignRsp.setRspMessage(errorMessage);
				return validateDataSignRsp;
			}
			InterfaceKey interfaceKey = new InterfaceKey();
			interfaceKey.setBranchId(record.getOrgCode());
			interfaceKey.setKeyType(EmKeyType.MD5_KEY.getKeyId()); //01-MD5 02-RSA256 03-AES
			List<InterfaceKey> listInterfaceKeys = interfaceKeyMapper.selectInterfaceKeyList(interfaceKey);
			if(listInterfaceKeys == null || listInterfaceKeys.get(0) == null
					|| listInterfaceKeys.size() == 0)
			{
				errorMessage = "查询机构编号【" + record.getOrgCode() + "】的密钥为空";
				logger.error(errorMessage);
				validateDataSignRsp.setRspCode(EmErrorCode.ORG_SECRET_KEY_EXCEPTION.getId());
				validateDataSignRsp.setRspMessage(errorMessage);
				return validateDataSignRsp;
			}
			String temper = accountResult.getTemper();
			InterfaceKey interfaceKeyResult = listInterfaceKeys.get(0);
			String secretKey = interfaceKeyResult.getKeyContent();
			String sign = SignUtils.getAccountSign(accountResult, secretKey);
			logger.info("新签名======>" + sign);
			if(!sign.equals(temper))
			{
				errorMessage = "积分账户[" + accountResult.getIntegralAccountNo() + "]的信息被篡改";
				logger.error(errorMessage);
				validateDataSignRsp.setRspCode(EmErrorCode.SUCCESS.getId());
				validateDataSignRsp.setRspMessage(errorMessage);
				validateDataSignRsp.setSignFlag(false);
				return validateDataSignRsp;
			}
			validateDataSignRsp.setRspCode(EmErrorCode.SUCCESS.getId());
			validateDataSignRsp.setSignFlag(true);
			validateDataSignRsp.setIntegralAccount(accountResult);
			validateDataSignRsp.setSecretKey(secretKey);
		}
		catch(Exception e)
		{
			errorMessage = "校验账户数据失败";
			logger.error(errorMessage, e);
			validateDataSignRsp.setRspCode(EmErrorCode.PROGRAM_HANDLE_EXCEPTION.getId());
			validateDataSignRsp.setRspMessage(errorMessage);
			return validateDataSignRsp;
		}
		return validateDataSignRsp;
	}
}
