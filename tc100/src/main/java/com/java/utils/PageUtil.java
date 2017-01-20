package com.java.utils;

import java.util.List;

import com.github.pagehelper.Page;
import com.java.common.entity.PageResult;

/**
 * 分页工具类
 */
public class PageUtil {

	/**
	 * 将结果集转换成Page类
	 * 
	 * @param @param datas
	 * @param @return
	 * @return PagedResult<T>
	 */
	public static <T> PageResult<T> toPagedResult(List<T> datas) {
		PageResult<T> result = new PageResult<T>();
		if (datas instanceof Page) {
			Page<T> page = (Page<T>) datas;
			result.setPageNum(page.getPageNum());
			result.setPageSize(page.getPageSize());
			result.setDataList(page.getResult());
			result.setTotal(page.getTotal());
			result.setPages(page.getPages());
		} else {
			result.setPageNum(1);
			result.setPageSize(datas.size());
			result.setDataList(datas);
			result.setTotal(datas.size());
		}

		return result;
	}

}
