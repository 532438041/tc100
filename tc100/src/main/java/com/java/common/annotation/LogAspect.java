package com.java.common.annotation;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.java.entity.Log;
import com.java.service.LogService;
import com.java.utils.ToolsUtil;

/**
 * 日志切点类
 */
@Aspect
@Component
public class LogAspect {

	@Resource
	private LogService logService;

	// Controller层切点
	@Pointcut("@annotation(com.java.common.annotation.SysLog)")
	public void controllerAspect() {

	}

	/**
	 * 后置通知 用于拦截Controller层记录用户的操作
	 * 
	 * @param @param joinpoint
	 * @return void
	 */
	@After("controllerAspect()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("--------SysLog后置操作日志开始--------");
		handleLog("00", joinPoint, null);
		System.out.println("--------SysLog后置操作日志结束--------");
	}

	@AfterThrowing(value = "controllerAspect()", throwing = "ex")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable ex) {
		System.out.println("--------SysLog异常操作日志开始--------");
		handleLog("01", joinPoint, ex);
		System.out.println("--------SysLog异常操作日志结束--------");
	}

	private void handleLog(String logType, JoinPoint joinPoint, Throwable ex) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String userId = ToolsUtil.getCookie(request, "userId");
		String reqIp = request.getRemoteAddr();
		try {
			String targetName = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName();
			Object[] arguments = joinPoint.getArgs();
			Class<?> targetClass = Class.forName(targetName);
			Method[] methods = targetClass.getMethods();
			String operationType = "";
			String operationName = "";
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					@SuppressWarnings("rawtypes")
					Class[] clazzs = method.getParameterTypes();
					if (clazzs.length == arguments.length) {
						operationType = method.getAnnotation(SysLog.class).operationType();
						operationName = method.getAnnotation(SysLog.class).operationName();
						break;
					}
				}
			}
			String logMethod = joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()" + "." + operationType;
			String params = "";
			if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
				for (int i = 0; i < joinPoint.getArgs().length; i++) {
					// 如果参数为HttpServletResponse 不加入params
					if (("StatHttpServletResponseWrapper").equals(joinPoint.getArgs()[i].getClass().getSimpleName())) {
						continue;
					}
					params += JSON.toJSONString(joinPoint.getArgs()[i]) + ";";
				}
			}

			Log log = new Log();
			log.setId(ToolsUtil.getUUID());
			log.setCreateBy(userId);
			log.setCreateTime(new Date());
			log.setDetails(operationName);
			log.setLogType(logType);
			log.setMethod(logMethod);
			log.setParams(params);
			log.setReqIp(reqIp);
			if (ToolsUtil.isNotNull(ex)) {
				log.setExCode(ex.getClass().getName());
				log.setExDetail(ex.getMessage());
			}

			// 保存日志
			System.out.println("--------保存SysLog--------");
			logService.insert(log);

		} catch (Exception e) {
			System.out.println("--------保存SysLog异常：" + e.getMessage() + "--------");
		}
	}
}
