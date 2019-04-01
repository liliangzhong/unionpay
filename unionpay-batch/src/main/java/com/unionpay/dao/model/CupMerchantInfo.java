package com.unionpay.dao.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 银联商户表 cup_merchant_info
 * 
 * @author shark
 * @date 2019-02-25
 */
public class CupMerchantInfo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 商户代码 */
	private String mchntCd;
	/** 商户服务类型 */
	private String mchntSvcTp;
	/** 所属分公司代码 */
	private String cupBranchInsIdCd;
	/** 商户法定名称 */
	private String mchntCnNm;
	/** 商户经营名称 */
	private String mchntCnAbbr;
	/** 收单机构代码 */
	private String acqInsIdCd;
	/** 受理机构代码 */
	private String acptInsIdCd;
	/** 所属平台机构代码 */
	private String platInsIdCd;
	/** 收单接入机构代码 */
	private String acqAccessInsIdCd;
	/** 国家代码 */
	private String cntryCd;
	/** 行政区划代码 */
	private String gbRegionCd;
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
	/** 受卡方名称地址 */
	private String cardAccptNmAddr;
	/** 商户英文名称 */
	private String mchntEnNm;
	/** 商户英文全称 */
	private String mchntEnAbbr;
	/** 交易特殊控制 */
	private String resvFld2;
	/** 联接方式 */
	private String connMd;
	/** 是否MIS商户 */
	private String misMchntIn;
	/** 交易币种 */
	private String mchntAcptCurrBmp;
	/** 默认交易币种 */
	private String mchntDftCurrCd;
	/** 营业证明文件号码 */
	private String licNo;
	/** 执照有效期 */
	private String licExpireDt;
	/** 发证机关 */
	private String issOrgan;
	/** 注册地址 */
	private String regAddr;
	/** 税务登记代码 */
	private String reveRegCd;
	/** 企业性质 */
	private String etpsAttr;
	/** 企业代码 */
	private String corpId;
	/** 法人代表证件类型 */
	private String artifCertifTp;
	/** 法人代表证件号码 */
	private String artifCertifId;
	/** 法人代表姓名 */
	private String artifNm;
	/** 商户联系人 */
	private String contactPersonNm;
	/** 商户联系人通讯地址 */
	private String commAddr;
	/** 邮编 */
	private String zipCd;
	/** 商户联系人电话 */
	private String phone;
	/** 移动电话 */
	private String mobile;
	/** 电子邮件 */
	private String emailAddr;
	/** 传真 */
	private String faxNo;
	/** 财务联系人 */
	private String cfoNm;
	/** 终端维护公司(类型) */
	private String maintnCompanyTp;
	/** 注册资本 */
	private String regCap;
	/** 注册资本币种 */
	private String regCaptialCurrCd;
	/** 经营范围 */
	private String bussRange;
	/** 营业地址 */
	private String bussAddr;
	/** 签约标志 */
	private String signIn;
	/** 电子票据业务标志 */
	private String enotesIn;
	/** 资金入账方式 */
	private String settleInsTp;
	/** 结算行机构代码 */
	private String acctInsIdCd;
	/** 商户清算模式 */
	private String mchntSettleMd;
	/** 入账商户代码 */
	private String packMchntCd;
	/** 资金划付周期 */
	private String cycleSettleTp;
	/** 垫付回补类型 */
	private String prepayReturnTp;
	/** 直联清算标识 */
	private String mchntSettleIn;
	/** 商户开户行名称 */
	private String bankNm1;
	/** 商户开户行行号 */
	private String bankSettleNo1;
	/** 开户行接收行行号 */
	private String mchntSettleBankCd;
	/** 商户账户币种 */
	private String acctCurrCd1;
	/** 商户账户名称 */
	private String acctNm1;
	/** 商户账号 */
	private String acctNo1;
	/** 本金清算类型 */
	private String specSettleIn;
	/** 不清本金发卡机构代码 */
	private String issInsIdCd;
	/** 特殊计费类型 */
	private String specDiscTp;
	/** 特殊计费档次 */
	private String specDiscLvl;
	/** 发卡银联分润算法 */
	private String allotAlgo;
	/** 商户计费算法 */
	private String mchntDiscDetIndex;
	/** 收单分润算法 */
	private String mcmgmAllotItemIndex;
	/** 分润角色 */
	private String allotRole;
	/** 商户服务1 */
	private String allotInsIdCd1;
	/** 商户服务2 */
	private String allotInsIdCd2;
	/** 商户服务3 */
	private String allotInsIdCd3;
	/** 商户服务4 */
	private String allotInsIdCd4;
	/** 商户服务5 */
	private String allotInsIdCd5;
	/** 商户层级 */
	private String mchntClass;
	/** 报表类型 */
	private String rptGenInBmp;
	/** 收单收益帐号 */
	private String insResv7;
	/** 开户行清算号 */
	private String bankSettleSeq;
	/** 是否参加日间清算 */
	private String indaySettleIn;
	/** 商户清算附言 */
	private String addnInf;
	/** 异常时收单垫付标志 */
	private String iferrAcqPayFlag;
	/** 商户优先标志 */
	private String mchntPrioIn;
	/** 日间贷记业务类型号 */
	private String indayCycleMsgNo;
	/** 小额业务种类_日间场次 */
	private String indayCycleBussTp;
	/** 日终贷记业务类型号 */
	private String enddayCycleMsgNo;
	/** 小额业务种类_日终场次 */
	private String enddayCycleBussTp;
	/** 支持的借记业务类型号 */
	private String anyCycleDbitMsgNo;
	/** 支持的借记业务种类 */
	private String anyCycleDbitBussTp;
	/** 商户属性位图 */
	private String mchntAttrBmp;
	/** 费用入账方式 */
	private String feeSettleInsTp;
	/** 商户费用开户行名称 */
	private String mchntFeeBankNm;
	/** 商户费用账号开户行行号 */
	private String mchntFeeAcctBankCd;
	/** 商户费用账号 */
	private String mchntFeeAcct;
	/** 商户费用账户名称 */
	private String mchntFeeAcctNm;
	/** 商户费用开户行清算号 */
	private String mchntFeeSettleBankCd;
	/** 商户费用结算行机构代码 */
	private String mchntFeeAcctInsIdCd;
	/** sp机构代码 */
	private String spInsIdCd;
	/** 行业机构代码 */
	private String industryInsIdCd;
	/** 商户业务处理方式 */
	private String mchntBussProcTp;
	/** 托管应用类型 */
	private String trustAppTp;
	/** 滞纳金计算标志 */
	private String lateFeeCalcIn;
	/** 滞纳金计算模式 */
	private String lateFeeCalcMd;
	/** 滞纳金用户类型 */
	private String lateFeeUsrTp;
	/** 最大票据打印次数 */
	private String maxBillPrintNum;
	/** 固定金额 */
	private String fixAt;
	/** 最低限额 */
	private String lateFeeLowerLimit;
	/** 最高限额 */
	private String lateFeeHigherLimit;
	/** 基准利率 */
	private String lateFeeBaseRt;
	/** 跨年利率 */
	private String lateFeeOverYearRt;
	/** 商户结算性质 */
	private String mchntSettleAttr;
	/** 委托关系是否允许覆盖 */
	private String entrustRelationIn;
	/** 增加主动委托关系标志 */
	private String addActEntrustIn;
	/** 税务类别 */
	private String taxTp;
	/** 清算国库行号/征收机关代码 */
	private String settleTreBankNo;
	/** 密码加密类型 */
	private String pwdEncTp;
	/** 密码加密索引 */
	private String pwdEncIndex;
	/** 渠道接入商代码 */
	private String chnlMchntCd;
	/** 代收授权标志 */
	private String specChargeIn;
	/** 新业务规则启用标志 */
	private String allotIn;
	/** 商户网址 */
	private String svcNetUrl;
	/** 商户网站名称 */
	private String mchntWebSiteNm;
	/** 业务类型 */
	private String bussTp;
	/** 产品功能套餐 */
	private String prodFunc;
	/** 卡种 */
	private String ebussTp;
	/** 共享证书主商户号 */
	private String prodFuncDesc;
	/** 单笔限额 */
	private String singleAtLimit;
	/** 单笔限额说明 */
	private String singleAtLimitDesc;
	/** 单卡单日累计限额 */
	private String singleCardDayAtLimit;
	/** 单卡单日累计限额说明 */
	private String singleCardDayAtLimitDesc;
	/** 业务联系人 */
	private String bussCont1;
	/** 业务联系人固话 */
	private String bussCont1Tel;
	/** 业务联系人移动电话 */
	private String bussCont1Cell;
	/** 业务联系人邮箱 */
	private String bussCont1Email;
	/** 技术联系人 */
	private String bussCont2;
	/** 技术联系人固话 */
	private String bussCont2Tel;
	/** 技术联系人移动电话 */
	private String bussCont2Cell;
	/** 技术联系人邮箱 */
	private String bussCont2Email;
	/** 语音业务类型支持位图 */
	private String cupBranchResv10;
	/** 语音支付合作机构 */
	private String cupBranchResv9;
	/** MAC校验和交易加密标志 */
	private String cycleMchntIn;
	/** 商户交易种类 */
	private String mchntTransTp;
	/** 外卡收单行代码 */
	private String frnAcqInsIdCd;
	/** 第三方服务机构代码 */
	private String insResv8;
	/** 是否向商户收取服务费 */
	private String svcFeeIn;
	/** 是否开展分期付款 */
	private String instlIn;
	/** 客服电话 */
	private String callCenterPhone;
	/** 商户等级 */
	private String mchntLvl;
	/** POS台数 */
	private String posNum;
	/** 收银台数量 */
	private String casherNum;
	/** 开业经营日期 */
	private String mchntOpenDt;
	/** 强制退出时间 */
	private String constrQuitDt;
	/** 商户交易渠道 */
	private String transChnl;
	/** 强制退出原因码 */
	private String constrQuitRsnCd;
	/** 备注 */
	private String remark;
	/** 分公司特殊字段 */
	private String cupBranchSpecFld;
	/** 机构保留字段1 */
	private String insResv1;
	/** 机构保留字段2 */
	private String insResv2;
	/** 机构保留字段3 */
	private String insResv3;
	/** 机构保留字段4 */
	private String insResv4;
	/** 机构保留字段5 */
	private String insResv5;
	/** 机构保留字段6 */
	private String insResv6;
	/** 机构保留字段9 */
	private String insResv9;
	/** 机构保留字段10 */
	private String insResv10;
	/** 分公司保留字段1 */
	private String cupBranchResv1;
	/** 分公司保留字段2 */
	private String cupBranchResv2;
	/** 分公司保留字段3 */
	private String cupBranchResv3;
	/** 分公司保留字段4 */
	private String cupBranchResv4;
	/** 分公司保留字段5 */
	private String cupBranchResv5;
	/** 分公司保留字段6 */
	private String cupBranchResv6;
	/** 分公司保留字段7 */
	private String cupBranchResv7;
	/** 分公司保留字段8 */
	private String cupBranchResv8;
	/** 总公司保留字段1 */
	private String cupHdqrsResv1;
	/** 总公司保留字段2 */
	private String cupHdqrsResv2;
	/** 总公司保留字段3 */
	private String cupHdqrsResv3;
	/** 总公司保留字段4 */
	private String cupHdqrsResv4;
	/** 商户是否有不良记录 */
	private String mchntNegActIn;
	/** 法人是否列入风险商户法人名单 */
	private String riskArtifIn;
	/** 商户是否列入风险商户名单 */
	private String riskMchntIn;
	/** 商户是否列入可疑商户名单 */
	private String susMchntIn;
	/** 总分店标志 */
	private String hdqrsBranchIn;
	/** 总店商户代码 */
	private String hdqrsMchntCd;
	/** 商户拓展方式 */
	private String recnclTp;
	/** 营业证明文件类型 */
	private String netMchntSvcTp;
	/** 收单外包服务机构 */
	private String principalNm;
	/** 网络商户类型 */
	private String submchntIn;
	/** ICP许可证编号 */
	private String svcInsNm;
	/** 商户开票开户银行名称 */
	private String cooking;
	/** 商户开票账号 */
	private String mchntIcp;
	/** 商户开票账户名称 */
	private String trafficLine;
	/** 是否申请非标准价格 */
	private String directAcqSettleIn;
	/** 商户现场注册标识码 */
	private String nmAddr;
	/** 贷记卡发卡银联分润算法 */
	private String allotCd;
	/** 是否开通免密免签 */
	private String mccApplRule;
	/** 品牌 */
	private String masterPwd;
	/** 业务扩展预留字段1 */
	private String mccApplRsnCd;
	/** 业务扩展预留字段2 */
	private String specFeeStdDesc;
	/** 业务扩展预留字段3 */
	private String nmAddr1;

	public void setMchntCd(String mchntCd) 
	{
		this.mchntCd = mchntCd;
	}

	public String getMchntCd() 
	{
		return mchntCd;
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
	public void setGbRegionCd(String gbRegionCd) 
	{
		this.gbRegionCd = gbRegionCd;
	}

	public String getGbRegionCd() 
	{
		return gbRegionCd;
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
	public void setCardAccptNmAddr(String cardAccptNmAddr) 
	{
		this.cardAccptNmAddr = cardAccptNmAddr;
	}

	public String getCardAccptNmAddr() 
	{
		return cardAccptNmAddr;
	}
	public void setMchntEnNm(String mchntEnNm) 
	{
		this.mchntEnNm = mchntEnNm;
	}

	public String getMchntEnNm() 
	{
		return mchntEnNm;
	}
	public void setMchntEnAbbr(String mchntEnAbbr) 
	{
		this.mchntEnAbbr = mchntEnAbbr;
	}

	public String getMchntEnAbbr() 
	{
		return mchntEnAbbr;
	}
	public void setResvFld2(String resvFld2) 
	{
		this.resvFld2 = resvFld2;
	}

	public String getResvFld2() 
	{
		return resvFld2;
	}
	public void setConnMd(String connMd) 
	{
		this.connMd = connMd;
	}

	public String getConnMd() 
	{
		return connMd;
	}
	public void setMisMchntIn(String misMchntIn) 
	{
		this.misMchntIn = misMchntIn;
	}

	public String getMisMchntIn() 
	{
		return misMchntIn;
	}
	public void setMchntAcptCurrBmp(String mchntAcptCurrBmp) 
	{
		this.mchntAcptCurrBmp = mchntAcptCurrBmp;
	}

	public String getMchntAcptCurrBmp() 
	{
		return mchntAcptCurrBmp;
	}
	public void setMchntDftCurrCd(String mchntDftCurrCd) 
	{
		this.mchntDftCurrCd = mchntDftCurrCd;
	}

	public String getMchntDftCurrCd() 
	{
		return mchntDftCurrCd;
	}
	public void setLicNo(String licNo) 
	{
		this.licNo = licNo;
	}

	public String getLicNo() 
	{
		return licNo;
	}
	public void setLicExpireDt(String licExpireDt) 
	{
		this.licExpireDt = licExpireDt;
	}

	public String getLicExpireDt() 
	{
		return licExpireDt;
	}
	public void setIssOrgan(String issOrgan) 
	{
		this.issOrgan = issOrgan;
	}

	public String getIssOrgan() 
	{
		return issOrgan;
	}
	public void setRegAddr(String regAddr) 
	{
		this.regAddr = regAddr;
	}

	public String getRegAddr() 
	{
		return regAddr;
	}
	public void setReveRegCd(String reveRegCd) 
	{
		this.reveRegCd = reveRegCd;
	}

	public String getReveRegCd() 
	{
		return reveRegCd;
	}
	public void setEtpsAttr(String etpsAttr) 
	{
		this.etpsAttr = etpsAttr;
	}

	public String getEtpsAttr() 
	{
		return etpsAttr;
	}
	public void setCorpId(String corpId) 
	{
		this.corpId = corpId;
	}

	public String getCorpId() 
	{
		return corpId;
	}
	public void setArtifCertifTp(String artifCertifTp) 
	{
		this.artifCertifTp = artifCertifTp;
	}

	public String getArtifCertifTp() 
	{
		return artifCertifTp;
	}
	public void setArtifCertifId(String artifCertifId) 
	{
		this.artifCertifId = artifCertifId;
	}

	public String getArtifCertifId() 
	{
		return artifCertifId;
	}
	public void setArtifNm(String artifNm) 
	{
		this.artifNm = artifNm;
	}

	public String getArtifNm() 
	{
		return artifNm;
	}
	public void setContactPersonNm(String contactPersonNm) 
	{
		this.contactPersonNm = contactPersonNm;
	}

	public String getContactPersonNm() 
	{
		return contactPersonNm;
	}
	public void setCommAddr(String commAddr) 
	{
		this.commAddr = commAddr;
	}

	public String getCommAddr() 
	{
		return commAddr;
	}
	public void setZipCd(String zipCd) 
	{
		this.zipCd = zipCd;
	}

	public String getZipCd() 
	{
		return zipCd;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}

	public String getMobile() 
	{
		return mobile;
	}
	public void setEmailAddr(String emailAddr) 
	{
		this.emailAddr = emailAddr;
	}

	public String getEmailAddr() 
	{
		return emailAddr;
	}
	public void setFaxNo(String faxNo) 
	{
		this.faxNo = faxNo;
	}

	public String getFaxNo() 
	{
		return faxNo;
	}
	public void setCfoNm(String cfoNm) 
	{
		this.cfoNm = cfoNm;
	}

	public String getCfoNm() 
	{
		return cfoNm;
	}
	public void setMaintnCompanyTp(String maintnCompanyTp) 
	{
		this.maintnCompanyTp = maintnCompanyTp;
	}

	public String getMaintnCompanyTp() 
	{
		return maintnCompanyTp;
	}
	public void setRegCap(String regCap) 
	{
		this.regCap = regCap;
	}

	public String getRegCap() 
	{
		return regCap;
	}
	public void setRegCaptialCurrCd(String regCaptialCurrCd) 
	{
		this.regCaptialCurrCd = regCaptialCurrCd;
	}

	public String getRegCaptialCurrCd() 
	{
		return regCaptialCurrCd;
	}
	public void setBussRange(String bussRange) 
	{
		this.bussRange = bussRange;
	}

	public String getBussRange() 
	{
		return bussRange;
	}
	public void setBussAddr(String bussAddr) 
	{
		this.bussAddr = bussAddr;
	}

	public String getBussAddr() 
	{
		return bussAddr;
	}
	public void setSignIn(String signIn) 
	{
		this.signIn = signIn;
	}

	public String getSignIn() 
	{
		return signIn;
	}
	public void setEnotesIn(String enotesIn) 
	{
		this.enotesIn = enotesIn;
	}

	public String getEnotesIn() 
	{
		return enotesIn;
	}
	public void setSettleInsTp(String settleInsTp) 
	{
		this.settleInsTp = settleInsTp;
	}

	public String getSettleInsTp() 
	{
		return settleInsTp;
	}
	public void setAcctInsIdCd(String acctInsIdCd) 
	{
		this.acctInsIdCd = acctInsIdCd;
	}

	public String getAcctInsIdCd() 
	{
		return acctInsIdCd;
	}
	public void setMchntSettleMd(String mchntSettleMd) 
	{
		this.mchntSettleMd = mchntSettleMd;
	}

	public String getMchntSettleMd() 
	{
		return mchntSettleMd;
	}
	public void setPackMchntCd(String packMchntCd) 
	{
		this.packMchntCd = packMchntCd;
	}

	public String getPackMchntCd() 
	{
		return packMchntCd;
	}
	public void setCycleSettleTp(String cycleSettleTp) 
	{
		this.cycleSettleTp = cycleSettleTp;
	}

	public String getCycleSettleTp() 
	{
		return cycleSettleTp;
	}
	public void setPrepayReturnTp(String prepayReturnTp) 
	{
		this.prepayReturnTp = prepayReturnTp;
	}

	public String getPrepayReturnTp() 
	{
		return prepayReturnTp;
	}
	public void setMchntSettleIn(String mchntSettleIn) 
	{
		this.mchntSettleIn = mchntSettleIn;
	}

	public String getMchntSettleIn() 
	{
		return mchntSettleIn;
	}
	public void setBankNm1(String bankNm1) 
	{
		this.bankNm1 = bankNm1;
	}

	public String getBankNm1() 
	{
		return bankNm1;
	}
	public void setBankSettleNo1(String bankSettleNo1) 
	{
		this.bankSettleNo1 = bankSettleNo1;
	}

	public String getBankSettleNo1() 
	{
		return bankSettleNo1;
	}
	public void setMchntSettleBankCd(String mchntSettleBankCd) 
	{
		this.mchntSettleBankCd = mchntSettleBankCd;
	}

	public String getMchntSettleBankCd() 
	{
		return mchntSettleBankCd;
	}
	public void setAcctCurrCd1(String acctCurrCd1) 
	{
		this.acctCurrCd1 = acctCurrCd1;
	}

	public String getAcctCurrCd1() 
	{
		return acctCurrCd1;
	}
	public void setAcctNm1(String acctNm1) 
	{
		this.acctNm1 = acctNm1;
	}

	public String getAcctNm1() 
	{
		return acctNm1;
	}
	public void setAcctNo1(String acctNo1) 
	{
		this.acctNo1 = acctNo1;
	}

	public String getAcctNo1() 
	{
		return acctNo1;
	}
	public void setSpecSettleIn(String specSettleIn) 
	{
		this.specSettleIn = specSettleIn;
	}

	public String getSpecSettleIn() 
	{
		return specSettleIn;
	}
	public void setIssInsIdCd(String issInsIdCd) 
	{
		this.issInsIdCd = issInsIdCd;
	}

	public String getIssInsIdCd() 
	{
		return issInsIdCd;
	}
	public void setSpecDiscTp(String specDiscTp) 
	{
		this.specDiscTp = specDiscTp;
	}

	public String getSpecDiscTp() 
	{
		return specDiscTp;
	}
	public void setSpecDiscLvl(String specDiscLvl) 
	{
		this.specDiscLvl = specDiscLvl;
	}

	public String getSpecDiscLvl() 
	{
		return specDiscLvl;
	}
	public void setAllotAlgo(String allotAlgo) 
	{
		this.allotAlgo = allotAlgo;
	}

	public String getAllotAlgo() 
	{
		return allotAlgo;
	}
	public void setMchntDiscDetIndex(String mchntDiscDetIndex) 
	{
		this.mchntDiscDetIndex = mchntDiscDetIndex;
	}

	public String getMchntDiscDetIndex() 
	{
		return mchntDiscDetIndex;
	}
	public void setMcmgmAllotItemIndex(String mcmgmAllotItemIndex) 
	{
		this.mcmgmAllotItemIndex = mcmgmAllotItemIndex;
	}

	public String getMcmgmAllotItemIndex() 
	{
		return mcmgmAllotItemIndex;
	}
	public void setAllotRole(String allotRole) 
	{
		this.allotRole = allotRole;
	}

	public String getAllotRole() 
	{
		return allotRole;
	}
	public void setAllotInsIdCd1(String allotInsIdCd1) 
	{
		this.allotInsIdCd1 = allotInsIdCd1;
	}

	public String getAllotInsIdCd1() 
	{
		return allotInsIdCd1;
	}
	public void setAllotInsIdCd2(String allotInsIdCd2) 
	{
		this.allotInsIdCd2 = allotInsIdCd2;
	}

	public String getAllotInsIdCd2() 
	{
		return allotInsIdCd2;
	}
	public void setAllotInsIdCd3(String allotInsIdCd3) 
	{
		this.allotInsIdCd3 = allotInsIdCd3;
	}

	public String getAllotInsIdCd3() 
	{
		return allotInsIdCd3;
	}
	public void setAllotInsIdCd4(String allotInsIdCd4) 
	{
		this.allotInsIdCd4 = allotInsIdCd4;
	}

	public String getAllotInsIdCd4() 
	{
		return allotInsIdCd4;
	}
	public void setAllotInsIdCd5(String allotInsIdCd5) 
	{
		this.allotInsIdCd5 = allotInsIdCd5;
	}

	public String getAllotInsIdCd5() 
	{
		return allotInsIdCd5;
	}
	public void setMchntClass(String mchntClass) 
	{
		this.mchntClass = mchntClass;
	}

	public String getMchntClass() 
	{
		return mchntClass;
	}
	public void setRptGenInBmp(String rptGenInBmp) 
	{
		this.rptGenInBmp = rptGenInBmp;
	}

	public String getRptGenInBmp() 
	{
		return rptGenInBmp;
	}
	public void setInsResv7(String insResv7) 
	{
		this.insResv7 = insResv7;
	}

	public String getInsResv7() 
	{
		return insResv7;
	}
	public void setBankSettleSeq(String bankSettleSeq) 
	{
		this.bankSettleSeq = bankSettleSeq;
	}

	public String getBankSettleSeq() 
	{
		return bankSettleSeq;
	}
	public void setIndaySettleIn(String indaySettleIn) 
	{
		this.indaySettleIn = indaySettleIn;
	}

	public String getIndaySettleIn() 
	{
		return indaySettleIn;
	}
	public void setAddnInf(String addnInf) 
	{
		this.addnInf = addnInf;
	}

	public String getAddnInf() 
	{
		return addnInf;
	}
	public void setIferrAcqPayFlag(String iferrAcqPayFlag) 
	{
		this.iferrAcqPayFlag = iferrAcqPayFlag;
	}

	public String getIferrAcqPayFlag() 
	{
		return iferrAcqPayFlag;
	}
	public void setMchntPrioIn(String mchntPrioIn) 
	{
		this.mchntPrioIn = mchntPrioIn;
	}

	public String getMchntPrioIn() 
	{
		return mchntPrioIn;
	}
	public void setIndayCycleMsgNo(String indayCycleMsgNo) 
	{
		this.indayCycleMsgNo = indayCycleMsgNo;
	}

	public String getIndayCycleMsgNo() 
	{
		return indayCycleMsgNo;
	}
	public void setIndayCycleBussTp(String indayCycleBussTp) 
	{
		this.indayCycleBussTp = indayCycleBussTp;
	}

	public String getIndayCycleBussTp() 
	{
		return indayCycleBussTp;
	}
	public void setEnddayCycleMsgNo(String enddayCycleMsgNo) 
	{
		this.enddayCycleMsgNo = enddayCycleMsgNo;
	}

	public String getEnddayCycleMsgNo() 
	{
		return enddayCycleMsgNo;
	}
	public void setEnddayCycleBussTp(String enddayCycleBussTp) 
	{
		this.enddayCycleBussTp = enddayCycleBussTp;
	}

	public String getEnddayCycleBussTp() 
	{
		return enddayCycleBussTp;
	}
	public void setAnyCycleDbitMsgNo(String anyCycleDbitMsgNo) 
	{
		this.anyCycleDbitMsgNo = anyCycleDbitMsgNo;
	}

	public String getAnyCycleDbitMsgNo() 
	{
		return anyCycleDbitMsgNo;
	}
	public void setAnyCycleDbitBussTp(String anyCycleDbitBussTp) 
	{
		this.anyCycleDbitBussTp = anyCycleDbitBussTp;
	}

	public String getAnyCycleDbitBussTp() 
	{
		return anyCycleDbitBussTp;
	}
	public void setMchntAttrBmp(String mchntAttrBmp) 
	{
		this.mchntAttrBmp = mchntAttrBmp;
	}

	public String getMchntAttrBmp() 
	{
		return mchntAttrBmp;
	}
	public void setFeeSettleInsTp(String feeSettleInsTp) 
	{
		this.feeSettleInsTp = feeSettleInsTp;
	}

	public String getFeeSettleInsTp() 
	{
		return feeSettleInsTp;
	}
	public void setMchntFeeBankNm(String mchntFeeBankNm) 
	{
		this.mchntFeeBankNm = mchntFeeBankNm;
	}

	public String getMchntFeeBankNm() 
	{
		return mchntFeeBankNm;
	}
	public void setMchntFeeAcctBankCd(String mchntFeeAcctBankCd) 
	{
		this.mchntFeeAcctBankCd = mchntFeeAcctBankCd;
	}

	public String getMchntFeeAcctBankCd() 
	{
		return mchntFeeAcctBankCd;
	}
	public void setMchntFeeAcct(String mchntFeeAcct) 
	{
		this.mchntFeeAcct = mchntFeeAcct;
	}

	public String getMchntFeeAcct() 
	{
		return mchntFeeAcct;
	}
	public void setMchntFeeAcctNm(String mchntFeeAcctNm) 
	{
		this.mchntFeeAcctNm = mchntFeeAcctNm;
	}

	public String getMchntFeeAcctNm() 
	{
		return mchntFeeAcctNm;
	}
	public void setMchntFeeSettleBankCd(String mchntFeeSettleBankCd) 
	{
		this.mchntFeeSettleBankCd = mchntFeeSettleBankCd;
	}

	public String getMchntFeeSettleBankCd() 
	{
		return mchntFeeSettleBankCd;
	}
	public void setMchntFeeAcctInsIdCd(String mchntFeeAcctInsIdCd) 
	{
		this.mchntFeeAcctInsIdCd = mchntFeeAcctInsIdCd;
	}

	public String getMchntFeeAcctInsIdCd() 
	{
		return mchntFeeAcctInsIdCd;
	}
	public void setSpInsIdCd(String spInsIdCd) 
	{
		this.spInsIdCd = spInsIdCd;
	}

	public String getSpInsIdCd() 
	{
		return spInsIdCd;
	}
	public void setIndustryInsIdCd(String industryInsIdCd) 
	{
		this.industryInsIdCd = industryInsIdCd;
	}

	public String getIndustryInsIdCd() 
	{
		return industryInsIdCd;
	}
	public void setMchntBussProcTp(String mchntBussProcTp) 
	{
		this.mchntBussProcTp = mchntBussProcTp;
	}

	public String getMchntBussProcTp() 
	{
		return mchntBussProcTp;
	}
	public void setTrustAppTp(String trustAppTp) 
	{
		this.trustAppTp = trustAppTp;
	}

	public String getTrustAppTp() 
	{
		return trustAppTp;
	}
	public void setLateFeeCalcIn(String lateFeeCalcIn) 
	{
		this.lateFeeCalcIn = lateFeeCalcIn;
	}

	public String getLateFeeCalcIn() 
	{
		return lateFeeCalcIn;
	}
	public void setLateFeeCalcMd(String lateFeeCalcMd) 
	{
		this.lateFeeCalcMd = lateFeeCalcMd;
	}

	public String getLateFeeCalcMd() 
	{
		return lateFeeCalcMd;
	}
	public void setLateFeeUsrTp(String lateFeeUsrTp) 
	{
		this.lateFeeUsrTp = lateFeeUsrTp;
	}

	public String getLateFeeUsrTp() 
	{
		return lateFeeUsrTp;
	}
	public void setMaxBillPrintNum(String maxBillPrintNum) 
	{
		this.maxBillPrintNum = maxBillPrintNum;
	}

	public String getMaxBillPrintNum() 
	{
		return maxBillPrintNum;
	}
	public void setFixAt(String fixAt) 
	{
		this.fixAt = fixAt;
	}

	public String getFixAt() 
	{
		return fixAt;
	}
	public void setLateFeeLowerLimit(String lateFeeLowerLimit) 
	{
		this.lateFeeLowerLimit = lateFeeLowerLimit;
	}

	public String getLateFeeLowerLimit() 
	{
		return lateFeeLowerLimit;
	}
	public void setLateFeeHigherLimit(String lateFeeHigherLimit) 
	{
		this.lateFeeHigherLimit = lateFeeHigherLimit;
	}

	public String getLateFeeHigherLimit() 
	{
		return lateFeeHigherLimit;
	}
	public void setLateFeeBaseRt(String lateFeeBaseRt) 
	{
		this.lateFeeBaseRt = lateFeeBaseRt;
	}

	public String getLateFeeBaseRt() 
	{
		return lateFeeBaseRt;
	}
	public void setLateFeeOverYearRt(String lateFeeOverYearRt) 
	{
		this.lateFeeOverYearRt = lateFeeOverYearRt;
	}

	public String getLateFeeOverYearRt() 
	{
		return lateFeeOverYearRt;
	}
	public void setMchntSettleAttr(String mchntSettleAttr) 
	{
		this.mchntSettleAttr = mchntSettleAttr;
	}

	public String getMchntSettleAttr() 
	{
		return mchntSettleAttr;
	}
	public void setEntrustRelationIn(String entrustRelationIn) 
	{
		this.entrustRelationIn = entrustRelationIn;
	}

	public String getEntrustRelationIn() 
	{
		return entrustRelationIn;
	}
	public void setAddActEntrustIn(String addActEntrustIn) 
	{
		this.addActEntrustIn = addActEntrustIn;
	}

	public String getAddActEntrustIn() 
	{
		return addActEntrustIn;
	}
	public void setTaxTp(String taxTp) 
	{
		this.taxTp = taxTp;
	}

	public String getTaxTp() 
	{
		return taxTp;
	}
	public void setSettleTreBankNo(String settleTreBankNo) 
	{
		this.settleTreBankNo = settleTreBankNo;
	}

	public String getSettleTreBankNo() 
	{
		return settleTreBankNo;
	}
	public void setPwdEncTp(String pwdEncTp) 
	{
		this.pwdEncTp = pwdEncTp;
	}

	public String getPwdEncTp() 
	{
		return pwdEncTp;
	}
	public void setPwdEncIndex(String pwdEncIndex) 
	{
		this.pwdEncIndex = pwdEncIndex;
	}

	public String getPwdEncIndex() 
	{
		return pwdEncIndex;
	}
	public void setChnlMchntCd(String chnlMchntCd) 
	{
		this.chnlMchntCd = chnlMchntCd;
	}

	public String getChnlMchntCd() 
	{
		return chnlMchntCd;
	}
	public void setSpecChargeIn(String specChargeIn) 
	{
		this.specChargeIn = specChargeIn;
	}

	public String getSpecChargeIn() 
	{
		return specChargeIn;
	}
	public void setAllotIn(String allotIn) 
	{
		this.allotIn = allotIn;
	}

	public String getAllotIn() 
	{
		return allotIn;
	}
	public void setSvcNetUrl(String svcNetUrl) 
	{
		this.svcNetUrl = svcNetUrl;
	}

	public String getSvcNetUrl() 
	{
		return svcNetUrl;
	}
	public void setMchntWebSiteNm(String mchntWebSiteNm) 
	{
		this.mchntWebSiteNm = mchntWebSiteNm;
	}

	public String getMchntWebSiteNm() 
	{
		return mchntWebSiteNm;
	}
	public void setBussTp(String bussTp) 
	{
		this.bussTp = bussTp;
	}

	public String getBussTp() 
	{
		return bussTp;
	}
	public void setProdFunc(String prodFunc) 
	{
		this.prodFunc = prodFunc;
	}

	public String getProdFunc() 
	{
		return prodFunc;
	}
	public void setEbussTp(String ebussTp) 
	{
		this.ebussTp = ebussTp;
	}

	public String getEbussTp() 
	{
		return ebussTp;
	}
	public void setProdFuncDesc(String prodFuncDesc) 
	{
		this.prodFuncDesc = prodFuncDesc;
	}

	public String getProdFuncDesc() 
	{
		return prodFuncDesc;
	}
	public void setSingleAtLimit(String singleAtLimit) 
	{
		this.singleAtLimit = singleAtLimit;
	}

	public String getSingleAtLimit() 
	{
		return singleAtLimit;
	}
	public void setSingleAtLimitDesc(String singleAtLimitDesc) 
	{
		this.singleAtLimitDesc = singleAtLimitDesc;
	}

	public String getSingleAtLimitDesc() 
	{
		return singleAtLimitDesc;
	}
	public void setSingleCardDayAtLimit(String singleCardDayAtLimit) 
	{
		this.singleCardDayAtLimit = singleCardDayAtLimit;
	}

	public String getSingleCardDayAtLimit() 
	{
		return singleCardDayAtLimit;
	}
	public void setSingleCardDayAtLimitDesc(String singleCardDayAtLimitDesc) 
	{
		this.singleCardDayAtLimitDesc = singleCardDayAtLimitDesc;
	}

	public String getSingleCardDayAtLimitDesc() 
	{
		return singleCardDayAtLimitDesc;
	}
	public void setBussCont1(String bussCont1) 
	{
		this.bussCont1 = bussCont1;
	}

	public String getBussCont1() 
	{
		return bussCont1;
	}
	public void setBussCont1Tel(String bussCont1Tel) 
	{
		this.bussCont1Tel = bussCont1Tel;
	}

	public String getBussCont1Tel() 
	{
		return bussCont1Tel;
	}
	public void setBussCont1Cell(String bussCont1Cell) 
	{
		this.bussCont1Cell = bussCont1Cell;
	}

	public String getBussCont1Cell() 
	{
		return bussCont1Cell;
	}
	public void setBussCont1Email(String bussCont1Email) 
	{
		this.bussCont1Email = bussCont1Email;
	}

	public String getBussCont1Email() 
	{
		return bussCont1Email;
	}
	public void setBussCont2(String bussCont2) 
	{
		this.bussCont2 = bussCont2;
	}

	public String getBussCont2() 
	{
		return bussCont2;
	}
	public void setBussCont2Tel(String bussCont2Tel) 
	{
		this.bussCont2Tel = bussCont2Tel;
	}

	public String getBussCont2Tel() 
	{
		return bussCont2Tel;
	}
	public void setBussCont2Cell(String bussCont2Cell) 
	{
		this.bussCont2Cell = bussCont2Cell;
	}

	public String getBussCont2Cell() 
	{
		return bussCont2Cell;
	}
	public void setBussCont2Email(String bussCont2Email) 
	{
		this.bussCont2Email = bussCont2Email;
	}

	public String getBussCont2Email() 
	{
		return bussCont2Email;
	}
	public void setCupBranchResv10(String cupBranchResv10) 
	{
		this.cupBranchResv10 = cupBranchResv10;
	}

	public String getCupBranchResv10() 
	{
		return cupBranchResv10;
	}
	public void setCupBranchResv9(String cupBranchResv9) 
	{
		this.cupBranchResv9 = cupBranchResv9;
	}

	public String getCupBranchResv9() 
	{
		return cupBranchResv9;
	}
	public void setCycleMchntIn(String cycleMchntIn) 
	{
		this.cycleMchntIn = cycleMchntIn;
	}

	public String getCycleMchntIn() 
	{
		return cycleMchntIn;
	}
	public void setMchntTransTp(String mchntTransTp) 
	{
		this.mchntTransTp = mchntTransTp;
	}

	public String getMchntTransTp() 
	{
		return mchntTransTp;
	}
	public void setFrnAcqInsIdCd(String frnAcqInsIdCd) 
	{
		this.frnAcqInsIdCd = frnAcqInsIdCd;
	}

	public String getFrnAcqInsIdCd() 
	{
		return frnAcqInsIdCd;
	}
	public void setInsResv8(String insResv8) 
	{
		this.insResv8 = insResv8;
	}

	public String getInsResv8() 
	{
		return insResv8;
	}
	public void setSvcFeeIn(String svcFeeIn) 
	{
		this.svcFeeIn = svcFeeIn;
	}

	public String getSvcFeeIn() 
	{
		return svcFeeIn;
	}
	public void setInstlIn(String instlIn) 
	{
		this.instlIn = instlIn;
	}

	public String getInstlIn() 
	{
		return instlIn;
	}
	public void setCallCenterPhone(String callCenterPhone) 
	{
		this.callCenterPhone = callCenterPhone;
	}

	public String getCallCenterPhone() 
	{
		return callCenterPhone;
	}
	public void setMchntLvl(String mchntLvl) 
	{
		this.mchntLvl = mchntLvl;
	}

	public String getMchntLvl() 
	{
		return mchntLvl;
	}
	public void setPosNum(String posNum) 
	{
		this.posNum = posNum;
	}

	public String getPosNum() 
	{
		return posNum;
	}
	public void setCasherNum(String casherNum) 
	{
		this.casherNum = casherNum;
	}

	public String getCasherNum() 
	{
		return casherNum;
	}
	public void setMchntOpenDt(String mchntOpenDt) 
	{
		this.mchntOpenDt = mchntOpenDt;
	}

	public String getMchntOpenDt() 
	{
		return mchntOpenDt;
	}
	public void setConstrQuitDt(String constrQuitDt) 
	{
		this.constrQuitDt = constrQuitDt;
	}

	public String getConstrQuitDt() 
	{
		return constrQuitDt;
	}
	public void setTransChnl(String transChnl) 
	{
		this.transChnl = transChnl;
	}

	public String getTransChnl() 
	{
		return transChnl;
	}
	public void setConstrQuitRsnCd(String constrQuitRsnCd) 
	{
		this.constrQuitRsnCd = constrQuitRsnCd;
	}

	public String getConstrQuitRsnCd() 
	{
		return constrQuitRsnCd;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setCupBranchSpecFld(String cupBranchSpecFld) 
	{
		this.cupBranchSpecFld = cupBranchSpecFld;
	}

	public String getCupBranchSpecFld() 
	{
		return cupBranchSpecFld;
	}
	public void setInsResv1(String insResv1) 
	{
		this.insResv1 = insResv1;
	}

	public String getInsResv1() 
	{
		return insResv1;
	}
	public void setInsResv2(String insResv2) 
	{
		this.insResv2 = insResv2;
	}

	public String getInsResv2() 
	{
		return insResv2;
	}
	public void setInsResv3(String insResv3) 
	{
		this.insResv3 = insResv3;
	}

	public String getInsResv3() 
	{
		return insResv3;
	}
	public void setInsResv4(String insResv4) 
	{
		this.insResv4 = insResv4;
	}

	public String getInsResv4() 
	{
		return insResv4;
	}
	public void setInsResv5(String insResv5) 
	{
		this.insResv5 = insResv5;
	}

	public String getInsResv5() 
	{
		return insResv5;
	}
	public void setInsResv6(String insResv6) 
	{
		this.insResv6 = insResv6;
	}

	public String getInsResv6() 
	{
		return insResv6;
	}
	public void setInsResv9(String insResv9) 
	{
		this.insResv9 = insResv9;
	}

	public String getInsResv9() 
	{
		return insResv9;
	}
	public void setInsResv10(String insResv10) 
	{
		this.insResv10 = insResv10;
	}

	public String getInsResv10() 
	{
		return insResv10;
	}
	public void setCupBranchResv1(String cupBranchResv1) 
	{
		this.cupBranchResv1 = cupBranchResv1;
	}

	public String getCupBranchResv1() 
	{
		return cupBranchResv1;
	}
	public void setCupBranchResv2(String cupBranchResv2) 
	{
		this.cupBranchResv2 = cupBranchResv2;
	}

	public String getCupBranchResv2() 
	{
		return cupBranchResv2;
	}
	public void setCupBranchResv3(String cupBranchResv3) 
	{
		this.cupBranchResv3 = cupBranchResv3;
	}

	public String getCupBranchResv3() 
	{
		return cupBranchResv3;
	}
	public void setCupBranchResv4(String cupBranchResv4) 
	{
		this.cupBranchResv4 = cupBranchResv4;
	}

	public String getCupBranchResv4() 
	{
		return cupBranchResv4;
	}
	public void setCupBranchResv5(String cupBranchResv5) 
	{
		this.cupBranchResv5 = cupBranchResv5;
	}

	public String getCupBranchResv5() 
	{
		return cupBranchResv5;
	}
	public void setCupBranchResv6(String cupBranchResv6) 
	{
		this.cupBranchResv6 = cupBranchResv6;
	}

	public String getCupBranchResv6() 
	{
		return cupBranchResv6;
	}
	public void setCupBranchResv7(String cupBranchResv7) 
	{
		this.cupBranchResv7 = cupBranchResv7;
	}

	public String getCupBranchResv7() 
	{
		return cupBranchResv7;
	}
	public void setCupBranchResv8(String cupBranchResv8) 
	{
		this.cupBranchResv8 = cupBranchResv8;
	}

	public String getCupBranchResv8() 
	{
		return cupBranchResv8;
	}
	public void setCupHdqrsResv1(String cupHdqrsResv1) 
	{
		this.cupHdqrsResv1 = cupHdqrsResv1;
	}

	public String getCupHdqrsResv1() 
	{
		return cupHdqrsResv1;
	}
	public void setCupHdqrsResv2(String cupHdqrsResv2) 
	{
		this.cupHdqrsResv2 = cupHdqrsResv2;
	}

	public String getCupHdqrsResv2() 
	{
		return cupHdqrsResv2;
	}
	public void setCupHdqrsResv3(String cupHdqrsResv3) 
	{
		this.cupHdqrsResv3 = cupHdqrsResv3;
	}

	public String getCupHdqrsResv3() 
	{
		return cupHdqrsResv3;
	}
	public void setCupHdqrsResv4(String cupHdqrsResv4) 
	{
		this.cupHdqrsResv4 = cupHdqrsResv4;
	}

	public String getCupHdqrsResv4() 
	{
		return cupHdqrsResv4;
	}
	public void setMchntNegActIn(String mchntNegActIn) 
	{
		this.mchntNegActIn = mchntNegActIn;
	}

	public String getMchntNegActIn() 
	{
		return mchntNegActIn;
	}
	public void setRiskArtifIn(String riskArtifIn) 
	{
		this.riskArtifIn = riskArtifIn;
	}

	public String getRiskArtifIn() 
	{
		return riskArtifIn;
	}
	public void setRiskMchntIn(String riskMchntIn) 
	{
		this.riskMchntIn = riskMchntIn;
	}

	public String getRiskMchntIn() 
	{
		return riskMchntIn;
	}
	public void setSusMchntIn(String susMchntIn) 
	{
		this.susMchntIn = susMchntIn;
	}

	public String getSusMchntIn() 
	{
		return susMchntIn;
	}
	public void setHdqrsBranchIn(String hdqrsBranchIn) 
	{
		this.hdqrsBranchIn = hdqrsBranchIn;
	}

	public String getHdqrsBranchIn() 
	{
		return hdqrsBranchIn;
	}
	public void setHdqrsMchntCd(String hdqrsMchntCd) 
	{
		this.hdqrsMchntCd = hdqrsMchntCd;
	}

	public String getHdqrsMchntCd() 
	{
		return hdqrsMchntCd;
	}
	public void setRecnclTp(String recnclTp) 
	{
		this.recnclTp = recnclTp;
	}

	public String getRecnclTp() 
	{
		return recnclTp;
	}
	public void setNetMchntSvcTp(String netMchntSvcTp) 
	{
		this.netMchntSvcTp = netMchntSvcTp;
	}

	public String getNetMchntSvcTp() 
	{
		return netMchntSvcTp;
	}
	public void setPrincipalNm(String principalNm) 
	{
		this.principalNm = principalNm;
	}

	public String getPrincipalNm() 
	{
		return principalNm;
	}
	public void setSubmchntIn(String submchntIn) 
	{
		this.submchntIn = submchntIn;
	}

	public String getSubmchntIn() 
	{
		return submchntIn;
	}
	public void setSvcInsNm(String svcInsNm) 
	{
		this.svcInsNm = svcInsNm;
	}

	public String getSvcInsNm() 
	{
		return svcInsNm;
	}
	public void setCooking(String cooking) 
	{
		this.cooking = cooking;
	}

	public String getCooking() 
	{
		return cooking;
	}
	public void setMchntIcp(String mchntIcp) 
	{
		this.mchntIcp = mchntIcp;
	}

	public String getMchntIcp() 
	{
		return mchntIcp;
	}
	public void setTrafficLine(String trafficLine) 
	{
		this.trafficLine = trafficLine;
	}

	public String getTrafficLine() 
	{
		return trafficLine;
	}
	public void setDirectAcqSettleIn(String directAcqSettleIn) 
	{
		this.directAcqSettleIn = directAcqSettleIn;
	}

	public String getDirectAcqSettleIn() 
	{
		return directAcqSettleIn;
	}
	public void setNmAddr(String nmAddr) 
	{
		this.nmAddr = nmAddr;
	}

	public String getNmAddr() 
	{
		return nmAddr;
	}
	public void setAllotCd(String allotCd) 
	{
		this.allotCd = allotCd;
	}

	public String getAllotCd() 
	{
		return allotCd;
	}
	public void setMccApplRule(String mccApplRule) 
	{
		this.mccApplRule = mccApplRule;
	}

	public String getMccApplRule() 
	{
		return mccApplRule;
	}
	public void setMasterPwd(String masterPwd) 
	{
		this.masterPwd = masterPwd;
	}

	public String getMasterPwd() 
	{
		return masterPwd;
	}
	public void setMccApplRsnCd(String mccApplRsnCd) 
	{
		this.mccApplRsnCd = mccApplRsnCd;
	}

	public String getMccApplRsnCd() 
	{
		return mccApplRsnCd;
	}
	public void setSpecFeeStdDesc(String specFeeStdDesc) 
	{
		this.specFeeStdDesc = specFeeStdDesc;
	}

	public String getSpecFeeStdDesc() 
	{
		return specFeeStdDesc;
	}
	public void setNmAddr1(String nmAddr1) 
	{
		this.nmAddr1 = nmAddr1;
	}

	public String getNmAddr1() 
	{
		return nmAddr1;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mchntCd", getMchntCd())
            .append("mchntSvcTp", getMchntSvcTp())
            .append("cupBranchInsIdCd", getCupBranchInsIdCd())
            .append("mchntCnNm", getMchntCnNm())
            .append("mchntCnAbbr", getMchntCnAbbr())
            .append("acqInsIdCd", getAcqInsIdCd())
            .append("acptInsIdCd", getAcptInsIdCd())
            .append("platInsIdCd", getPlatInsIdCd())
            .append("acqAccessInsIdCd", getAcqAccessInsIdCd())
            .append("cntryCd", getCntryCd())
            .append("gbRegionCd", getGbRegionCd())
            .append("acqRegionCd", getAcqRegionCd())
            .append("mchntTp", getMchntTp())
            .append("regionCd", getRegionCd())
            .append("realMchntTp", getRealMchntTp())
            .append("mchntGrp", getMchntGrp())
            .append("mchntSt", getMchntSt())
            .append("industryTp", getIndustryTp())
            .append("cardAccptNmAddr", getCardAccptNmAddr())
            .append("mchntEnNm", getMchntEnNm())
            .append("mchntEnAbbr", getMchntEnAbbr())
            .append("resvFld2", getResvFld2())
            .append("connMd", getConnMd())
            .append("misMchntIn", getMisMchntIn())
            .append("mchntAcptCurrBmp", getMchntAcptCurrBmp())
            .append("mchntDftCurrCd", getMchntDftCurrCd())
            .append("licNo", getLicNo())
            .append("licExpireDt", getLicExpireDt())
            .append("issOrgan", getIssOrgan())
            .append("regAddr", getRegAddr())
            .append("reveRegCd", getReveRegCd())
            .append("etpsAttr", getEtpsAttr())
            .append("corpId", getCorpId())
            .append("artifCertifTp", getArtifCertifTp())
            .append("artifCertifId", getArtifCertifId())
            .append("artifNm", getArtifNm())
            .append("contactPersonNm", getContactPersonNm())
            .append("commAddr", getCommAddr())
            .append("zipCd", getZipCd())
            .append("phone", getPhone())
            .append("mobile", getMobile())
            .append("emailAddr", getEmailAddr())
            .append("faxNo", getFaxNo())
            .append("cfoNm", getCfoNm())
            .append("maintnCompanyTp", getMaintnCompanyTp())
            .append("regCap", getRegCap())
            .append("regCaptialCurrCd", getRegCaptialCurrCd())
            .append("bussRange", getBussRange())
            .append("bussAddr", getBussAddr())
            .append("signIn", getSignIn())
            .append("enotesIn", getEnotesIn())
            .append("settleInsTp", getSettleInsTp())
            .append("acctInsIdCd", getAcctInsIdCd())
            .append("mchntSettleMd", getMchntSettleMd())
            .append("packMchntCd", getPackMchntCd())
            .append("cycleSettleTp", getCycleSettleTp())
            .append("prepayReturnTp", getPrepayReturnTp())
            .append("mchntSettleIn", getMchntSettleIn())
            .append("bankNm1", getBankNm1())
            .append("bankSettleNo1", getBankSettleNo1())
            .append("mchntSettleBankCd", getMchntSettleBankCd())
            .append("acctCurrCd1", getAcctCurrCd1())
            .append("acctNm1", getAcctNm1())
            .append("acctNo1", getAcctNo1())
            .append("specSettleIn", getSpecSettleIn())
            .append("issInsIdCd", getIssInsIdCd())
            .append("specDiscTp", getSpecDiscTp())
            .append("specDiscLvl", getSpecDiscLvl())
            .append("allotAlgo", getAllotAlgo())
            .append("mchntDiscDetIndex", getMchntDiscDetIndex())
            .append("mcmgmAllotItemIndex", getMcmgmAllotItemIndex())
            .append("allotRole", getAllotRole())
            .append("allotInsIdCd1", getAllotInsIdCd1())
            .append("allotInsIdCd2", getAllotInsIdCd2())
            .append("allotInsIdCd3", getAllotInsIdCd3())
            .append("allotInsIdCd4", getAllotInsIdCd4())
            .append("allotInsIdCd5", getAllotInsIdCd5())
            .append("mchntClass", getMchntClass())
            .append("rptGenInBmp", getRptGenInBmp())
            .append("insResv7", getInsResv7())
            .append("bankSettleSeq", getBankSettleSeq())
            .append("indaySettleIn", getIndaySettleIn())
            .append("addnInf", getAddnInf())
            .append("iferrAcqPayFlag", getIferrAcqPayFlag())
            .append("mchntPrioIn", getMchntPrioIn())
            .append("indayCycleMsgNo", getIndayCycleMsgNo())
            .append("indayCycleBussTp", getIndayCycleBussTp())
            .append("enddayCycleMsgNo", getEnddayCycleMsgNo())
            .append("enddayCycleBussTp", getEnddayCycleBussTp())
            .append("anyCycleDbitMsgNo", getAnyCycleDbitMsgNo())
            .append("anyCycleDbitBussTp", getAnyCycleDbitBussTp())
            .append("mchntAttrBmp", getMchntAttrBmp())
            .append("feeSettleInsTp", getFeeSettleInsTp())
            .append("mchntFeeBankNm", getMchntFeeBankNm())
            .append("mchntFeeAcctBankCd", getMchntFeeAcctBankCd())
            .append("mchntFeeAcct", getMchntFeeAcct())
            .append("mchntFeeAcctNm", getMchntFeeAcctNm())
            .append("mchntFeeSettleBankCd", getMchntFeeSettleBankCd())
            .append("mchntFeeAcctInsIdCd", getMchntFeeAcctInsIdCd())
            .append("spInsIdCd", getSpInsIdCd())
            .append("industryInsIdCd", getIndustryInsIdCd())
            .append("mchntBussProcTp", getMchntBussProcTp())
            .append("trustAppTp", getTrustAppTp())
            .append("lateFeeCalcIn", getLateFeeCalcIn())
            .append("lateFeeCalcMd", getLateFeeCalcMd())
            .append("lateFeeUsrTp", getLateFeeUsrTp())
            .append("maxBillPrintNum", getMaxBillPrintNum())
            .append("fixAt", getFixAt())
            .append("lateFeeLowerLimit", getLateFeeLowerLimit())
            .append("lateFeeHigherLimit", getLateFeeHigherLimit())
            .append("lateFeeBaseRt", getLateFeeBaseRt())
            .append("lateFeeOverYearRt", getLateFeeOverYearRt())
            .append("mchntSettleAttr", getMchntSettleAttr())
            .append("entrustRelationIn", getEntrustRelationIn())
            .append("addActEntrustIn", getAddActEntrustIn())
            .append("taxTp", getTaxTp())
            .append("settleTreBankNo", getSettleTreBankNo())
            .append("pwdEncTp", getPwdEncTp())
            .append("pwdEncIndex", getPwdEncIndex())
            .append("chnlMchntCd", getChnlMchntCd())
            .append("specChargeIn", getSpecChargeIn())
            .append("allotIn", getAllotIn())
            .append("svcNetUrl", getSvcNetUrl())
            .append("mchntWebSiteNm", getMchntWebSiteNm())
            .append("bussTp", getBussTp())
            .append("prodFunc", getProdFunc())
            .append("ebussTp", getEbussTp())
            .append("prodFuncDesc", getProdFuncDesc())
            .append("singleAtLimit", getSingleAtLimit())
            .append("singleAtLimitDesc", getSingleAtLimitDesc())
            .append("singleCardDayAtLimit", getSingleCardDayAtLimit())
            .append("singleCardDayAtLimitDesc", getSingleCardDayAtLimitDesc())
            .append("bussCont1", getBussCont1())
            .append("bussCont1Tel", getBussCont1Tel())
            .append("bussCont1Cell", getBussCont1Cell())
            .append("bussCont1Email", getBussCont1Email())
            .append("bussCont2", getBussCont2())
            .append("bussCont2Tel", getBussCont2Tel())
            .append("bussCont2Cell", getBussCont2Cell())
            .append("bussCont2Email", getBussCont2Email())
            .append("cupBranchResv10", getCupBranchResv10())
            .append("cupBranchResv9", getCupBranchResv9())
            .append("cycleMchntIn", getCycleMchntIn())
            .append("mchntTransTp", getMchntTransTp())
            .append("frnAcqInsIdCd", getFrnAcqInsIdCd())
            .append("insResv8", getInsResv8())
            .append("svcFeeIn", getSvcFeeIn())
            .append("instlIn", getInstlIn())
            .append("callCenterPhone", getCallCenterPhone())
            .append("mchntLvl", getMchntLvl())
            .append("posNum", getPosNum())
            .append("casherNum", getCasherNum())
            .append("mchntOpenDt", getMchntOpenDt())
            .append("constrQuitDt", getConstrQuitDt())
            .append("transChnl", getTransChnl())
            .append("constrQuitRsnCd", getConstrQuitRsnCd())
            .append("remark", getRemark())
            .append("cupBranchSpecFld", getCupBranchSpecFld())
            .append("insResv1", getInsResv1())
            .append("insResv2", getInsResv2())
            .append("insResv3", getInsResv3())
            .append("insResv4", getInsResv4())
            .append("insResv5", getInsResv5())
            .append("insResv6", getInsResv6())
            .append("insResv9", getInsResv9())
            .append("insResv10", getInsResv10())
            .append("cupBranchResv1", getCupBranchResv1())
            .append("cupBranchResv2", getCupBranchResv2())
            .append("cupBranchResv3", getCupBranchResv3())
            .append("cupBranchResv4", getCupBranchResv4())
            .append("cupBranchResv5", getCupBranchResv5())
            .append("cupBranchResv6", getCupBranchResv6())
            .append("cupBranchResv7", getCupBranchResv7())
            .append("cupBranchResv8", getCupBranchResv8())
            .append("cupHdqrsResv1", getCupHdqrsResv1())
            .append("cupHdqrsResv2", getCupHdqrsResv2())
            .append("cupHdqrsResv3", getCupHdqrsResv3())
            .append("cupHdqrsResv4", getCupHdqrsResv4())
            .append("mchntNegActIn", getMchntNegActIn())
            .append("riskArtifIn", getRiskArtifIn())
            .append("riskMchntIn", getRiskMchntIn())
            .append("susMchntIn", getSusMchntIn())
            .append("hdqrsBranchIn", getHdqrsBranchIn())
            .append("hdqrsMchntCd", getHdqrsMchntCd())
            .append("recnclTp", getRecnclTp())
            .append("netMchntSvcTp", getNetMchntSvcTp())
            .append("principalNm", getPrincipalNm())
            .append("submchntIn", getSubmchntIn())
            .append("svcInsNm", getSvcInsNm())
            .append("cooking", getCooking())
            .append("mchntIcp", getMchntIcp())
            .append("trafficLine", getTrafficLine())
            .append("directAcqSettleIn", getDirectAcqSettleIn())
            .append("nmAddr", getNmAddr())
            .append("allotCd", getAllotCd())
            .append("mccApplRule", getMccApplRule())
            .append("masterPwd", getMasterPwd())
            .append("mccApplRsnCd", getMccApplRsnCd())
            .append("specFeeStdDesc", getSpecFeeStdDesc())
            .append("nmAddr1", getNmAddr1())
            .toString();
    }
}
