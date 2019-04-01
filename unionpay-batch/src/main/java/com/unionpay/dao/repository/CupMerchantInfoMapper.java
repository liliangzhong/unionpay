package com.unionpay.dao.repository;

import java.util.List;

import com.unionpay.dao.model.CupMerchantInfo;	

/**
 * 银联商户 数据层
 * 
 * @author shark
 * @date 2019-02-25
 */
public interface CupMerchantInfoMapper 
{
	/**
     * 查询银联商户信息
     * 
     * @param mchntCd 银联商户ID
     * @return 银联商户信息
     */
	public CupMerchantInfo selectCupMerchantInfoById(String mchntCd);
	
	/**
     * 查询银联商户列表
     * 
     * @param cupMerchantInfo 银联商户信息
     * @return 银联商户集合
     */
	public List<CupMerchantInfo> selectCupMerchantInfoList(CupMerchantInfo cupMerchantInfo);
	
	/**
     * 新增银联商户
     * 
     * @param cupMerchantInfo 银联商户信息
     * @return 结果
     */
	public int insertCupMerchantInfo(CupMerchantInfo cupMerchantInfo);
	
	/**
     * 修改银联商户
     * 
     * @param cupMerchantInfo 银联商户信息
     * @return 结果
     */
	public int updateCupMerchantInfo(CupMerchantInfo cupMerchantInfo);
	
	/**
     * 删除银联商户
     * 
     * @param mchntCd 银联商户ID
     * @return 结果
     */
	public int deleteCupMerchantInfoById(String mchntCd);
	
	/**
     * 批量删除银联商户
     * 
     * @param mchntCds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCupMerchantInfoByIds(String[] mchntCds);
	
}