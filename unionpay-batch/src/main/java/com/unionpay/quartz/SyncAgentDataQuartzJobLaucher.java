package com.unionpay.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

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
 * <p>Title: SyncAgentDataQuartzJobLaucher</p>
 * <p>Description:同步机构数据定时任务调起批处理执行</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月28日 下午7:32:29
 * @version 1.0
 *
 */
public class SyncAgentDataQuartzJobLaucher extends QuartzJobBean
{
    private static final Logger logger = LoggerFactory.getLogger(SyncAgentDataQuartzJobLaucher.class);
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException
	{
		String error = null;
		try
		{
			JobDetail jobDetail = context.getJobDetail();
			JobDataMap jobDataMap = jobDetail.getJobDataMap();
			String jobName = jobDataMap.getString("syncAgentJob");
			JobLauncher jobLauncher = (JobLauncher) jobDataMap.get("jobLauncher");
			JobLocator jobLocator = (JobLocator) jobDataMap.get("jobLocator");
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sf.format(new Date());
			logger.info("Current Time-1 : " + date);
			Job job = jobLocator.getJob(jobName);
			
			/* 启动spring batch的批处理作业 */
			JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
			//此参数只是为了确保每次执行的参数都发生变化,从而达到批处理可以重复执行的结果
			jobParametersBuilder.addDate("date", sf.parse(date));
			JobExecution jobExecution = jobLauncher.run(job, jobParametersBuilder.toJobParameters());
			jobExecution.getStatus();
		}
		catch(Exception e)
		{
			error = "定时任务执行机构同步批处理失败";
			logger.error(error, e);
		}
	}
    
	
}
