package com.unionpay.batchtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import com.unionpay.dao.model.MchntResult;
import com.unionpay.dao.repository.MchntResultMapper;

public class MyTasklet implements Tasklet
{
	private static Logger logger = LoggerFactory.getLogger(MyTasklet.class);
	
	@Autowired
	private MchntResultMapper mchntResultMapper;
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
	{
		logger.info("查询商户评分评级的对象===》" + mchntResultMapper);
		try
		{
			MchntResult mchntResult = mchntResultMapper.selectByPrimaryKey(1);
			logger.info("查询商户评分评级结果数据:" + mchntResult);
		}
		catch(Exception e)
		{
			logger.error("业务处理异常=====>" + e);
			e.printStackTrace();
		}
		return RepeatStatus.FINISHED;
	}

}
