package com.unionpay.dao.model;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商户详情表 up_merchant_info
 * 
 * @author shark
 * @date 2019-02-25
 */
public class MerchantInfo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 商户编号 */
	private String merchId;
	/** 法定名称 */
	private String mchntCnNm;
	/** 商户经营名称 */
	private String mchntCnAbbr;
	/** 商户服务类型 */
	private String mchntSvcTp;
	/** 所属银联分公司代码 */
	private String cupBranchInsIdCd;
	/** 商户来源 agq-云闪付;cup-银联商户 */
	private String source;
	/** 服务商编号 */
	private String mchntFacilitator;
	/** mcc码 */
	private String mchntType;
	/** 商户类别-大类 */
	private String mchntMainclass;
	/** 商户类别-小类 */
	private String mchntSubclass;
	/** 商户等级 */
	private String mchntGrade;
	/** 地址 */
	private String address;
	/** 收单机构代码 */
	private String acqInsIdCd;
	/** 受理区域代码 */
	private String acptInsIdCd;
	/** 所属平台机构代码 */
	private String platInsIdCd;
	/** 收单接入机构代码 */
	private String acqAccessInsIdCd;
	/** 国家代码 */
	private String cntryCd;
	/** 行政区划代码 */
	private String gbRegionId;
	/** 受理地区代码 */
	private String acqRegionCd;
	/** 交易商户类型 */
	private String mchntTp;
	/** 清算地区代码 */
	private String regionCd;
	/** 真实商户类型 */
	private String realMchntTp;
	/** 商户组别 */
	private String mchntGrp;
	/** 商户状态 */
	private String mchntSt;
	/** 所属行业类型 */
	private String industryTp;
	/** 商户联系人 */
	private String contact;
	/** 联系电话 */
	private String phone;
	/** 备注说明 */
	private String remark;
	/** 创建人 */
	private String createdBy;
	/** 创建时间 */
	private Date createdTime;
	/** 更新人 */
	private String updatedBy;
	/** 更新时间 */
	private Date updatedTime;

	public void setMerchId(String merchId) 
	{
		this.merchId = merchId;
	}

	public String getMerchId() 
	{
		return merchId;
	}
	public void setMchntCnNm(String mchntCnNm) 
	{
		this.mchntCnNm = mchntCnNm;
	}

	public String getMchntCnNm() 
	{
		return mchntCnNm;
	}
	public void setMchntCnAbbr(String mchntCnAbbr) 
	{
		this.mchntCnAbbr = mchntCnAbbr;
	}

	public String getMchntCnAbbr() 
	{
		return mchntCnAbbr;
	}
	public void setMchntSvcTp(String mchntSvcTp) 
	{
		this.mchntSvcTp = mchntSvcTp;
	}

	public String getMchntSvcTp() 
	{
		return mchntSvcTp;
	}
	public void setCupBranchInsIdCd(String cupBranchInsIdCd) 
	{
		this.cupBranchInsIdCd = cupBranchInsIdCd;
	}

	public String getCupBranchInsIdCd() 
	{
		return cupBranchInsIdCd;
	}
	public void setSource(String source) 
	{
		this.source = source;
	}

	public String getSource() 
	{
		return source;
	}
	public void setMchntFacilitator(String mchntFacilitator) 
	{
		this.mchntFacilitator = mchntFacilitator;
	}

	public String getMchntFacilitator() 
	{
		return mchntFacilitator;
	}
	public void setMchntType(String mchntType) 
	{
		this.mchntType = mchntType;
	}

	public String getMchntType() 
	{
		return mchntType;
	}
	public void setMchntMainclass(String mchntMainclass) 
	{
		this.mchntMainclass = mchntMainclass;
	}

	public String getMchntMainclass() 
	{
		return mchntMainclass;
	}
	public void setMchntSubclass(String mchntSubclass) 
	{
		this.mchntSubclass = mchntSubclass;
	}

	public String getMchntSubclass() 
	{
		return mchntSubclass;
	}
	public void setMchntGrade(String mchntGrade) 
	{
		this.mchntGrade = mchntGrade;
	}

	public String getMchntGrade() 
	{
		return mchntGrade;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}
	public void setAcqInsIdCd(String acqInsIdCd) 
	{
		this.acqInsIdCd = acqInsIdCd;
	}

	public String getAcqInsIdCd() 
	{
		return acqInsIdCd;
	}
	public void setAcptInsIdCd(String acptInsIdCd) 
	{
		this.acptInsIdCd = acptInsIdCd;
	}

	public String getAcptInsIdCd() 
	{
		return acptInsIdCd;
	}
	public void setPlatInsIdCd(String platInsIdCd) 
	{
		this.platInsIdCd = platInsIdCd;
	}

	public String getPlatInsIdCd() 
	{
		return platInsIdCd;
	}
	public void setAcqAccessInsIdCd(String acqAccessInsIdCd) 
	{
		this.acqAccessInsIdCd = acqAccessInsIdCd;
	}

	public String getAcqAccessInsIdCd() 
	{
		return acqAccessInsIdCd;
	}
	public void setCntryCd(String cntryCd) 
	{
		this.cntryCd = cntryCd;
	}

	public String getCntryCd() 
	{
		return cntryCd;
	}
	public void setGbRegionId(String gbRegionId) 
	{
		this.gbRegionId = gbRegionId;
	}

	public String getGbRegionId() 
	{
		return gbRegionId;
	}
	public void setAcqRegionCd(String acqRegionCd) 
	{
		this.acqRegionCd = acqRegionCd;
	}

	public String getAcqRegionCd() 
	{
		return acqRegionCd;
	}
	public void setMchntTp(String mchntTp) 
	{
		this.mchntTp = mchntTp;
	}

	public String getMchntTp() 
	{
		return mchntTp;
	}
	public void setRegionCd(String regionCd) 
	{
		this.regionCd = regionCd;
	}

	public String getRegionCd() 
	{
		return regionCd;
	}
	public void setRealMchntTp(String realMchntTp) 
	{
		this.realMchntTp = realMchntTp;
	}

	public String getRealMchntTp() 
	{
		return realMchntTp;
	}
	public void setMchntGrp(String mchntGrp) 
	{
		this.mchntGrp = mchntGrp;
	}

	public String getMchntGrp() 
	{
		return mchntGrp;
	}
	public void setMchntSt(String mchntSt) 
	{
		this.mchntSt = mchntSt;
	}

	public String getMchntSt() 
	{
		return mchntSt;
	}
	public void setIndustryTp(String industryTp) 
	{
		this.industryTp = industryTp;
	}

	public String getIndustryTp() 
	{
		return industryTp;
	}
	public void setContact(String contact) 
	{
		this.contact = contact;
	}

	public String getContact() 
	{
		return contact;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setCreatedBy(String createdBy) 
	{
		this.createdBy = createdBy;
	}

	public String getCreatedBy() 
	{
		return createdBy;
	}
	public void setCreatedTime(Date createdTime) 
	{
		this.createdTime = createdTime;
	}

	public Date getCreatedTime() 
	{
		return createdTime;
	}
	public void setUpdatedBy(String updatedBy) 
	{
		this.updatedBy = updatedBy;
	}

	public String getUpdatedBy() 
	{
		return updatedBy;
	}
	public void setUpdatedTime(Date updatedTime) 
	{
		this.updatedTime = updatedTime;
	}

	public Date getUpdatedTime() 
	{
		return updatedTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("merchId", getMerchId())
            .append("mchntCnNm", getMchntCnNm())
            .append("mchntCnAbbr", getMchntCnAbbr())
            .append("mchntSvcTp", getMchntSvcTp())
            .append("cupBranchInsIdCd", getCupBranchInsIdCd())
            .append("source", getSource())
            .append("mchntFacilitator", getMchntFacilitator())
            .append("mchntType", getMchntType())
            .append("mchntMainclass", getMchntMainclass())
            .append("mchntSubclass", getMchntSubclass())
            .append("mchntGrade", getMchntGrade())
            .append("address", getAddress())
            .append("acqInsIdCd", getAcqInsIdCd())
            .append("acptInsIdCd", getAcptInsIdCd())
            .append("platInsIdCd", getPlatInsIdCd())
            .append("acqAccessInsIdCd", getAcqAccessInsIdCd())
            .append("cntryCd", getCntryCd())
            .append("gbRegionId", getGbRegionId())
            .append("acqRegionCd", getAcqRegionCd())
            .append("mchntTp", getMchntTp())
            .append("regionCd", getRegionCd())
            .append("realMchntTp", getRealMchntTp())
            .append("mchntGrp", getMchntGrp())
            .append("mchntSt", getMchntSt())
            .append("industryTp", getIndustryTp())
            .append("contact", getContact())
            .append("phone", getPhone())
            .append("remark", getRemark())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
