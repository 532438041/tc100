package com.java.base;

public interface BaseService<T> {
	/**
	 * 按主键删除实体
	 * 
	 * @param key 实体主键
	 * @return
	 */
	int deleteByPrimaryKey(String key);

	/**
	 * 插入实体
	 * 
	 * @param t 实体
	 * @return
	 */
	int insert(T t);

	/**
	 * 选择性插入实体，若有为空的字段，则不插入该字段，数据库赋值为数据库默认值
	 * 
	 * @param t 实体
	 * @return
	 */
	int insertSelective(T t);

	/**
	 * 通过主键实体查询实体
	 * 
	 * @param key 实体主键
	 * @return
	 */
	T selectByPrimaryKey(String key);

	/**
	 * 选择性更新实体列，若实体的对应字段为空，则忽略该字段
	 * 
	 * @param t 实体
	 * @return
	 */
	int updateByPrimaryKeySelective(T t);

	/**
	 * 更新整个实体的所有字段
	 * 
	 * @param t 实体
	 * @return
	 */
	int updateByPrimaryKey(T t);

}
