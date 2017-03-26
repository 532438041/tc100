package com.java.dto;

import com.java.entity.Message;

public class MsgDto extends Message {

	private String picUrl;

	private String cardName;
	
	private String timeStr;

	// 同城搜回复个数
	private String reviewCount;

	public String getPicUrl() {
		return picUrl == null ? "" : picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getCardName() {
		return cardName == null ? "" : cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(String reviewCount) {
		this.reviewCount = reviewCount;
	}

	public String getTimeStr() {
		return timeStr;
	}

	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}
	

}
