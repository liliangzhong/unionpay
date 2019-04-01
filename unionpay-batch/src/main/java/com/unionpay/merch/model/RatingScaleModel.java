package com.unionpay.merch.model;

import java.io.Serializable;
import com.univocity.parsers.annotations.Parsed;

/**
 * 
 * <p>Title: RatingScaleModel</p>
 * <p>Description:评分评级模板实体,根据需求可能需要调整字段</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月25日 下午7:58:27
 * @version 1.0
 *
 */
public class RatingScaleModel implements Serializable
{
	private static final long serialVersionUID = 1L;
    
	/**评级结果ID**/
	@Parsed(field = "评级编号")
	private Integer resultId;
	
	/**评级批次号**/
	@Parsed(field = "评级批次号")
	private String batchNo;
	
	/**商户编号**/
	@Parsed(field = "商户编号")
	private String mchntNo;
	
	/**商户名称**/
	@Parsed(field = "商户名称")
	private String mchntName;
	
	/**评分卷ID**/
	@Parsed(field = "评分卷编号")
	private Integer scorecardId;
	
	/**总分数**/
	@Parsed(field = "总分数")
	private Integer totalScore;
	
	/**商户等级**/
	@Parsed(field = "商户等级")
	private Integer mchntGrade;
	
	/**评级计算时间**/
	@Parsed(field = "评级计算时间")
	private String gradeTime;
	
	/**评级类型**/
	@Parsed(field = "评级类型")
	private String gradeType;
	
	/**管理策略ID**/
	@Parsed(field = "管理策略编号")
	private String policyId;
	
	/**评级机构ID**/
	@Parsed(field = "评级机构编号")
	private String gradeOrgId;

	public Integer getResultId()
	{
		return resultId;
	}

	public String getBatchNo()
	{
		return batchNo;
	}

	public String getMchntNo()
	{
		return mchntNo;
	}

	public String getMchntName()
	{
		return mchntName;
	}

	public Integer getScorecardId()
	{
		return scorecardId;
	}

	public Integer getTotalScore()
	{
		return totalScore;
	}

	public Integer getMchntGrade()
	{
		return mchntGrade;
	}

	public String getGradeTime()
	{
		return gradeTime;
	}

	public String getGradeType()
	{
		return gradeType;
	}

	public String getPolicyId()
	{
		return policyId;
	}

	public String getGradeOrgId()
	{
		return gradeOrgId;
	}

	public void setResultId(Integer resultId)
	{
		this.resultId = resultId;
	}

	public void setBatchNo(String batchNo)
	{
		this.batchNo = batchNo;
	}

	public void setMchntNo(String mchntNo)
	{
		this.mchntNo = mchntNo;
	}

	public void setMchntName(String mchntName)
	{
		this.mchntName = mchntName;
	}

	public void setScorecardId(Integer scorecardId)
	{
		this.scorecardId = scorecardId;
	}

	public void setTotalScore(Integer totalScore)
	{
		this.totalScore = totalScore;
	}

	public void setMchntGrade(Integer mchntGrade)
	{
		this.mchntGrade = mchntGrade;
	}

	public void setGradeTime(String date)
	{
		this.gradeTime = date;
	}

	public void setGradeType(String gradeType)
	{
		this.gradeType = gradeType;
	}

	public void setPolicyId(String policyId)
	{
		this.policyId = policyId;
	}

	public void setGradeOrgId(String gradeOrgId)
	{
		this.gradeOrgId = gradeOrgId;
	}

	@Override
	public String toString()
	{
		return "RatingScaleModel [resultId=" + resultId + ", batchNo=" + batchNo + ", mchntNo=" + mchntNo
				+ ", mchntName=" + mchntName + ", scorecardId=" + scorecardId + ", totalScore=" + totalScore
				+ ", mchntGrade=" + mchntGrade + ", gradeTime=" + gradeTime + ", gradeType=" + gradeType + ", policyId="
				+ policyId + ", gradeOrgId=" + gradeOrgId + "]";
	}
}
