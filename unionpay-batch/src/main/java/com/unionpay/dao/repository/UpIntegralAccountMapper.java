package com.unionpay.dao.repository;

import java.util.List;
import java.util.Map;

import com.unionpay.dao.model.UpIntegralAccount;

/**
 * 
 * <p>Title: UpIntegralAccountMapper</p>
 * <p>Description:积分账户数据层</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月21日 下午2:03:04
 * @version 1.0
 *
 */
public interface UpIntegralAccountMapper
{
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table up_integral_account
	 *
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(String integralAccountNo);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table up_integral_account
	 *
	 * @mbg.generated
	 */
	int insert(UpIntegralAccount record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table up_integral_account
	 *
	 * @mbg.generated
	 */
	int insertSelective(UpIntegralAccount record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table up_integral_account
	 *
	 * @mbg.generated
	 */
	UpIntegralAccount selectByPrimaryKey(String integralAccountNo);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table up_integral_account
	 *
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(UpIntegralAccount record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table up_integral_account
	 *
	 * @mbg.generated
	 */
	int updateByPrimaryKey(UpIntegralAccount record);
	
	 /**
     * 
     * <p>Title: business</p>
     * <p>Description:根据机构号和商户查询积分账户信息</p>
     * @param integralAccount
     * @return
     * IntegralAccount
     * @author li liang zhong
     * @date 2019年3月19日 上午9:10:47
     * @version 1.0
     */
    UpIntegralAccount findAccount(UpIntegralAccount integralAccount);
    
    /**
     * 
     * <p>Title: unionpay-batch</p>
     * <p>Description:支持分页查询</p>
     * @param dataMap
     * @return
     * List<UpIntegralAccount>
     * @author li liang zhong
     * @date 2019年3月24日 上午11:46:37
     * @version 1.0
     */
    List<UpIntegralAccount> findListAccount(Map<String, Object> dataMap);
    
    /**
     * 
     * <p>Title: unionpay-batch</p>
     * <p>Description:查询商户积分账户总记录数</p>
     * @param dataMap
     * @return
     * long
     * @author li liang zhong
     * @date 2019年3月24日 下午2:57:41
     * @version 1.0
     */
    Long findAccountTotal(Map<String, Object> dataMap);
}