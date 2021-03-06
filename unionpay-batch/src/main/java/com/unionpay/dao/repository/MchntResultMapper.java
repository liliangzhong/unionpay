package com.unionpay.dao.repository;

import com.unionpay.dao.model.MchntResult;

/**
 * 
 * <p>Title: MchntResultMapper</p>
 * <p>Description:商户评分评级结果-数据层</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月21日 下午1:52:45
 * @version 1.0
 *
 */
public interface MchntResultMapper 
{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_mchnt_result
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer resultId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_mchnt_result
     *
     * @mbg.generated
     */
    int insert(MchntResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_mchnt_result
     *
     * @mbg.generated
     */
    int insertSelective(MchntResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_mchnt_result
     *
     * @mbg.generated
     */
    MchntResult selectByPrimaryKey(Integer resultId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_mchnt_result
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MchntResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_mchnt_result
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MchntResult record);
}