package com.unionpay.dao.model;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 机构表 up_agent
 * Serializable
 * @author shark
 * @date 2019-02-25
 */
public class Agent implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 机构编号 */
	private String agentId;
	/** 机构名称 */
	private String agentName;
	/** 机构类型 */
	private String agentType;
	/** 上级编号 */
	private String parentId;
	/** 状态 */
	private String status;
	/** 创建人 */
	private String createdBy;
	/** 创建时间 */
	private Date createdTime;
	/** 修改人 */
	private String updatedBy;
	/** 修改时间 */
	private Date updatedTime;

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
	public void setCreatedBy(String createdBy) 
	{
		this.createdBy = createdBy;
	}

	public String getCreatedBy() 
	{
		return createdBy;
	}
	public void setCreatedTime(Date createdTime) 
	{
		this.createdTime = createdTime;
	}

	public Date getCreatedTime() 
	{
		return createdTime;
	}
	public void setUpdatedBy(String updatedBy) 
	{
		this.updatedBy = updatedBy;
	}

	public String getUpdatedBy() 
	{
		return updatedBy;
	}
	public void setUpdatedTime(Date updatedTime) 
	{
		this.updatedTime = updatedTime;
	}

	public Date getUpdatedTime() 
	{
		return updatedTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("agentId", getAgentId())
            .append("agentName", getAgentName())
            .append("agentType", getAgentType())
            .append("parentId", getParentId())
            .append("status", getStatus())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
