package com.yh.service.union.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.yh.dao.model.TranList;
import com.yh.dao.repository.TranListMapper;
import com.yh.rocketmqframe.utils.RocketMQSend;
import com.yh.service.union.entitydata.TransactionNotifyReqData;
import com.yh.service.union.entitydata.TransactionNotifyRspData;
import com.yh.utils.DisposeUtil;
import com.yh.utils.EMErrorCode;
import com.yh.utils.IdWorker;
import com.yh.utils.RocketMQMessageTopic;

/**
 * 
 * <p>Title: TransactionNotifyService</p>
 * <p>Description: 处理交易通知逻辑数据处理</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年2月25日 下午3:40:02
 * @version 1.0
 *
 */
@Service
public class TransactionNotifyService
{
    private static final Logger logger = Logger.getLogger(TransactionNotifyService.class);
    
    @Autowired
    private TranListMapper tranListMapper;
    
    /**
     * step1:参数校验
     * step2:签名验证
     * step3:去重判断
     * step4:发送RMQ消息通知音箱系统
     * step5:根据积分规则匹配计算商户积分成长值
     * step6:联机交易通知数据入库处理
     */
    public TransactionNotifyRspData processTransactionNotify(TransactionNotifyReqData reqData)
    {
    	TransactionNotifyRspData transactionNotifyRspData = new TransactionNotifyRspData();
    	String message = null;
    	try
    	{
    		/**************step1:参数校验*****************************/
    		List<String> lists = new ArrayList<String>();
    		lists.add("currencyCode");
    		lists.add("reqReserved");
    		DisposeUtil.dispose(reqData, lists);
    		
    		/**************step2:数据重复判断**********************/
    		TranList tranNotify = new TranList();
    		tranNotify.setOrderNo(reqData.getOrderNo());
    		TranList orderResult = tranListMapper.findTransInfo(tranNotify);
    		if(orderResult != null && StringUtils.isNotBlank(orderResult.getTranNo()))
    		{
    			transactionNotifyRspData.setRespCode("00"); 
    			transactionNotifyRspData.setRespMsg("success");
    			return transactionNotifyRspData;
    		}
    		/****************step3:数据入库**************************/
    		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
    		String sendTime = sf.format(new Date());
    		Date updateTime = sf.parse(sendTime);
    		tranNotify.setMerchId(reqData.getMerId());
    		tranNotify.setCurrencyCd(reqData.getCurrencyCode());
    		tranNotify.setRemark("");
    		tranNotify.setId(IdWorker.genSeriaL16("11"));
    		tranNotify.setOrderNo(reqData.getOrderNo());
    		tranNotify.setTranAmt(new BigDecimal(reqData.getTxnAmt()));
    		tranNotify.setTranNo(reqData.getOrderNo());
    		tranNotify.setRpReserved(reqData.getReqReserved());
    		tranNotify.setPayAmt(new BigDecimal(reqData.getTxnAmt()));
    		tranNotify.setPayTime(reqData.getPayTime());
    		tranNotify.setUpdatedTime(updateTime);
    		int insertResult = tranListMapper.insertTranList(tranNotify);
    		logger.info("联机交易结果通知入库处理：" + insertResult);
    		
    		/****************step4:交易信息转接音箱系统播报********************/
    		JSONObject obj = new JSONObject();
    		obj.put("merId", reqData.getMerId());
    		obj.put("txnAmt", reqData.getTxnAmt());
    		obj.put("currencyCode", reqData.getCurrencyCode());
    		obj.put("orderNo", reqData.getOrderNo());
    		obj.put("payTime", reqData.getPayTime());
    		obj.put("reqReserved", reqData.getReqReserved());
    		obj.put("orderInfo", reqData.getOrderInfo());
    		String tags = UUID.randomUUID().toString();
    		String keys = tags.replaceAll("-", "") + System.currentTimeMillis();
    		String topic = RocketMQMessageTopic.RMQ_TRANS_NOTIFY;
    		boolean sendResult = RocketMQSend.sendRocketmqMessage(tags, keys, message, topic);
    		logger.info("联机交易支付结果通知结果发送:" + sendResult);
    	}
    	catch(Exception e)
    	{
    		message = "处理交易结果通知异常";
    		logger.error(message, e);
    		transactionNotifyRspData.setRespCode(EMErrorCode.PROGRAM_PROCESS_EXCEPTION.getMessageId());
    		transactionNotifyRspData.setRespMsg(message);
    	}
    	return transactionNotifyRspData;
    }
}
