package com.java.dto;

import com.java.entity.User;

public class UserDto extends User {

	private int favCount;
	
	private String cardName;

	public int getFavCount() {
		return favCount;
	}

	public void setFavCount(int favCount) {
		this.favCount = favCount;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

}
