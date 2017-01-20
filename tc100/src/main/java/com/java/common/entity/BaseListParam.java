package com.java.common.entity;

import java.util.List;

public class BaseListParam<T> {

	List<T> list;

	List<T> list2;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public List<T> getList2() {
		return list2;
	}

	public void setList2(List<T> list2) {
		this.list2 = list2;
	}
}
