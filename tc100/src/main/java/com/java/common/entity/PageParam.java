package com.java.common.entity;

import com.java.utils.ToolsUtil;

public class PageParam<T> {

	private Integer pageNum;

	private Integer pageSize;

	private T reqParam;

	public T getReqParam() {
		return reqParam;
	}

	public void setReqParam(T reqParam) {
		this.reqParam = reqParam;
	}

	public Integer getPageNum() {
		if (ToolsUtil.isNull(pageNum) || pageNum <= 0) {
			return 1;
		}
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		if (ToolsUtil.isNull(pageSize) || pageSize <= 0) {
			return 10;
		}
		if (pageSize > 100) {
			return 100;
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
