package com.yh.service.union.service;


import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.yh.hadoop.HDFSTool;
import com.yh.kafkaframe.consumer.KafkaBaseService;

/**
 * 
 * <p>Title: BigDataBaseConsumerService</p>
 * <p>Description:大数据仓库消费实现类</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月4日 下午7:48:22
 * @version 1.0
 *
 */
public class BigDataBaseConsumerService extends KafkaBaseService
{
    private final static Logger logger = Logger.getLogger(BigDataBaseConsumerService.class);
    private String outTopic = null;

    public BigDataBaseConsumerService(String intopic)
    {
    	outTopic = intopic;
    }
	
	@Override
	public void loadTopics()
	{
		getVctTopic().add(outTopic);
	}
    /**
     *  tfr_dt_tm, acpt_ins_id_cd, msg_fwd_ins_id_cd, trans_rcv_ts
		,trans_fin_ts, trans_id, trans_id_conv, trans_cd ,trans_cd_conv
		,trans_tp, acpt_resp_cd, iss_resp_cd, fwd_proc_in, rcv_proc_in
		,trans_st, rsn_cd, risk_in, pri_acct_no, pri_acct_no_conv, card_bin
		,buss_card_bin, cups_card_in, cups_sig_card_in, card_class, card_cata
		,card_attr, card_media, card_brand, card_prod, card_lvl, trans_media
		,ic_app_tp, trans_chnl, real_fwd_ins_id_cd, iss_ins_id_cd, cross_dist_in
		,cross_region_in, iss_ins_tp, rcv_ins_tp, settle_dt, settle_mon, settle_d
		,trans_at, trans_curr_cd, trans_curr_cd_conv, loc_trans_tm, loc_trans_dt
		,mchnt_tp, acpt_ins_cntry_cd, pos_entry_md_cd, pos_cond_cd, pos_cond_cd_conv
		,term_id, mchnt_cd, addn_pos_inf, inter_md, trans_snd_md, cups_def_fld
		,cups_def_fld_conv, certif_tp, certif_id, cups_resv, acpt_ins_resv, iss_ins_resv
		,natl_region_inf 
     */
	@Override
	public void doService(ConsumerRecord<String, String> message, long threadID)
	{
		String errorMessage = null;
		try
		{
			logger.info("topic----> " + message.topic() + " --->key=" + message.key() + " ---->value=" + message.value()
			+ " --->offset=" + message.offset() + "--->partition=" + message.partition());
			String messageStr = message.value();
			if(StringUtils.isBlank(messageStr))
			    return;
			JSONObject messageData = JSONObject.parseObject(messageStr);
			JSONObject sendData = new JSONObject();
			sendData.put("tfr_dt_tm", messageData.get("tfr_dt_tm"));
			sendData.put("acpt_ins_id_cd", messageData.get("acpt_ins_id_cd"));
			sendData.put("msg_fwd_ins_id_cd", messageData.get("msg_fwd_ins_id_cd"));
			sendData.put("trans_rcv_ts", messageData.get("trans_rcv_ts"));
			sendData.put("trans_fin_ts", messageData.get("trans_fin_ts"));
			sendData.put("trans_id_conv", messageData.get("trans_id_conv"));
			sendData.put("trans_id", messageData.get("trans_id"));
			sendData.put("trans_cd", messageData.get("trans_cd"));
			sendData.put("trans_cd_conv", messageData.get("trans_cd_conv"));
			sendData.put("trans_tp", messageData.get("trans_tp"));
			sendData.put("acpt_resp_cd", messageData.get("acpt_resp_cd"));
			sendData.put("iss_resp_cd", messageData.get("iss_resp_cd"));
			sendData.put("fwd_proc_in", messageData.get("fwd_proc_in"));
			sendData.put("rcv_proc_in", messageData.get("rcv_proc_in"));
			sendData.put("trans_st", messageData.get("trans_st"));
			sendData.put("rsn_cd", messageData.get("rsn_cd"));
			sendData.put("risk_in", messageData.get("risk_in"));
			sendData.put("pri_acct_no", messageData.get("pri_acct_no"));
			sendData.put("pri_acct_no_conv", messageData.get("pri_acct_no_conv"));
			sendData.put("card_bin", messageData.get("card_bin"));
			sendData.put("buss_card_bin", messageData.get("buss_card_bin"));
			sendData.put("cups_card_in", messageData.get("cups_card_in"));
			sendData.put("cups_sig_card_in", messageData.get("cups_sig_card_in"));
			sendData.put("card_class", messageData.get("card_class"));
			sendData.put("card_cata", messageData.get("card_cata"));
			sendData.put("card_attr", messageData.get("card_attr"));
			sendData.put("card_media", messageData.get("card_media"));
			sendData.put("card_brand", messageData.get("card_brand"));
			sendData.put("card_prod", messageData.get("card_prod"));
			sendData.put("card_lvl", messageData.get("card_lvl"));
			sendData.put("trans_media", messageData.get("trans_media"));
			sendData.put("ic_app_tp", messageData.get("ic_app_tp"));
			sendData.put("trans_chnl", messageData.get("trans_chnl"));
			sendData.put("real_fwd_ins_id_cd", messageData.get("real_fwd_ins_id_cd"));
			sendData.put("iss_ins_id_cd", messageData.get("iss_ins_id_cd"));
			sendData.put("cross_dist_in", messageData.get("cross_dist_in"));
			sendData.put("cross_region_in", messageData.get("cross_region_in"));
			sendData.put("iss_ins_tp", messageData.get("iss_ins_tp"));
			sendData.put("rcv_ins_tp", messageData.get("rcv_ins_tp"));
			sendData.put("settle_dt", messageData.get("settle_dt"));
			sendData.put("settle_mon", messageData.get("settle_mon"));
			sendData.put("settle_d", messageData.get("settle_d"));
			sendData.put("trans_at", messageData.get("trans_at"));
			sendData.put("trans_curr_cd", messageData.get("trans_curr_cd"));
			sendData.put("trans_curr_cd_conv", messageData.get("trans_curr_cd_conv"));
			sendData.put("loc_trans_tm", messageData.get("loc_trans_tm"));
			sendData.put("loc_trans_dt", messageData.get("loc_trans_dt"));
			sendData.put("mchnt_tp", messageData.get("mchnt_tp"));
			sendData.put("acpt_ins_cntry_cd", messageData.get("acpt_ins_cntry_cd"));
			sendData.put("pos_entry_md_cd", messageData.get("pos_entry_md_cd"));
			sendData.put("pos_cond_cd", messageData.get("pos_cond_cd"));
			sendData.put("pos_cond_cd_conv", messageData.get("pos_cond_cd_conv"));
			sendData.put("term_id", messageData.get("term_id"));
			sendData.put("mchnt_cd", messageData.get("mchnt_cd"));
			sendData.put("addn_pos_inf", messageData.get("addn_pos_inf"));
			sendData.put("inter_md", messageData.get("inter_md"));
			sendData.put("trans_snd_md", messageData.get("trans_snd_md"));
			sendData.put("cups_def_fld", messageData.get("cups_def_fld"));
			sendData.put("cups_def_fld_conv", messageData.get("cups_def_fld_conv"));
			sendData.put("certif_tp", messageData.get("certif_tp"));
			sendData.put("certif_id", messageData.get("certif_id"));
			sendData.put("cups_resv", messageData.get("cups_resv"));
			sendData.put("acpt_ins_resv", messageData.get("acpt_ins_resv"));
			sendData.put("iss_ins_resv", messageData.get("iss_ins_resv"));
			sendData.put("natl_region_inf", messageData.get("natl_region_inf"));
			
			/**
			 * step1:数据去重判断
			 * step2:数据写入HDFS
			 */
			HDFSTool.kafkaConsumerDataWrite(sendData.toJSONString());
		}
		catch(Exception e)
		{
			errorMessage = "消费大数据仓库的数据处理出现异常";
			logger.error(errorMessage, e);
		}
	}
}
