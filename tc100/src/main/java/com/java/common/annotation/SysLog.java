package com.java.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	/**
	 * 要执行的操作类型 如：add del up
	 * 
	 * @param @return
	 * @return String
	 */
	public String operationType() default "";

	/**
	 * 要执行的具体操作 如：添加用户
	 * 
	 * @param @return
	 * @return String
	 */
	public String operationName() default "";

}
