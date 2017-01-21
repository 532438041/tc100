package com.java.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ActiveItem {
    private String id;

    private String itemPic;

    private BigDecimal listPrice;

    private String listUnit;

    private BigDecimal spePrice;

    private String speUnit;

    private Date startTime;

    private Date endTime;

    private String remark;

    private String actId;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemPic() {
        return itemPic;
    }

    public void setItemPic(String itemPic) {
        this.itemPic = itemPic;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public String getListUnit() {
        return listUnit;
    }

    public void setListUnit(String listUnit) {
        this.listUnit = listUnit;
    }

    public BigDecimal getSpePrice() {
        return spePrice;
    }

    public void setSpePrice(BigDecimal spePrice) {
        this.spePrice = spePrice;
    }

    public String getSpeUnit() {
        return speUnit;
    }

    public void setSpeUnit(String speUnit) {
        this.speUnit = speUnit;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}