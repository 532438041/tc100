package com.java.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.PathMatchingFilter;

/**
 * shiro用户过滤器
 */
public class ShiroFilter extends PathMatchingFilter {
    
    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
    		return true;
    }
}
