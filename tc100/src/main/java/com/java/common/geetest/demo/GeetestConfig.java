package com.java.common.geetest.demo;

/**
 * GeetestWeb配置文件
 */
public class GeetestConfig {

	// 填入自己的captcha_id和private_key
	private static final String geetest_id = "eb1814dfc2a58b0bbfcdb6f5ca1b9710";
	private static final String geetest_key = "7c3fef0531a01b4b75a6c12c6d0b2168";

	public static final String getGeetest_id() {
		return geetest_id;
	}

	public static final String getGeetest_key() {
		return geetest_key;
	}

}
