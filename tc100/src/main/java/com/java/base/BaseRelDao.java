package com.java.base;

import java.util.Map;

public interface BaseRelDao {

	/**
	 * 删除中间表，按map删除，map的key为字段名称，vaule为字段的值，建议使用按主键删除
	 * 
	 * @param map map字段集合
	 * @return
	 */
	int deleteByKeys(Map<String, Long> map);

	/**
	 * 插入中间表，按map插入，map的key为字段名称，vaule为字段的值，建议使用按主键或者实体插入
	 * 
	 * @param map
	 * @return
	 */
	int insert(Map<String, Long> map);

	/**
	 * 删除中间表，按字段名和值删除，建议使用对应的方法删除
	 * 
	 * @param labName 字段名
	 * @param id 要删除的id
	 * @return
	 */
	int deleteByKey(String labName, Long id);
}
