package com.yh.dao.model;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 云闪付交易表 up_tran_list
 * 
 * @author ruoyi
 * @date 2019-02-25
 */
public class TranList extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private String id;
	/** 服务商编号 */
	private String serProvId;
	/** 商户编号 */
	private String merchId;
	/** 门店编号 */
	private String storeId;
	/** 终端号 */
	private String termId;
	/** 终端信息 */
	private String termInfo;
	/** 订单类型 */
	private String orderType;
	/** 订单号 */
	private String orderNo;
	/** 交易金额 */
	private BigDecimal tranAmt;
	/** 货币代码 */
	private String currencyCd;
	/** 交易流水号 */
	private String tranNo;
	/** 支付金额 */
	private BigDecimal payAmt;
	/** 结算金额 */
	private BigDecimal settleAmt;
	/** 支付时间 */
	private String payTime;
	/** 优惠信息 */
	private String couponInfo;
	/** 单品优惠信息 */
	private String dctGoodsInfo;
	/** 服务商自定义域 */
	private String rpReserved;
	/** 更新时间 */
	private Date updatedTime;
	/** 更新人 */
	private String updatedBy;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setSerProvId(String serProvId) 
	{
		this.serProvId = serProvId;
	}

	public String getSerProvId() 
	{
		return serProvId;
	}
	public void setMerchId(String merchId) 
	{
		this.merchId = merchId;
	}

	public String getMerchId() 
	{
		return merchId;
	}
	public void setStoreId(String storeId) 
	{
		this.storeId = storeId;
	}

	public String getStoreId() 
	{
		return storeId;
	}
	public void setTermId(String termId) 
	{
		this.termId = termId;
	}

	public String getTermId() 
	{
		return termId;
	}
	public void setTermInfo(String termInfo) 
	{
		this.termInfo = termInfo;
	}

	public String getTermInfo() 
	{
		return termInfo;
	}
	public void setOrderType(String orderType) 
	{
		this.orderType = orderType;
	}

	public String getOrderType() 
	{
		return orderType;
	}
	public void setOrderNo(String orderNo) 
	{
		this.orderNo = orderNo;
	}

	public String getOrderNo() 
	{
		return orderNo;
	}
	public void setTranAmt(BigDecimal tranAmt) 
	{
		this.tranAmt = tranAmt;
	}

	public BigDecimal getTranAmt() 
	{
		return tranAmt;
	}
	public void setCurrencyCd(String currencyCd) 
	{
		this.currencyCd = currencyCd;
	}

	public String getCurrencyCd() 
	{
		return currencyCd;
	}
	public void setTranNo(String tranNo) 
	{
		this.tranNo = tranNo;
	}

	public String getTranNo() 
	{
		return tranNo;
	}
	public void setPayAmt(BigDecimal payAmt) 
	{
		this.payAmt = payAmt;
	}

	public BigDecimal getPayAmt() 
	{
		return payAmt;
	}
	public void setSettleAmt(BigDecimal settleAmt) 
	{
		this.settleAmt = settleAmt;
	}

	public BigDecimal getSettleAmt() 
	{
		return settleAmt;
	}
	public void setPayTime(String payTime) 
	{
		this.payTime = payTime;
	}

	public String getPayTime() 
	{
		return payTime;
	}
	public void setCouponInfo(String couponInfo) 
	{
		this.couponInfo = couponInfo;
	}

	public String getCouponInfo() 
	{
		return couponInfo;
	}
	public void setDctGoodsInfo(String dctGoodsInfo) 
	{
		this.dctGoodsInfo = dctGoodsInfo;
	}

	public String getDctGoodsInfo() 
	{
		return dctGoodsInfo;
	}
	public void setRpReserved(String rpReserved) 
	{
		this.rpReserved = rpReserved;
	}

	public String getRpReserved() 
	{
		return rpReserved;
	}
	public void setUpdatedTime(Date updatedTime) 
	{
		this.updatedTime = updatedTime;
	}

	public Date getUpdatedTime() 
	{
		return updatedTime;
	}
	public void setUpdatedBy(String updatedBy) 
	{
		this.updatedBy = updatedBy;
	}

	public String getUpdatedBy() 
	{
		return updatedBy;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("serProvId", getSerProvId())
            .append("merchId", getMerchId())
            .append("storeId", getStoreId())
            .append("termId", getTermId())
            .append("termInfo", getTermInfo())
            .append("orderType", getOrderType())
            .append("orderNo", getOrderNo())
            .append("tranAmt", getTranAmt())
            .append("currencyCd", getCurrencyCd())
            .append("tranNo", getTranNo())
            .append("payAmt", getPayAmt())
            .append("settleAmt", getSettleAmt())
            .append("payTime", getPayTime())
            .append("couponInfo", getCouponInfo())
            .append("dctGoodsInfo", getDctGoodsInfo())
            .append("rpReserved", getRpReserved())
            .append("updatedTime", getUpdatedTime())
            .append("updatedBy", getUpdatedBy())
            .toString();
    }
}
