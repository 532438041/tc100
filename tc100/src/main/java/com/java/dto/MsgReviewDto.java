package com.java.dto;

import com.java.entity.MessageReview;

public class MsgReviewDto extends MessageReview {

	private String picUrl;

	private String cardName;

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

}
