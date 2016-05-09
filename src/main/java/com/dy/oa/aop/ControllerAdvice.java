package com.dy.oa.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dy.oa.common.OaConstants;
import com.dy.oa.model.ResponseMessage;

public class ControllerAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAdvice.class);
	
	public Object aroundHandler(ProceedingJoinPoint pjp) throws Throwable {
		String content = "";
		try {
			//约定Controller请求处理方法只有一个参数,参数表示请求数据
			ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = sra.getRequest();
			
			if("GET".equalsIgnoreCase(request.getMethod())){
				content = request.getQueryString();
			}else{
				content = pjp.getArgs()[0].toString();
			}
			
			LOGGER.debug("receive message:{}",content);
			return pjp.proceed();
        } catch (Exception e) {
        	LOGGER.error("",e);
        	LOGGER.error("can not process message:{}",content);
        	
        	ResponseMessage response = ResponseMessage.createDefault();
        	response.setResult(OaConstants.MESSAGE_FAIL);
        	return response;  
        }
	}
}
