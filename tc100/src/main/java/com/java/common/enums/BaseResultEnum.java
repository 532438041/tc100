package com.java.common.enums;

public enum BaseResultEnum {

	HTTP_PARAM_ERROR(400, "param error"), HTTP_NOT_FOUND(404, "not found"), Method_Not_Allowed(405, "request method not supported"), Unsupported_Media_Type(415, "content type not supported"), HTTP_OK(200, "success"), HTTP_EXCEPTION(500, "failed");

	private int status;
	private String msg;

	BaseResultEnum(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

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

	public static String getMsgByStatus(int status) {
		for (BaseResultEnum baseResultEnum : BaseResultEnum.values()) {
			if (status == baseResultEnum.getStatus()) {
				return baseResultEnum.getMsg();
			}
		}
		return null;
	}
}
