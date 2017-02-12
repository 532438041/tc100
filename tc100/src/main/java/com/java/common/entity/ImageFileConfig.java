package com.java.common.entity;

/**
 * File 基础配置类.
 *
 * @author luolin
 */
public class ImageFileConfig {

	/**
	 * 图片格式限制
	 */
	public static final String allowSuffix = "jpg,png,gif,jpeg,bmp";

	/**
	 * 图片上传本地路径
	 */
	public static final String uploadFilePath = "E:/tc100/img"; //"C:/tc100/img";

	/**
	 * 可上传图片最大值
	 */
	public static final long maxUploadSize = 4194304;

	/**
	 * 图片请求路径
	 */
	public static final String imagePrefix = "/tcimg";

}
