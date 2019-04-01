package com.yh.service.union.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.yh.service.union.entitydata.TransactionNotifyReqData;
import com.yh.service.union.entitydata.TransactionNotifyRspData;
import com.yh.service.union.service.TransactionNotifyService;

@Controller
@RequestMapping("/vn/")
public class QuickPassController
{
    private static final Logger logger = Logger.getLogger(QuickPassController.class);
    
    @Autowired 
    TransactionNotifyService transactionNotifyService;
	
	@RequestMapping("trade/notice")
    public String processTradeNotify(@RequestBody TransactionNotifyReqData reqData)
    {
    	String message = null;
    	JSONObject rspData = new JSONObject();
    	try
    	{
    		TransactionNotifyRspData transactionNotifyRspData = transactionNotifyService.processTransactionNotify(reqData);
    		rspData.put("respCode", transactionNotifyRspData.getRespCode());
    		rspData.put("respMsg", transactionNotifyRspData.getRespMsg());
    	}
    	catch(Exception e)
    	{
    		message = "接收交易通知请求处理失败";
    		logger.error(message, e);
    	}
    	return rspData.toJSONString();
    }
}
