package com.unionpay.dao.repository;

import java.util.List;

import com.unionpay.dao.model.MerchantInfo;	

/**
 * 商户详情 数据层
 * 
 * @author shark
 * @date 2019-02-25
 */
public interface MerchantInfoMapper 
{
	/**
     * 查询商户详情信息
     * 
     * @param merchId 商户详情ID
     * @return 商户详情信息
     */
	public MerchantInfo selectMerchantInfoById(String merchId);
	
	/**
     * 查询商户详情列表
     * 
     * @param merchantInfo 商户详情信息
     * @return 商户详情集合
     */
	public List<MerchantInfo> selectMerchantInfoList(MerchantInfo merchantInfo);
	
	/**
     * 新增商户详情
     * 
     * @param merchantInfo 商户详情信息
     * @return 结果
     */
	public int insertMerchantInfo(MerchantInfo merchantInfo);
	
	/**
     * 修改商户详情
     * 
     * @param merchantInfo 商户详情信息
     * @return 结果
     */
	public int updateMerchantInfo(MerchantInfo merchantInfo);
	
	/**
     * 删除商户详情
     * 
     * @param merchId 商户详情ID
     * @return 结果
     */
	public int deleteMerchantInfoById(String merchId);
	
	/**
     * 批量删除商户详情
     * 
     * @param merchIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteMerchantInfoByIds(String[] merchIds);
	
}