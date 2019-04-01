package com.yh.dao.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 交易通知表 up_tran_notify
 * 
 * @author ruoyi
 * @date 2019-02-25
 */
public class TranNotify extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 通知编号 */
	private String notifyId;
	/** 通知内容 */
	private String notifyContent;
	/** 交易流水号 */
	private String tranNo;
	/** 创建时间 */
	private Date createTime;
	/** 商户编号 */
	private String merchId;
	/** 终端号 */
	private String termId;
	/** 音箱编号 */
	private String vboxId;
	/** 声音名称 */
	private String voiceName;
	/** 语音内容 */
	private String voiceText;
	/** 通知语音 */
	private byte[] notifyVoice;
	/** 请求时间 */
	private Date voiceReqTime;
	/** 响应时间 */
	private Date voiceRespTime;
	/** 发送时间 */
	private Date sendTime;
	/** 是否发送 0-未发送；1-已发送 */
	private String sendFlag;

	public void setNotifyId(String notifyId) 
	{
		this.notifyId = notifyId;
	}

	public String getNotifyId() 
	{
		return notifyId;
	}
	public void setNotifyContent(String notifyContent) 
	{
		this.notifyContent = notifyContent;
	}

	public String getNotifyContent() 
	{
		return notifyContent;
	}
	public void setTranNo(String tranNo) 
	{
		this.tranNo = tranNo;
	}

	public String getTranNo() 
	{
		return tranNo;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setMerchId(String merchId) 
	{
		this.merchId = merchId;
	}

	public String getMerchId() 
	{
		return merchId;
	}
	public void setTermId(String termId) 
	{
		this.termId = termId;
	}

	public String getTermId() 
	{
		return termId;
	}
	public void setVboxId(String vboxId) 
	{
		this.vboxId = vboxId;
	}

	public String getVboxId() 
	{
		return vboxId;
	}
	public void setVoiceName(String voiceName) 
	{
		this.voiceName = voiceName;
	}

	public String getVoiceName() 
	{
		return voiceName;
	}
	public void setVoiceText(String voiceText) 
	{
		this.voiceText = voiceText;
	}

	public String getVoiceText() 
	{
		return voiceText;
	}
	public void setNotifyVoice(byte[] notifyVoice) 
	{
		this.notifyVoice = notifyVoice;
	}

	public byte[] getNotifyVoice() 
	{
		return notifyVoice;
	}
	public void setVoiceReqTime(Date voiceReqTime) 
	{
		this.voiceReqTime = voiceReqTime;
	}

	public Date getVoiceReqTime() 
	{
		return voiceReqTime;
	}
	public void setVoiceRespTime(Date voiceRespTime) 
	{
		this.voiceRespTime = voiceRespTime;
	}

	public Date getVoiceRespTime() 
	{
		return voiceRespTime;
	}
	public void setSendTime(Date sendTime) 
	{
		this.sendTime = sendTime;
	}

	public Date getSendTime() 
	{
		return sendTime;
	}
	public void setSendFlag(String sendFlag) 
	{
		this.sendFlag = sendFlag;
	}

	public String getSendFlag() 
	{
		return sendFlag;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("notifyId", getNotifyId())
            .append("notifyContent", getNotifyContent())
            .append("tranNo", getTranNo())
            .append("createTime", getCreateTime())
            .append("merchId", getMerchId())
            .append("termId", getTermId())
            .append("vboxId", getVboxId())
            .append("voiceName", getVoiceName())
            .append("voiceText", getVoiceText())
            .append("notifyVoice", getNotifyVoice())
            .append("voiceReqTime", getVoiceReqTime())
            .append("voiceRespTime", getVoiceRespTime())
            .append("sendTime", getSendTime())
            .append("sendFlag", getSendFlag())
            .toString();
    }
}
