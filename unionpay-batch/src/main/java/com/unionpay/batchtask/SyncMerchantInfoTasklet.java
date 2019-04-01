package com.unionpay.batchtask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.unionpay.account.utils.BeanConverter;
import com.unionpay.dao.model.CqpMerchantInfo;
import com.unionpay.dao.model.CupMerchantInfo;
import com.unionpay.dao.model.MerchantInfo;
import com.unionpay.dao.repository.CqpMerchantInfoMapper;
import com.unionpay.dao.repository.CupMerchantInfoMapper;
import com.unionpay.dao.repository.MerchantInfoMapper;
import com.unionpay.merch.enums.EmErrorCode;
import com.unionpay.merch.fileutils.CSVServiceUtils;
import com.unionpay.merch.fileutils.LoadConfig;
import com.unionpay.merch.model.CupMerchantInfoModel;
import com.unionpay.merch.model.MerchantInfoDataRsp;

/**
 * 
 * <p>Title: SyncMerchantInfoService</p>
 * <p>Description:商户信息数据同步入库</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月28日 上午9:45:44
 * @version 1.0
 *
 */
@Service
public class SyncMerchantInfoTasklet implements Tasklet
{
    private static final Logger logger = LoggerFactory.getLogger(SyncMerchantInfoTasklet.class);
    
    @Autowired
    private CqpMerchantInfoMapper cqpMerchantInfoMapper;
    @Autowired
    private CupMerchantInfoMapper cupMerchantInfoMapper;
    @Autowired
    private MerchantInfoMapper merchantInfoMapper;
    
    public MerchantInfoDataRsp processorMerchantInfoData()
    {
    	String errorMessage = null;
    	MerchantInfoDataRsp merchantInfoDataRsp = new MerchantInfoDataRsp();
    	try
    	{
    		/**
    		 * step1:读取商户文件数据
    		 * step2:判断商户数据是否重复
    		 * step3:商户数据是数据库处理
    		 */
    		String filePath = LoadConfig.getProperties("file_path");
    		String characterEncode = "UTF-8";
    		String fileName = LoadConfig.getProperties("file_name");
    		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    		String dateFile = sf.format(new Date());
    		StringBuffer sb = new StringBuffer();
    		sb.append(filePath).append(dateFile).append(fileName);
    		List<CupMerchantInfoModel> listMerchants = CSVServiceUtils.readCSV(sb.toString(), characterEncode, CupMerchantInfoModel.class);
    		if(listMerchants == null || listMerchants.size() == 0)
    			return merchantInfoDataRsp;
    		for(CupMerchantInfoModel cupMerchantInfoModel : listMerchants)
    		{
    			handleDB(cupMerchantInfoModel);
    		}
    	}
    	catch(Exception e)
    	{
    		errorMessage = "导入商户数据处理失败";
    		logger.error(errorMessage, e);
    		merchantInfoDataRsp.setRspCode(EmErrorCode.FAIL.getErrorCode());
    		merchantInfoDataRsp.setRspMessage(errorMessage);
    	}
    	return merchantInfoDataRsp;
    }
    
    @Transactional(rollbackFor=Exception.class)
    public void handleDB(CupMerchantInfoModel cupMerchantInfoModel) throws Exception
    {
    	CupMerchantInfo cupMerchantInfo = BeanConverter.convertBean(cupMerchantInfoModel, CupMerchantInfo.class);
    	CqpMerchantInfo cqpMerchantInfo = BeanConverter.convertBean(cupMerchantInfoModel, CqpMerchantInfo.class);
        MerchantInfo merchantInfo = BeanConverter.convertBean(cupMerchantInfoModel, MerchantInfo.class);
        String mchntCd = cupMerchantInfoModel.getMchntCd();
        CupMerchantInfo cupMchntInfo = cupMerchantInfoMapper.selectCupMerchantInfoById(mchntCd);
        Date time = new Date();
        int cupMchInfo = 0;
        String errorMessage = null;
        if(cupMchntInfo == null)
        {
            merchantInfo.setCreatedTime(time);
            merchantInfo.setCreatedBy("System");
            cupMchInfo = cupMerchantInfoMapper.insertCupMerchantInfo(cupMerchantInfo);
            if(cupMchInfo <= 0)
            {
            	errorMessage = "直联商户入库失败";
            	handleException(errorMessage);
            }
            cupMchInfo = cqpMerchantInfoMapper.insertCqpMerchantInfo(cqpMerchantInfo);
            if(cupMchInfo <= 0)
            {
            	errorMessage = "间连商户入库失败";
            	handleException(errorMessage);
            }
            cupMchInfo = merchantInfoMapper.insertMerchantInfo(merchantInfo);
            if(cupMchInfo <= 0)
            {
            	errorMessage = "业务处理商户入库失败";
            	handleException(errorMessage);
            }
        }
        else
        {
            merchantInfo.setUpdatedBy("System");
            merchantInfo.setUpdatedTime(time);
            cupMchInfo = cupMerchantInfoMapper.updateCupMerchantInfo(cupMerchantInfo);
            if(cupMchInfo <= 0)
            {
            	errorMessage = "业务处理商户更新数据库失败";
            	handleException(errorMessage);
            }
            cupMchInfo = cqpMerchantInfoMapper.updateCqpMerchantInfo(cqpMerchantInfo);
            if(cupMchInfo <= 0)
            {
            	errorMessage = "业务处理商户更新数据库失败";
            	handleException(errorMessage);
            }
            cupMchInfo = merchantInfoMapper.updateMerchantInfo(merchantInfo);
            if(cupMchInfo <= 0)
            {
            	errorMessage = "业务处理商户入库失败";
            	handleException(errorMessage);
            }
        } 
    }
    
    public void handleException(String message) throws Exception
    {
    	if(StringUtils.isBlank(message))
    		return;
    	throw new Exception(message);
    }

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception
	{
		processorMerchantInfoData();
		return RepeatStatus.FINISHED;
	}
}
