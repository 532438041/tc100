package com.java.common.exception;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.common.entity.BaseResult;
import com.java.common.enums.BaseResultEnum;

@ControllerAdvice
@ResponseBody
public class RestExceptionHandler {

	/**
	 * 400 - Http Param Error
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public BaseResult handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		return new BaseResult().failed(BaseResultEnum.HTTP_PARAM_ERROR.getStatus(), BaseResultEnum.HTTP_PARAM_ERROR.getMsg());
	}

	/**
	 * 405 - Method Not Allowed
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public BaseResult handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		return new BaseResult().failed(BaseResultEnum.Method_Not_Allowed.getStatus(), BaseResultEnum.Method_Not_Allowed.getMsg());
	}

	/**
	 * 415 - Unsupported Media Type
	 */
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public BaseResult handleHttpMediaTypeNotSupportedException(Exception e) {
		return new BaseResult().failed(BaseResultEnum.Unsupported_Media_Type.getStatus(), BaseResultEnum.Unsupported_Media_Type.getMsg());
	}

	/**
	 * 500 - Internal Server Error
	 */
	@ExceptionHandler(Exception.class)
	public BaseResult handleException(Exception e) {
		return new BaseResult().failed(BaseResultEnum.HTTP_EXCEPTION.getStatus(), BaseResultEnum.HTTP_EXCEPTION.getMsg());
	}
}