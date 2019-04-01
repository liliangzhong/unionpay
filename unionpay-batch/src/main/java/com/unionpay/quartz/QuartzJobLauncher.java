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

public class QuartzJobLauncher extends QuartzJobBean
{
	private static Logger logger = LoggerFactory.getLogger(QuartzJobLauncher.class);
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException
	{
		/********************获取jobName、jobLauncher和jobLocator***********************/
		logger.info("=====================开始处理任务step=================");
		JobDetail jobDetail = context.getJobDetail();
		JobDataMap jobDataMap = jobDetail.getJobDataMap();
		String jobName = jobDataMap.getString("jobName");
		JobLauncher jobLauncher = (JobLauncher) jobDataMap.get("jobLauncher");
		JobLocator jobLocator = (JobLocator) jobDataMap.get("jobLocator");
		logger.info("jobName : " + jobName);
		logger.info("jobLauncher : " + jobLauncher);
		logger.info("jobLocator : " + jobLocator);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sf.format(new Date());
		logger.info("Current Time : " + date);
		try
		{
			Job job = jobLocator.getJob(jobName);
			/* 启动spring batch的批处理作业 */
			JobExecution jobExecution = jobLauncher.run(job, 
					new JobParametersBuilder().addDate("date", new Date()).toJobParameters());
			jobExecution.getStatus();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
