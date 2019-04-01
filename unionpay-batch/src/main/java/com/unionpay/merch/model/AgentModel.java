package com.unionpay.merch.model;

import java.io.Serializable;

import com.univocity.parsers.annotations.Parsed;

/**
 * 
 * <p>Title: AgentModel</p>
 * <p>Description:机构模型数据</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月28日 上午9:25:18
 * @version 1.0
 *
 */
public class AgentModel implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 机构编号 */
	@Parsed(field = "机构编号")
	private String agentId;
	
	/** 机构名称 */
	@Parsed(field = "机构名称")
	private String agentName;
	
	/** 机构类型 */
	@Parsed(field = "机构类型")
	private String agentType;
	
	/** 上级编号 */
	@Parsed(field = "上级机构编号")
	private String parentId;
	
	/** 状态 */
	@Parsed(field = "状态")
	private String status;

	public void setAgentId(String agentId) 
	{
		this.agentId = agentId;
	}

	public String getAgentId() 
	{
		return agentId;
	}
	public void setAgentName(String agentName) 
	{
		this.agentName = agentName;
	}

	public String getAgentName() 
	{
		return agentName;
	}
	public void setAgentType(String agentType) 
	{
		this.agentType = agentType;
	}

	public String getAgentType() 
	{
		return agentType;
	}
	public void setParentId(String parentId) 
	{
		this.parentId = parentId;
	}

	public String getParentId() 
	{
		return parentId;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}

	@Override
	public String toString()
	{
		return "AgentModel [agentId=" + agentId + ", agentName=" + agentName + ", agentType=" + agentType
				+ ", parentId=" + parentId + ", status=" + status + "]";
	}
}
