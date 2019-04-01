package com.unionpay.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 
 * <p>Title: BaseQuartzJobLaucherService</p>
 * <p>Description:JOB任务执行基类</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月21日 下午2:29:42
 * @version 1.0
 *
 */
public  class MchIntegralAccountQuartzJobLaucher extends QuartzJobBean
{
    private static final Logger logger = LoggerFactory.getLogger(MchIntegralAccountQuartzJobLaucher.class);
    
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException
	{
		
		/**
		 * step1:日终启动定时任务。
		 * step2:读取商户积分账户表数据，分页处理
		 * step3:计算商户可入账积分余额，未激活积分余额为0,则不进行DB处理
		 * step4:更新商户积分账户数据
		 */
		/********************获取jobName、jobLauncher和jobLocator***********************/
		logger.info("=====================开始处理任务step=================");
		try
		{
			JobDetail jobDetail = context.getJobDetail();
			JobDataMap jobDataMap = jobDetail.getJobDataMap();
			String jobName = jobDataMap.getString("accountJob");
			JobLauncher jobLauncher = (JobLauncher) jobDataMap.get("jobLauncher");
			JobLocator jobLocator = (JobLocator) jobDataMap.get("jobLocator");
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sf.format(new Date());
			logger.info("Current Time-1 : " + date);
			String changeDate = date.substring(0, 10);
			Job job = jobLocator.getJob(jobName);
			
			/* 启动spring batch的批处理作业 */
			JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
			//账户变动日期
			jobParametersBuilder.addString("changeDate", changeDate);
			//此参数只是为了确保每次执行的参数都发生变化,从而达到批处理可以重复执行的结果
			jobParametersBuilder.addDate("date", sf.parse(date));
			JobExecution jobExecution = jobLauncher.run(job,jobParametersBuilder.toJobParameters());
			jobExecution.getStatus();
		} catch (Exception e)
		{
			logger.error("定时任务-积分账户未激活积分的批处理调用失败");
			e.printStackTrace();
		}
	}
}
