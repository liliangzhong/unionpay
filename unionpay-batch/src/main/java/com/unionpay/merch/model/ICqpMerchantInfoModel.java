package com.unionpay.merch.model;

import java.io.Serializable;
import com.univocity.parsers.annotations.Parsed;

/**
 * 
 * <p>Title: ICqpMerchantInfoModel</p>
 * <p>Description:商户同步文件的对应的数据模型处理类</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月27日 下午3:09:13
 * @version 1.0
 *
 */
public class ICqpMerchantInfoModel implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 商户代码 */
	@Parsed(field = "商户代码")
	private String mchntCd;
	
	/** 商户注册的名称 */
	@Parsed(field = "商户注册的名称")
	private String merchantName;
	
	/** 服务商标识 */
	@Parsed(field = "服务商标识")
	private String serProvId;
	
	/** 收单机构代码 */
	@Parsed(field = "收单机构代码")
	private String acqOrgCode;
	
	/** 云闪付商户号 */
	@Parsed(field = "云闪付商户号")
	private String merId;
	
	/** 收单机构商户号 */
	@Parsed(field = "收单机构商户号")
	private String acqMerId;
	
	/** 服务商自定义域 */
	@Parsed(field = "服务商自定义域")
	private String reqReserved;
	
	/** 服务商微信渠道号 */
	@Parsed(field = "服务商微信渠道号")
	private String wechatChannelId;
	
	/** 服务商支付宝渠道号 */
	@Parsed(field = "服务商支付宝渠道号")
	private String alipayChannelId;
	
	/** 商户类型 */
	@Parsed(field = "商户类型")
	private String merchantTyp;
	
	/** 营业执照号 */
	@Parsed(field = "营业执照号")
	private String businessLicenseCode;
	
	/** 商户经营名称 */
	@Parsed(field = "商户经营名称")
	private String businessLicenseName;
	
	/** 营业执照照片 */
	@Parsed(field = "营业执照照片")
	private String businessLicensePhoto;
	
	/** 营业执照有效期 */
	@Parsed(field = "营业执照有效期")
	private String businessLicenseExpired;
	
	/** 行业类目 */
	@Parsed(field = "行业类目")
	private String industryCategoryId;
	
	/** 经营地址 */
	@Parsed(field = "经营地址")
	private String businessAddress;
	
	/** 省 */
	@Parsed(field = "省")
	private String province;
	
	/** 市 */
	@Parsed(field = "市")
	private String city;
	
	/** 区 */
	@Parsed(field = "区")
	private String area;
	
	/** 门店门头照 */
	@Parsed(field = "门店门头照")
	private String storeHeadPhoto;
	
	/** 门店外景照 */
	@Parsed(field = "门店外景照")
	private String storeShopPhoto;
	
	/** 门店内景照 */
	@Parsed(field = "门店内景")
	private String storeHallPhoto;
	
	/** 门店收银台照 */
	@Parsed(field = "门店收银台照")
	private String storeCashierPhoto;
	
	/** 法人姓名 */
	@Parsed(field = "法人姓名")
	private String lawyerName;
	
	/** 法人证件类型 */
	@Parsed(field = "法人证件类型")
	private String lawyerCertType;
	
	/** 法人证件号码 */
	@Parsed(field = "法人证件号码")
	private String lawyerCertNo;
	
	/** 法人证件正面照 */
	@Parsed(field = "法人证件正面照")
	private String lawyerCertPhotoFront;
	
	/** 法人证件背面照 */
	@Parsed(field = "法人证件背面照")
	private String lawyerCertPhotoBack;
	
	/** 联系人姓名 */
	@Parsed(field = "联系人姓名")
	private String contactPerson;
	
	/** 联系人手机号码 */
	@Parsed(field = "联系人手机号码")
	private String contactPhone;
	
	/** 客服电话 */
	@Parsed(field = "客服电话")
	private String serviceTel;
	
	/** 邮箱地址 */
	@Parsed(field = "邮箱地址")
	private String email;
	
	/** 结算账户类型 */
	@Parsed(field = "结算账户类型")
	private String settleAccountType;
	
	/** 结算户号 */
	@Parsed(field = "结算户号")
	private String settleAccountNo;
	
	/** 结算户名 */
	@Parsed(field = "结算户名")
	private String settleAccount;
	
	/** 结算周期 */
	@Parsed(field = "结算周期")
	private String settlePeriod;
	
	/** 开户许可证（照片） */
	@Parsed(field = "开户许可证照")
	private String openingLicenseAccountPhoto;
	
	/** 商户收单协议照片 */
	@Parsed(field = "上海收单协议照片")
	private String acquiringAgreementPhoto;
	
	/** 结算授权书（照片） */
	@Parsed(field = "结算授权书照片")
	private String settleAuthLetterPhoto;
	
	/** 银行卡正面照 */
	@Parsed(field = "银行卡正面照")
	private String bankCardPhotoFront;
	
	/** 银行卡背面照 */
	@Parsed(field = "银行卡背面照")
	private String bankCardPhotoBack;
	
	/** 开户银行 */
	@Parsed(field = "开户银行")
	private String openBank;
	
	/** 开户支行 */
	@Parsed(field = "开户支行")
	private String openSubBank;
	
	/** 开户行联行号 */
	@Parsed(field = "开户行联行号")
	private String openBankCode;
	
	/** 银行预留手机号 */
	@Parsed(field = "银行预留手机号")
	private String openBankReservePhone;
	
	/** 被授权人证件号码 */
	@Parsed(field = "被授权人证件号码")
	private String authorizedPersonCertNo;
	
	/** 被授权人证件类型 */
	@Parsed(field = "被授权人证件类型")
	private String authorizedPersonCertType;
	
	/** 被授权人证件正面照 */
	@Parsed(field = "被授权人证件正面照")
	private String authorizedCertPhotoFront;
	
	/** 被授权人证件背面照 */
	@Parsed(field = "被授权人证件背面照")
	private String authorizedCertPhotoBack;
	
	/** 商户资料扩展域 */
	@Parsed(field = "商户资料扩展域")
	private String reserve1;
	
	/** 支付宝手续费率 */
	@Parsed(field = "支付宝手续费率")
	private String feeRateAlipay;
	
	/** 银行卡费率一档 */
	@Parsed(field = "银行卡费率一档")
	private String bankCardRateLevel1;
	
	/** 银行卡费率二档 */
	@Parsed(field = "银行卡费率二档")
	private String bankCardRateLevel2;
	
	/** 微信手续费率 */
	@Parsed(field = "微信手续费率")
	private String feeRateWechatpay;
	
	/** 银联手续费率(借记) */
	@Parsed(field = "银联手续费率(借记)")
	private String feeRateUnionpayDebit;
	
	/** 银联手续费率(借记封顶) */
	@Parsed(field = "银联手续费率(借记封顶)")
	private String feeRateUnionpayDebitCap;
	
	/** 银联手续费率(贷记) */
	@Parsed(field = "银联手续费率(贷记)")
	private String feeRateUnionpayCredit;

	public String getMchntCd()
	{
		return mchntCd;
	}

	public String getMerchantName()
	{
		return merchantName;
	}

	public String getSerProvId()
	{
		return serProvId;
	}

	public String getAcqOrgCode()
	{
		return acqOrgCode;
	}

	public String getMerId()
	{
		return merId;
	}

	public String getAcqMerId()
	{
		return acqMerId;
	}

	public String getReqReserved()
	{
		return reqReserved;
	}

	public String getWechatChannelId()
	{
		return wechatChannelId;
	}

	public String getAlipayChannelId()
	{
		return alipayChannelId;
	}

	public String getMerchantTyp()
	{
		return merchantTyp;
	}

	public String getBusinessLicenseCode()
	{
		return businessLicenseCode;
	}

	public String getBusinessLicenseName()
	{
		return businessLicenseName;
	}

	public String getBusinessLicensePhoto()
	{
		return businessLicensePhoto;
	}

	public String getBusinessLicenseExpired()
	{
		return businessLicenseExpired;
	}

	public String getIndustryCategoryId()
	{
		return industryCategoryId;
	}

	public String getBusinessAddress()
	{
		return businessAddress;
	}

	public String getProvince()
	{
		return province;
	}

	public String getCity()
	{
		return city;
	}

	public String getArea()
	{
		return area;
	}

	public String getStoreHeadPhoto()
	{
		return storeHeadPhoto;
	}

	public String getStoreShopPhoto()
	{
		return storeShopPhoto;
	}

	public String getStoreHallPhoto()
	{
		return storeHallPhoto;
	}

	public String getStoreCashierPhoto()
	{
		return storeCashierPhoto;
	}

	public String getLawyerName()
	{
		return lawyerName;
	}

	public String getLawyerCertType()
	{
		return lawyerCertType;
	}

	public String getLawyerCertNo()
	{
		return lawyerCertNo;
	}

	public String getLawyerCertPhotoFront()
	{
		return lawyerCertPhotoFront;
	}

	public String getLawyerCertPhotoBack()
	{
		return lawyerCertPhotoBack;
	}

	public String getContactPerson()
	{
		return contactPerson;
	}

	public String getContactPhone()
	{
		return contactPhone;
	}

	public String getServiceTel()
	{
		return serviceTel;
	}

	public String getEmail()
	{
		return email;
	}

	public String getSettleAccountType()
	{
		return settleAccountType;
	}

	public String getSettleAccountNo()
	{
		return settleAccountNo;
	}

	public String getSettleAccount()
	{
		return settleAccount;
	}

	public String getSettlePeriod()
	{
		return settlePeriod;
	}

	public String getOpeningLicenseAccountPhoto()
	{
		return openingLicenseAccountPhoto;
	}

	public String getAcquiringAgreementPhoto()
	{
		return acquiringAgreementPhoto;
	}

	public String getSettleAuthLetterPhoto()
	{
		return settleAuthLetterPhoto;
	}

	public String getBankCardPhotoFront()
	{
		return bankCardPhotoFront;
	}

	public String getBankCardPhotoBack()
	{
		return bankCardPhotoBack;
	}

	public String getOpenBank()
	{
		return openBank;
	}

	public String getOpenSubBank()
	{
		return openSubBank;
	}

	public String getOpenBankCode()
	{
		return openBankCode;
	}

	public String getOpenBankReservePhone()
	{
		return openBankReservePhone;
	}

	public String getAuthorizedPersonCertNo()
	{
		return authorizedPersonCertNo;
	}

	public String getAuthorizedPersonCertType()
	{
		return authorizedPersonCertType;
	}

	public String getAuthorizedCertPhotoFront()
	{
		return authorizedCertPhotoFront;
	}

	public String getAuthorizedCertPhotoBack()
	{
		return authorizedCertPhotoBack;
	}

	public String getReserve1()
	{
		return reserve1;
	}

	public String getFeeRateAlipay()
	{
		return feeRateAlipay;
	}

	public String getBankCardRateLevel1()
	{
		return bankCardRateLevel1;
	}

	public String getBankCardRateLevel2()
	{
		return bankCardRateLevel2;
	}

	public String getFeeRateWechatpay()
	{
		return feeRateWechatpay;
	}

	public String getFeeRateUnionpayDebit()
	{
		return feeRateUnionpayDebit;
	}

	public String getFeeRateUnionpayDebitCap()
	{
		return feeRateUnionpayDebitCap;
	}

	public String getFeeRateUnionpayCredit()
	{
		return feeRateUnionpayCredit;
	}

	public void setMchntCd(String mchntCd)
	{
		this.mchntCd = mchntCd;
	}

	public void setMerchantName(String merchantName)
	{
		this.merchantName = merchantName;
	}

	public void setSerProvId(String serProvId)
	{
		this.serProvId = serProvId;
	}

	public void setAcqOrgCode(String acqOrgCode)
	{
		this.acqOrgCode = acqOrgCode;
	}

	public void setMerId(String merId)
	{
		this.merId = merId;
	}

	public void setAcqMerId(String acqMerId)
	{
		this.acqMerId = acqMerId;
	}

	public void setReqReserved(String reqReserved)
	{
		this.reqReserved = reqReserved;
	}

	public void setWechatChannelId(String wechatChannelId)
	{
		this.wechatChannelId = wechatChannelId;
	}

	public void setAlipayChannelId(String alipayChannelId)
	{
		this.alipayChannelId = alipayChannelId;
	}

	public void setMerchantTyp(String merchantTyp)
	{
		this.merchantTyp = merchantTyp;
	}

	public void setBusinessLicenseCode(String businessLicenseCode)
	{
		this.businessLicenseCode = businessLicenseCode;
	}

	public void setBusinessLicenseName(String businessLicenseName)
	{
		this.businessLicenseName = businessLicenseName;
	}

	public void setBusinessLicensePhoto(String businessLicensePhoto)
	{
		this.businessLicensePhoto = businessLicensePhoto;
	}

	public void setBusinessLicenseExpired(String businessLicenseExpired)
	{
		this.businessLicenseExpired = businessLicenseExpired;
	}

	public void setIndustryCategoryId(String industryCategoryId)
	{
		this.industryCategoryId = industryCategoryId;
	}

	public void setBusinessAddress(String businessAddress)
	{
		this.businessAddress = businessAddress;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public void setArea(String area)
	{
		this.area = area;
	}

	public void setStoreHeadPhoto(String storeHeadPhoto)
	{
		this.storeHeadPhoto = storeHeadPhoto;
	}

	public void setStoreShopPhoto(String storeShopPhoto)
	{
		this.storeShopPhoto = storeShopPhoto;
	}

	public void setStoreHallPhoto(String storeHallPhoto)
	{
		this.storeHallPhoto = storeHallPhoto;
	}

	public void setStoreCashierPhoto(String storeCashierPhoto)
	{
		this.storeCashierPhoto = storeCashierPhoto;
	}

	public void setLawyerName(String lawyerName)
	{
		this.lawyerName = lawyerName;
	}

	public void setLawyerCertType(String lawyerCertType)
	{
		this.lawyerCertType = lawyerCertType;
	}

	public void setLawyerCertNo(String lawyerCertNo)
	{
		this.lawyerCertNo = lawyerCertNo;
	}

	public void setLawyerCertPhotoFront(String lawyerCertPhotoFront)
	{
		this.lawyerCertPhotoFront = lawyerCertPhotoFront;
	}

	public void setLawyerCertPhotoBack(String lawyerCertPhotoBack)
	{
		this.lawyerCertPhotoBack = lawyerCertPhotoBack;
	}

	public void setContactPerson(String contactPerson)
	{
		this.contactPerson = contactPerson;
	}

	public void setContactPhone(String contactPhone)
	{
		this.contactPhone = contactPhone;
	}

	public void setServiceTel(String serviceTel)
	{
		this.serviceTel = serviceTel;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setSettleAccountType(String settleAccountType)
	{
		this.settleAccountType = settleAccountType;
	}

	public void setSettleAccountNo(String settleAccountNo)
	{
		this.settleAccountNo = settleAccountNo;
	}

	public void setSettleAccount(String settleAccount)
	{
		this.settleAccount = settleAccount;
	}

	public void setSettlePeriod(String settlePeriod)
	{
		this.settlePeriod = settlePeriod;
	}

	public void setOpeningLicenseAccountPhoto(String openingLicenseAccountPhoto)
	{
		this.openingLicenseAccountPhoto = openingLicenseAccountPhoto;
	}

	public void setAcquiringAgreementPhoto(String acquiringAgreementPhoto)
	{
		this.acquiringAgreementPhoto = acquiringAgreementPhoto;
	}

	public void setSettleAuthLetterPhoto(String settleAuthLetterPhoto)
	{
		this.settleAuthLetterPhoto = settleAuthLetterPhoto;
	}

	public void setBankCardPhotoFront(String bankCardPhotoFront)
	{
		this.bankCardPhotoFront = bankCardPhotoFront;
	}

	public void setBankCardPhotoBack(String bankCardPhotoBack)
	{
		this.bankCardPhotoBack = bankCardPhotoBack;
	}

	public void setOpenBank(String openBank)
	{
		this.openBank = openBank;
	}

	public void setOpenSubBank(String openSubBank)
	{
		this.openSubBank = openSubBank;
	}

	public void setOpenBankCode(String openBankCode)
	{
		this.openBankCode = openBankCode;
	}

	public void setOpenBankReservePhone(String openBankReservePhone)
	{
		this.openBankReservePhone = openBankReservePhone;
	}

	public void setAuthorizedPersonCertNo(String authorizedPersonCertNo)
	{
		this.authorizedPersonCertNo = authorizedPersonCertNo;
	}

	public void setAuthorizedPersonCertType(String authorizedPersonCertType)
	{
		this.authorizedPersonCertType = authorizedPersonCertType;
	}

	public void setAuthorizedCertPhotoFront(String authorizedCertPhotoFront)
	{
		this.authorizedCertPhotoFront = authorizedCertPhotoFront;
	}

	public void setAuthorizedCertPhotoBack(String authorizedCertPhotoBack)
	{
		this.authorizedCertPhotoBack = authorizedCertPhotoBack;
	}

	public void setReserve1(String reserve1)
	{
		this.reserve1 = reserve1;
	}

	public void setFeeRateAlipay(String feeRateAlipay)
	{
		this.feeRateAlipay = feeRateAlipay;
	}

	public void setBankCardRateLevel1(String bankCardRateLevel1)
	{
		this.bankCardRateLevel1 = bankCardRateLevel1;
	}

	public void setBankCardRateLevel2(String bankCardRateLevel2)
	{
		this.bankCardRateLevel2 = bankCardRateLevel2;
	}

	public void setFeeRateWechatpay(String feeRateWechatpay)
	{
		this.feeRateWechatpay = feeRateWechatpay;
	}

	public void setFeeRateUnionpayDebit(String feeRateUnionpayDebit)
	{
		this.feeRateUnionpayDebit = feeRateUnionpayDebit;
	}

	public void setFeeRateUnionpayDebitCap(String feeRateUnionpayDebitCap)
	{
		this.feeRateUnionpayDebitCap = feeRateUnionpayDebitCap;
	}

	public void setFeeRateUnionpayCredit(String feeRateUnionpayCredit)
	{
		this.feeRateUnionpayCredit = feeRateUnionpayCredit;
	}
}
