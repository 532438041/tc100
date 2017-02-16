package com.java.dto;

import com.java.entity.User;

public class UserDto extends User {

	private int favCount;

	public int getFavCount() {
		return favCount;
	}

	public void setFavCount(int favCount) {
		this.favCount = favCount;
	}

}
