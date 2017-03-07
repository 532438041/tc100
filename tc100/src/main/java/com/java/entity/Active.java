package com.java.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.java.servlet.JsonDateSerializer;

public class Active {
	private String id;

	private String actName;
	
	private String shopName;

	private String userId;

	private String cardId;

	private String cateId;

	private String actType;

	private String mainPic;

	private String summary;

	private String isInit;

	private String detailSummary;

	private String detailContent;

	private String state;

	private Date startTime;

	private Date endTime;

	private Integer viewCount;

	private BigDecimal amount;

	private String region;

	private String addName;
	
	private String rowNo;

	private String createBy;

	private Date createTime;

	private String updateBy;

	private Date updateTime;
	
	private String orderBy;
	
	private String userName;
	
	private String payCodeId;

	public String getId() {
		return id == null ? "" : id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActName() {
		return actName == null ? "" : actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
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

	public String getCateId() {
		return cateId == null ? "" : cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public String getActType() {
		return actType == null ? "" : actType;
	}

	public void setActType(String actType) {
		this.actType = actType;
	}

	public String getMainPic() {
		return mainPic == null ? "" : mainPic;
	}

	public void setMainPic(String mainPic) {
		this.mainPic = mainPic;
	}

	public String getSummary() {
		return summary == null ? "" : summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDetailSummary() {
		return detailSummary == null ? "" : detailSummary;
	}

	public void setDetailSummary(String detailSummary) {
		this.detailSummary = detailSummary;
	}

	public String getDetailContent() {
		return detailContent == null ? "" : detailContent;
	}

	public void setDetailContent(String detailContent) {
		this.detailContent = detailContent;
	}

	public String getState() {
		return state == null ? "" : state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCreateBy() {
		return createBy == null ? "" : createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
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

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getIsInit() {
		return isInit == null ? "" : isInit;
	}

	public void setIsInit(String isInit) {
		this.isInit = isInit;
	}

	public String getAddName() {
		return addName;
	}

	public void setAddName(String addName) {
		this.addName = addName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getOrderBy() {
		return orderBy == null ? "" : orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPayCodeId() {
		return payCodeId;
	}

	public void setPayCodeId(String payCodeId) {
		this.payCodeId = payCodeId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getRowNo() {
		return rowNo;
	}

	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
	}
}