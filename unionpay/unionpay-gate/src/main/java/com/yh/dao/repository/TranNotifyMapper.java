package com.yh.dao.repository;

import java.util.List;

import com.yh.dao.model.TranNotify;	

/**
 * 交易通知 数据层
 * 
 * @author ruoyi
 * @date 2019-02-25
 */
public interface TranNotifyMapper 
{
	/**
             * 查询交易通知信息
     * 
     * @param notifyId 交易通知ID
     * @return 交易通知信息
     */
	public TranNotify selectTranNotifyById(String notifyId);
	
	/**
            * 查询交易通知列表
     * 
     * @param tranNotify 交易通知信息
     * @return 交易通知集合
     */
	public List<TranNotify> selectTranNotifyList(TranNotify tranNotify);
	
	/**
             * 新增交易通知
     * 
     * @param tranNotify 交易通知信息
     * @return 结果
     */
	public int insertTranNotify(TranNotify tranNotify);
	
	/**
     * 修改交易通知
     * 
     * @param tranNotify 交易通知信息
     * @return 结果
     */
	public int updateTranNotify(TranNotify tranNotify);
	
	/**
             * 删除交易通知
     * 
     * @param notifyId 交易通知ID
     * @return 结果
     */
	public int deleteTranNotifyById(String notifyId);
	
	/**
             * 批量删除交易通知
     * 
     * @param notifyIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTranNotifyByIds(String[] notifyIds);
	
	/**
	 * 
	 * <p>Title: unionpay-gate</p>
	 * <p>Description:查询音箱通知交易数据</p>
	 * @param tranNotify
	 * @return
	 * TranNotify
	 * @author li liang zhong
	 * @date 2019年3月5日 下午4:23:21
	 * @version 1.0
	 */
	public TranNotify findTransData(TranNotify tranNotify);
	
}