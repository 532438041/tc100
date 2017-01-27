package com.java.common.enums;

public enum LogTypeEnum {

	LIULAN("0", "浏览"), GUANZHU("1", "关注"), FENXIANG("2", "分享"), CHONGFU("3", "重复"), SHUITIE("4", "水贴"), TUISONG("5", "推送"), TUIGUANG("6", "推广");

	private String type;
	private String msg;

	LogTypeEnum(String type, String msg) {
		this.type = type;
		this.msg = msg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static String getMsgByType(String type) {
		for (LogTypeEnum logTypeEnum : LogTypeEnum.values()) {
			if (type == logTypeEnum.getType()) {
				return logTypeEnum.getMsg();
			}
		}
		return null;
	}
}
