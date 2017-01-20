package com.java.common.entity;

import com.java.common.enums.BaseResultEnum;

public class BaseResult {

	private int status;

	private String msg;

	private Object data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public BaseResult success() {
		this.status = BaseResultEnum.HTTP_OK.getStatus();
		this.msg = BaseResultEnum.HTTP_OK.getMsg();
		return this;
	}

	public BaseResult success(int status, String msg) {
		this.status = status;
		this.msg = msg;
		return this;
	}

	public BaseResult success(Object data) {
		this.status = BaseResultEnum.HTTP_OK.getStatus();
		this.msg = BaseResultEnum.HTTP_OK.getMsg();
		this.data = data;
		return this;
	}

	public BaseResult failed() {
		this.status = BaseResultEnum.HTTP_EXCEPTION.getStatus();
		this.msg = BaseResultEnum.HTTP_EXCEPTION.getMsg();
		return this;
	}

	public BaseResult failed(int status, String msg) {
		this.status = status;
		this.msg = msg;
		return this;
	}

}
