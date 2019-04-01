package com.unionpay.dao.repository;

import java.util.List;

import com.unionpay.dao.model.CqpMerchantInfo;	

/**
 * 云闪付商户 数据层
 * 
 * @author shark
 * @date 2019-02-25
 */
public interface CqpMerchantInfoMapper 
{
	/**
     * 查询云闪付商户信息
     * 
     * @param mchntCd 云闪付商户ID
     * @return 云闪付商户信息
     */
	public CqpMerchantInfo selectCqpMerchantInfoById(String mchntCd);
	
	/**
     * 查询云闪付商户列表
     * 
     * @param cqpMerchantInfo 云闪付商户信息
     * @return 云闪付商户集合
     */
	public List<CqpMerchantInfo> selectCqpMerchantInfoList(CqpMerchantInfo cqpMerchantInfo);
	
	/**
     * 新增云闪付商户
     * 
     * @param cqpMerchantInfo 云闪付商户信息
     * @return 结果
     */
	public int insertCqpMerchantInfo(CqpMerchantInfo cqpMerchantInfo);
	
	/**
     * 修改云闪付商户
     * 
     * @param cqpMerchantInfo 云闪付商户信息
     * @return 结果
     */
	public int updateCqpMerchantInfo(CqpMerchantInfo cqpMerchantInfo);
	
	/**
     * 删除云闪付商户
     * 
     * @param mchntCd 云闪付商户ID
     * @return 结果
     */
	public int deleteCqpMerchantInfoById(String mchntCd);
	
	/**
     * 批量删除云闪付商户
     * 
     * @param mchntCds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCqpMerchantInfoByIds(String[] mchntCds);
	
}