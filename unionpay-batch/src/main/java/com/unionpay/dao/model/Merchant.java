package com.unionpay.dao.model;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商户表 up_merchant
 * 
 * @author shark
 * @date 2019-03-12
 */
public class Merchant implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 商户编号 */
	private String merchId;
	/** 商户名称 */
	private String merchName;
	/** 商户类型 */
	private String merchType;
	/** 收单机构编号 */
	private String acqOrgCode;
	/** 收单机构名称 */
	private String acqOrgName;
	/** 服务商编号 */
	private String spId;
	/** 服务商名称 */
	private String spName;
	/** 商户经营名称 */
	private String businessLicenseName;
	/** 营业执照号 */
	private String businessLicenseCode;
	/** 法人证件号码 */
	private String lawyerCertNo;
	/** 联系人手机号码 */
	private String contactPhone;
	/** 语音绑定状态 */
	private String bindStatus;
	/** 绑定时间 */
	private String bindTime;
	/** 解绑时间 */
	private String unbindTime;
	/** 状态 */
	private String status;
	/** 创建人 */
	private String createdBy;
	/** 创建时间 */
	private Date createdTime;
	/** 修改人 */
	private String updatedBy;
	/** 修改时间 */
	private Date updatedTime;

	public void setMerchId(String merchId) 
	{
		this.merchId = merchId;
	}

	public String getMerchId() 
	{
		return merchId;
	}
	public void setMerchName(String merchName) 
	{
		this.merchName = merchName;
	}

	public String getMerchName() 
	{
		return merchName;
	}
	public void setMerchType(String merchType) 
	{
		this.merchType = merchType;
	}

	public String getMerchType() 
	{
		return merchType;
	}
	public void setAcqOrgCode(String acqOrgCode) 
	{
		this.acqOrgCode = acqOrgCode;
	}

	public String getAcqOrgCode() 
	{
		return acqOrgCode;
	}
	public void setAcqOrgName(String acqOrgName) 
	{
		this.acqOrgName = acqOrgName;
	}

	public String getAcqOrgName() 
	{
		return acqOrgName;
	}
	public void setSpId(String spId) 
	{
		this.spId = spId;
	}

	public String getSpId() 
	{
		return spId;
	}
	public void setSpName(String spName) 
	{
		this.spName = spName;
	}

	public String getSpName() 
	{
		return spName;
	}
	public void setBusinessLicenseName(String businessLicenseName) 
	{
		this.businessLicenseName = businessLicenseName;
	}

	public String getBusinessLicenseName() 
	{
		return businessLicenseName;
	}
	public void setBusinessLicenseCode(String businessLicenseCode) 
	{
		this.businessLicenseCode = businessLicenseCode;
	}

	public String getBusinessLicenseCode() 
	{
		return businessLicenseCode;
	}
	public void setLawyerCertNo(String lawyerCertNo) 
	{
		this.lawyerCertNo = lawyerCertNo;
	}

	public String getLawyerCertNo() 
	{
		return lawyerCertNo;
	}
	public void setContactPhone(String contactPhone) 
	{
		this.contactPhone = contactPhone;
	}

	public String getContactPhone() 
	{
		return contactPhone;
	}
	public void setBindStatus(String bindStatus) 
	{
		this.bindStatus = bindStatus;
	}

	public String getBindStatus() 
	{
		return bindStatus;
	}
	public void setBindTime(String bindTime) 
	{
		this.bindTime = bindTime;
	}

	public String getBindTime() 
	{
		return bindTime;
	}
	public void setUnbindTime(String unbindTime) 
	{
		this.unbindTime = unbindTime;
	}

	public String getUnbindTime() 
	{
		return unbindTime;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
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
            .append("merchName", getMerchName())
            .append("merchType", getMerchType())
            .append("acqOrgCode", getAcqOrgCode())
            .append("acqOrgName", getAcqOrgName())
            .append("spId", getSpId())
            .append("spName", getSpName())
            .append("businessLicenseName", getBusinessLicenseName())
            .append("businessLicenseCode", getBusinessLicenseCode())
            .append("lawyerCertNo", getLawyerCertNo())
            .append("contactPhone", getContactPhone())
            .append("bindStatus", getBindStatus())
            .append("bindTime", getBindTime())
            .append("unbindTime", getUnbindTime())
            .append("status", getStatus())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
