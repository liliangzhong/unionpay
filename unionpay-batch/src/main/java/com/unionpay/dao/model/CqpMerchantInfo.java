package com.unionpay.dao.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.univocity.parsers.annotations.Parsed;

/**
 * 云闪付商户表 cqp_merchant_info
 * 
 * @author shark
 * @date 2019-02-25
 */
public class CqpMerchantInfo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 商户代码 */
	private String mchntCd;
	
	/** 商户注册的名称 */
	private String merchantName;
	
	/** 服务商标识 */
	private String serProvId;
	
	/** 收单机构代码 */
	private String acqOrgCode;
	
	/** 云闪付商户号 */
	private String merId;
	
	/** 收单机构商户号 */
	private String acqMerId;
	
	/** 服务商自定义域 */
	private String reqReserved;
	
	/** 服务商微信渠道号 */
	private String wechatChannelId;
	
	/** 服务商支付宝渠道号 */
	private String alipayChannelId;
	
	/** 商户类型 */
	private String merchantTyp;
	
	/** 营业执照号 */
	private String businessLicenseCode;
	
	/** 商户经营名称 */
	private String businessLicenseName;
	
	/** 营业执照照片 */
	private String businessLicensePhoto;
	
	/** 营业执照有效期 */
	private String businessLicenseExpired;
	
	/** 行业类目 */
	private String industryCategoryId;
	
	/** 经营地址 */
	private String businessAddress;
	
	/** 省 */
	private String province;
	
	/** 市 */
	private String city;
	
	/** 区 */
	private String area;
	
	/** 门店门头照 */
	private String storeHeadPhoto;
	
	/** 门店外景照 */
	private String storeShopPhoto;
	
	/** 门店内景照 */
	private String storeHallPhoto;
	
	/** 门店收银台照 */
	private String storeCashierPhoto;
	
	/** 法人姓名 */
	private String lawyerName;
	
	/** 法人证件类型 */
	private String lawyerCertType;
	
	/** 法人证件号码 */
	private String lawyerCertNo;
	
	/** 法人证件正面照 */
	private String lawyerCertPhotoFront;
	
	/** 法人证件背面照 */
	private String lawyerCertPhotoBack;
	
	/** 联系人姓名 */
	private String contactPerson;
	
	/** 联系人手机号码 */
	private String contactPhone;
	
	/** 客服电话 */
	private String serviceTel;
	
	/** 邮箱地址 */
	private String email;
	
	/** 结算账户类型 */
	private String settleAccountType;
	
	/** 结算户号 */
	private String settleAccountNo;
	
	/** 结算户名 */
	private String settleAccount;
	
	/** 结算周期 */
	private String settlePeriod;
	
	/** 开户许可证（照片） */
	private String openingLicenseAccountPhoto;
	
	/** 商户收单协议照片 */
	private String acquiringAgreementPhoto;
	
	/** 结算授权书（照片） */
	private String settleAuthLetterPhoto;
	
	/** 银行卡正面照 */
	private String bankCardPhotoFront;
	
	/** 银行卡背面照 */
	private String bankCardPhotoBack;
	
	/** 开户银行 */
	private String openBank;
	
	/** 开户支行 */
	private String openSubBank;
	
	/** 开户行联行号 */
	private String openBankCode;
	
	/** 银行预留手机号 */
	private String openBankReservePhone;
	
	/** 被授权人证件号码 */
	private String authorizedPersonCertNo;
	
	/** 被授权人证件类型 */
	private String authorizedPersonCertType;
	
	/** 被授权人证件正面照 */
	private String authorizedCertPhotoFront;
	
	/** 被授权人证件背面照 */
	private String authorizedCertPhotoBack;
	
	/** 商户资料扩展域 */
	private String reserve1;
	
	/** 支付宝手续费率 */
	private String feeRateAlipay;
	
	/** 银行卡费率一档 */
	private String bankCardRateLevel1;
	
	/** 银行卡费率二档 */
	private String bankCardRateLevel2;
	
	/** 微信手续费率 */
	private String feeRateWechatpay;
	
	/** 银联手续费率(借记) */
	private String feeRateUnionpayDebit;
	
	/** 银联手续费率(借记封顶) */
	private String feeRateUnionpayDebitCap;
	
	/** 银联手续费率(贷记) */
	private String feeRateUnionpayCredit;

	public void setMchntCd(String mchntCd) 
	{
		this.mchntCd = mchntCd;
	}

	public String getMchntCd() 
	{
		return mchntCd;
	}
	public void setMerchantName(String merchantName) 
	{
		this.merchantName = merchantName;
	}

	public String getMerchantName() 
	{
		return merchantName;
	}
	public void setSerProvId(String serProvId) 
	{
		this.serProvId = serProvId;
	}

	public String getSerProvId() 
	{
		return serProvId;
	}
	public void setAcqOrgCode(String acqOrgCode) 
	{
		this.acqOrgCode = acqOrgCode;
	}

	public String getAcqOrgCode() 
	{
		return acqOrgCode;
	}
	public void setMerId(String merId) 
	{
		this.merId = merId;
	}

	public String getMerId() 
	{
		return merId;
	}
	public void setAcqMerId(String acqMerId) 
	{
		this.acqMerId = acqMerId;
	}

	public String getAcqMerId() 
	{
		return acqMerId;
	}
	public void setReqReserved(String reqReserved) 
	{
		this.reqReserved = reqReserved;
	}

	public String getReqReserved() 
	{
		return reqReserved;
	}
	public void setWechatChannelId(String wechatChannelId) 
	{
		this.wechatChannelId = wechatChannelId;
	}

	public String getWechatChannelId() 
	{
		return wechatChannelId;
	}
	public void setAlipayChannelId(String alipayChannelId) 
	{
		this.alipayChannelId = alipayChannelId;
	}

	public String getAlipayChannelId() 
	{
		return alipayChannelId;
	}
	public void setMerchantTyp(String merchantTyp) 
	{
		this.merchantTyp = merchantTyp;
	}

	public String getMerchantTyp() 
	{
		return merchantTyp;
	}
	public void setBusinessLicenseCode(String businessLicenseCode) 
	{
		this.businessLicenseCode = businessLicenseCode;
	}

	public String getBusinessLicenseCode() 
	{
		return businessLicenseCode;
	}
	public void setBusinessLicenseName(String businessLicenseName) 
	{
		this.businessLicenseName = businessLicenseName;
	}

	public String getBusinessLicenseName() 
	{
		return businessLicenseName;
	}
	public void setBusinessLicensePhoto(String businessLicensePhoto) 
	{
		this.businessLicensePhoto = businessLicensePhoto;
	}

	public String getBusinessLicensePhoto() 
	{
		return businessLicensePhoto;
	}
	public void setBusinessLicenseExpired(String businessLicenseExpired) 
	{
		this.businessLicenseExpired = businessLicenseExpired;
	}

	public String getBusinessLicenseExpired() 
	{
		return businessLicenseExpired;
	}
	public void setIndustryCategoryId(String industryCategoryId) 
	{
		this.industryCategoryId = industryCategoryId;
	}

	public String getIndustryCategoryId() 
	{
		return industryCategoryId;
	}
	public void setBusinessAddress(String businessAddress) 
	{
		this.businessAddress = businessAddress;
	}

	public String getBusinessAddress() 
	{
		return businessAddress;
	}
	public void setProvince(String province) 
	{
		this.province = province;
	}

	public String getProvince() 
	{
		return province;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getCity() 
	{
		return city;
	}
	public void setArea(String area) 
	{
		this.area = area;
	}

	public String getArea() 
	{
		return area;
	}
	public void setStoreHeadPhoto(String storeHeadPhoto) 
	{
		this.storeHeadPhoto = storeHeadPhoto;
	}

	public String getStoreHeadPhoto() 
	{
		return storeHeadPhoto;
	}
	public void setStoreShopPhoto(String storeShopPhoto) 
	{
		this.storeShopPhoto = storeShopPhoto;
	}

	public String getStoreShopPhoto() 
	{
		return storeShopPhoto;
	}
	public void setStoreHallPhoto(String storeHallPhoto) 
	{
		this.storeHallPhoto = storeHallPhoto;
	}

	public String getStoreHallPhoto() 
	{
		return storeHallPhoto;
	}
	public void setStoreCashierPhoto(String storeCashierPhoto) 
	{
		this.storeCashierPhoto = storeCashierPhoto;
	}

	public String getStoreCashierPhoto() 
	{
		return storeCashierPhoto;
	}
	public void setLawyerName(String lawyerName) 
	{
		this.lawyerName = lawyerName;
	}

	public String getLawyerName() 
	{
		return lawyerName;
	}
	public void setLawyerCertType(String lawyerCertType) 
	{
		this.lawyerCertType = lawyerCertType;
	}

	public String getLawyerCertType() 
	{
		return lawyerCertType;
	}
	public void setLawyerCertNo(String lawyerCertNo) 
	{
		this.lawyerCertNo = lawyerCertNo;
	}

	public String getLawyerCertNo() 
	{
		return lawyerCertNo;
	}
	public void setLawyerCertPhotoFront(String lawyerCertPhotoFront) 
	{
		this.lawyerCertPhotoFront = lawyerCertPhotoFront;
	}

	public String getLawyerCertPhotoFront() 
	{
		return lawyerCertPhotoFront;
	}
	public void setLawyerCertPhotoBack(String lawyerCertPhotoBack) 
	{
		this.lawyerCertPhotoBack = lawyerCertPhotoBack;
	}

	public String getLawyerCertPhotoBack() 
	{
		return lawyerCertPhotoBack;
	}
	public void setContactPerson(String contactPerson) 
	{
		this.contactPerson = contactPerson;
	}

	public String getContactPerson() 
	{
		return contactPerson;
	}
	public void setContactPhone(String contactPhone) 
	{
		this.contactPhone = contactPhone;
	}

	public String getContactPhone() 
	{
		return contactPhone;
	}
	public void setServiceTel(String serviceTel) 
	{
		this.serviceTel = serviceTel;
	}

	public String getServiceTel() 
	{
		return serviceTel;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	public void setSettleAccountType(String settleAccountType) 
	{
		this.settleAccountType = settleAccountType;
	}

	public String getSettleAccountType() 
	{
		return settleAccountType;
	}
	public void setSettleAccountNo(String settleAccountNo) 
	{
		this.settleAccountNo = settleAccountNo;
	}

	public String getSettleAccountNo() 
	{
		return settleAccountNo;
	}
	public void setSettleAccount(String settleAccount) 
	{
		this.settleAccount = settleAccount;
	}

	public String getSettleAccount() 
	{
		return settleAccount;
	}
	public void setSettlePeriod(String settlePeriod) 
	{
		this.settlePeriod = settlePeriod;
	}

	public String getSettlePeriod() 
	{
		return settlePeriod;
	}
	public void setOpeningLicenseAccountPhoto(String openingLicenseAccountPhoto) 
	{
		this.openingLicenseAccountPhoto = openingLicenseAccountPhoto;
	}

	public String getOpeningLicenseAccountPhoto() 
	{
		return openingLicenseAccountPhoto;
	}
	public void setAcquiringAgreementPhoto(String acquiringAgreementPhoto) 
	{
		this.acquiringAgreementPhoto = acquiringAgreementPhoto;
	}

	public String getAcquiringAgreementPhoto() 
	{
		return acquiringAgreementPhoto;
	}
	public void setSettleAuthLetterPhoto(String settleAuthLetterPhoto) 
	{
		this.settleAuthLetterPhoto = settleAuthLetterPhoto;
	}

	public String getSettleAuthLetterPhoto() 
	{
		return settleAuthLetterPhoto;
	}
	public void setBankCardPhotoFront(String bankCardPhotoFront) 
	{
		this.bankCardPhotoFront = bankCardPhotoFront;
	}

	public String getBankCardPhotoFront() 
	{
		return bankCardPhotoFront;
	}
	public void setBankCardPhotoBack(String bankCardPhotoBack) 
	{
		this.bankCardPhotoBack = bankCardPhotoBack;
	}

	public String getBankCardPhotoBack() 
	{
		return bankCardPhotoBack;
	}
	public void setOpenBank(String openBank) 
	{
		this.openBank = openBank;
	}

	public String getOpenBank() 
	{
		return openBank;
	}
	public void setOpenSubBank(String openSubBank) 
	{
		this.openSubBank = openSubBank;
	}

	public String getOpenSubBank() 
	{
		return openSubBank;
	}
	public void setOpenBankCode(String openBankCode) 
	{
		this.openBankCode = openBankCode;
	}

	public String getOpenBankCode() 
	{
		return openBankCode;
	}
	public void setOpenBankReservePhone(String openBankReservePhone) 
	{
		this.openBankReservePhone = openBankReservePhone;
	}

	public String getOpenBankReservePhone() 
	{
		return openBankReservePhone;
	}
	public void setAuthorizedPersonCertNo(String authorizedPersonCertNo) 
	{
		this.authorizedPersonCertNo = authorizedPersonCertNo;
	}

	public String getAuthorizedPersonCertNo() 
	{
		return authorizedPersonCertNo;
	}
	public void setAuthorizedPersonCertType(String authorizedPersonCertType) 
	{
		this.authorizedPersonCertType = authorizedPersonCertType;
	}

	public String getAuthorizedPersonCertType() 
	{
		return authorizedPersonCertType;
	}
	public void setAuthorizedCertPhotoFront(String authorizedCertPhotoFront) 
	{
		this.authorizedCertPhotoFront = authorizedCertPhotoFront;
	}

	public String getAuthorizedCertPhotoFront() 
	{
		return authorizedCertPhotoFront;
	}
	public void setAuthorizedCertPhotoBack(String authorizedCertPhotoBack) 
	{
		this.authorizedCertPhotoBack = authorizedCertPhotoBack;
	}

	public String getAuthorizedCertPhotoBack() 
	{
		return authorizedCertPhotoBack;
	}
	public void setReserve1(String reserve1) 
	{
		this.reserve1 = reserve1;
	}

	public String getReserve1() 
	{
		return reserve1;
	}
	public void setFeeRateAlipay(String feeRateAlipay) 
	{
		this.feeRateAlipay = feeRateAlipay;
	}

	public String getFeeRateAlipay() 
	{
		return feeRateAlipay;
	}
	public void setBankCardRateLevel1(String bankCardRateLevel1) 
	{
		this.bankCardRateLevel1 = bankCardRateLevel1;
	}

	public String getBankCardRateLevel1() 
	{
		return bankCardRateLevel1;
	}
	public void setBankCardRateLevel2(String bankCardRateLevel2) 
	{
		this.bankCardRateLevel2 = bankCardRateLevel2;
	}

	public String getBankCardRateLevel2() 
	{
		return bankCardRateLevel2;
	}
	public void setFeeRateWechatpay(String feeRateWechatpay) 
	{
		this.feeRateWechatpay = feeRateWechatpay;
	}

	public String getFeeRateWechatpay() 
	{
		return feeRateWechatpay;
	}
	public void setFeeRateUnionpayDebit(String feeRateUnionpayDebit) 
	{
		this.feeRateUnionpayDebit = feeRateUnionpayDebit;
	}

	public String getFeeRateUnionpayDebit() 
	{
		return feeRateUnionpayDebit;
	}
	public void setFeeRateUnionpayDebitCap(String feeRateUnionpayDebitCap) 
	{
		this.feeRateUnionpayDebitCap = feeRateUnionpayDebitCap;
	}

	public String getFeeRateUnionpayDebitCap() 
	{
		return feeRateUnionpayDebitCap;
	}
	public void setFeeRateUnionpayCredit(String feeRateUnionpayCredit) 
	{
		this.feeRateUnionpayCredit = feeRateUnionpayCredit;
	}

	public String getFeeRateUnionpayCredit() 
	{
		return feeRateUnionpayCredit;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mchntCd", getMchntCd())
            .append("merchantName", getMerchantName())
            .append("serProvId", getSerProvId())
            .append("acqOrgCode", getAcqOrgCode())
            .append("merId", getMerId())
            .append("acqMerId", getAcqMerId())
            .append("reqReserved", getReqReserved())
            .append("wechatChannelId", getWechatChannelId())
            .append("alipayChannelId", getAlipayChannelId())
            .append("merchantTyp", getMerchantTyp())
            .append("businessLicenseCode", getBusinessLicenseCode())
            .append("businessLicenseName", getBusinessLicenseName())
            .append("businessLicensePhoto", getBusinessLicensePhoto())
            .append("businessLicenseExpired", getBusinessLicenseExpired())
            .append("industryCategoryId", getIndustryCategoryId())
            .append("businessAddress", getBusinessAddress())
            .append("province", getProvince())
            .append("city", getCity())
            .append("area", getArea())
            .append("storeHeadPhoto", getStoreHeadPhoto())
            .append("storeShopPhoto", getStoreShopPhoto())
            .append("storeHallPhoto", getStoreHallPhoto())
            .append("storeCashierPhoto", getStoreCashierPhoto())
            .append("lawyerName", getLawyerName())
            .append("lawyerCertType", getLawyerCertType())
            .append("lawyerCertNo", getLawyerCertNo())
            .append("lawyerCertPhotoFront", getLawyerCertPhotoFront())
            .append("lawyerCertPhotoBack", getLawyerCertPhotoBack())
            .append("contactPerson", getContactPerson())
            .append("contactPhone", getContactPhone())
            .append("serviceTel", getServiceTel())
            .append("email", getEmail())
            .append("settleAccountType", getSettleAccountType())
            .append("settleAccountNo", getSettleAccountNo())
            .append("settleAccount", getSettleAccount())
            .append("settlePeriod", getSettlePeriod())
            .append("openingLicenseAccountPhoto", getOpeningLicenseAccountPhoto())
            .append("acquiringAgreementPhoto", getAcquiringAgreementPhoto())
            .append("settleAuthLetterPhoto", getSettleAuthLetterPhoto())
            .append("bankCardPhotoFront", getBankCardPhotoFront())
            .append("bankCardPhotoBack", getBankCardPhotoBack())
            .append("openBank", getOpenBank())
            .append("openSubBank", getOpenSubBank())
            .append("openBankCode", getOpenBankCode())
            .append("openBankReservePhone", getOpenBankReservePhone())
            .append("authorizedPersonCertNo", getAuthorizedPersonCertNo())
            .append("authorizedPersonCertType", getAuthorizedPersonCertType())
            .append("authorizedCertPhotoFront", getAuthorizedCertPhotoFront())
            .append("authorizedCertPhotoBack", getAuthorizedCertPhotoBack())
            .append("reserve1", getReserve1())
            .append("feeRateAlipay", getFeeRateAlipay())
            .append("bankCardRateLevel1", getBankCardRateLevel1())
            .append("bankCardRateLevel2", getBankCardRateLevel2())
            .append("feeRateWechatpay", getFeeRateWechatpay())
            .append("feeRateUnionpayDebit", getFeeRateUnionpayDebit())
            .append("feeRateUnionpayDebitCap", getFeeRateUnionpayDebitCap())
            .append("feeRateUnionpayCredit", getFeeRateUnionpayCredit())
            .toString();
    }
}
