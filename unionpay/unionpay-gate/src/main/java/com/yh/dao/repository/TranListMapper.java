package com.yh.dao.repository;


import java.util.List;

import com.yh.dao.model.TranList;	

/**
 * 云闪付交易 数据层
 * 
 * @author ruoyi
 * @date 2019-02-25
 */
public interface TranListMapper 
{
	/**
     * 查询云闪付交易信息
     * 
     * @param id 云闪付交易ID
     * @return 云闪付交易信息
     */
	public TranList selectTranListById(String id);
	
	/**
     * 查询云闪付交易列表
     * 
     * @param tranList 云闪付交易信息
     * @return 云闪付交易集合
     */
	public List<TranList> selectTranListList(TranList tranList);
	
	/**
     * 新增云闪付交易
     * 
     * @param tranList 云闪付交易信息
     * @return 结果
     */
	public int insertTranList(TranList tranList);
	
	/**
     * 修改云闪付交易
     * 
     * @param tranList 云闪付交易信息
     * @return 结果
     */
	public int updateTranList(TranList tranList);
	
	/**
     * 删除云闪付交易
     * 
     * @param id 云闪付交易ID
     * @return 结果
     */
	public int deleteTranListById(String id);
	
	/**
     * 批量删除云闪付交易
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTranListByIds(String[] ids);
	
	/**
	 * 
	 * <p>Title: unionpay-gate</p>
	 * <p>Description: </p>
	 * @param tranList
	 * @return
	 * TranList
	 * @author li liang zhong
	 * @date 2019年3月6日 下午2:59:36
	 * @version 1.0
	 */
	public TranList findTransInfo(TranList tranList);
}