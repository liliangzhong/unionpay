package com.unionpay.dao.repository;

import java.util.List;

import com.unionpay.dao.model.Agent;	

/**
 * 机构 数据层
 * 
 * @author shark
 * @date 2019-02-25
 */
public interface AgentMapper 
{
	/**
     * 查询机构信息
     * 
     * @param agentId 机构ID
     * @return 机构信息
     */
	public Agent selectAgentById(String agentId);
	
	/**
     * 查询机构列表
     * 
     * @param agent 机构信息
     * @return 机构集合
     */
	public List<Agent> selectAgentList(Agent agent);
	
	/**
     * 新增机构
     * 
     * @param agent 机构信息
     * @return 结果
     */
	public int insertAgent(Agent agent);
	
	/**
     * 修改机构
     * 
     * @param agent 机构信息
     * @return 结果
     */
	public int updateAgent(Agent agent);
	
	/**
     * 删除机构
     * 
     * @param agentId 机构ID
     * @return 结果
     */
	public int deleteAgentById(String agentId);
	
	/**
     * 批量删除机构
     * 
     * @param agentIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteAgentByIds(String[] agentIds);
	
}