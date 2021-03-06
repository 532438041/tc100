package com.java.entity;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.java.servlet.JsonDateSerializer;

public class MessageReview {
    private String id;

    private String userId;
    
    private String cardId;

    private String msgId;

    private String remark;

    private String msgPic;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
		return userId == null ? "" : userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCardId() {
        return cardId == null ? "" : cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getMsgId() {
        return msgId == null ? "" : msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getRemark() {
        return remark == null ? "" : remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMsgPic() {
        return msgPic == null ? "" : msgPic;
    }

    public void setMsgPic(String msgPic) {
        this.msgPic = msgPic;
    }

    public String getCreateBy() {
        return createBy == null ? "" : createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy == null ? "" : updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}