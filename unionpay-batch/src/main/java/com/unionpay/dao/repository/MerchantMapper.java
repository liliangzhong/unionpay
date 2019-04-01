package com.unionpay.dao.repository;

import java.util.List;

import com.unionpay.dao.model.Merchant;	

/**
 * 商户 数据层
 * 
 * @author shark
 * @date 2019-02-25
 */
public interface MerchantMapper 
{
	/**
     * 查询商户信息
     * 
     * @param merchId 商户ID
     * @return 商户信息
     */
	public Merchant selectMerchantById(String merchId);
	
	/**
     * 查询商户列表
     * 
     * @param merchant 商户信息
     * @return 商户集合
     */
	public List<Merchant> selectMerchantList(Merchant merchant);
	
	/**
     * 新增商户
     * 
     * @param merchant 商户信息
     * @return 结果
     */
	public int insertMerchant(Merchant merchant);
	
	/**
     * 修改商户
     * 
     * @param merchant 商户信息
     * @return 结果
     */
	public int updateMerchant(Merchant merchant);
	
	/**
     * 删除商户
     * 
     * @param merchId 商户ID
     * @return 结果
     */
	public int deleteMerchantById(String merchId);
	
	/**
     * 批量删除商户
     * 
     * @param merchIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteMerchantByIds(String[] merchIds);
	
}