package com.unionpay.batchtask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import com.unionpay.account.utils.BeanConverter;
import com.unionpay.dao.model.Agent;
import com.unionpay.dao.repository.AgentMapper;
import com.unionpay.merch.fileutils.CSVServiceUtils;
import com.unionpay.merch.fileutils.LoadConfig;
import com.unionpay.merch.model.AgentModel;

/**
 * 
 * <p>Title: SyncAgentTasklet</p>
 * <p>Description:同步机构批处理执行类</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月28日 下午7:18:45
 * @version 1.0
 *
 */
public class SyncAgentTasklet implements Tasklet
{
    private static final Logger logger = LoggerFactory.getLogger(SyncAgentTasklet.class);
    
    @Autowired
    private AgentMapper agentMapper;
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception
	{
		Map<String, Object> params = chunkContext.getStepContext().getJobParameters();
		String filePath = LoadConfig.getProperties("file_agent_path");
		String characterEncode = "UTF-8";
		String fileName = LoadConfig.getProperties("file_agent_name");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String dateFile = sf.format(new Date());
		StringBuffer sb = new StringBuffer();
		sb.append(filePath).append(dateFile).append(fileName);
		List<AgentModel> listAgents = CSVServiceUtils.readCSV(sb.toString(), characterEncode, AgentModel.class);
		if(listAgents == null || listAgents.size() == 0)
			return RepeatStatus.FINISHED;
		Agent agent = null;
		for(AgentModel agentModel : listAgents)
		{
			agent = BeanConverter.convertBean(agentModel, Agent.class);
			agent.setCreatedTime(new Date());
			agent.setCreatedBy("system");
			agentMapper.insertAgent(agent);
		}
		return RepeatStatus.FINISHED;
	}

}
