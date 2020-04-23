package com.l7.ordermanagement.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Enumeration;

@Aspect
@Configuration
@Component
public class LoggingAspect {
    @Autowired(required = false)
    private HttpServletRequest request;

    @Autowired(required = false)
    private HttpServletResponse response;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Advice to be executed before pointcut method execution
     * @param joinPoint
     */
    @Before("com.l7.ordermanagement.aspect.CommonJoinPointConfig.loggerExecution()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Entering in method : " + joinPoint.getSignature().getName());
        log.info("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
        log.info("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
        log.info("Target class : " + joinPoint.getTarget().getClass().getName());
        log.info("Request URL : " + String.valueOf(request.getRequestURL()));
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            log.info("Header Name: " + headerName + " Header Value : " + headerValue);
        }
        log.info("Request Path info :" + request.getServletPath());
    }

    /**
     * Advice to be executed after successful return of pointcut methods
     * @param joinPoint
     * @param result
     */
    @AfterReturning("com.l7.ordermanagement.aspect.CommonJoinPointConfig.loggerExecution() && args(result)")
    public void logAfter(JoinPoint joinPoint, Object result) {
        log.info("Method Return value : " + result);
    }

    /**
     * Advice to be executed if pointcut methods throw exception
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing("com.l7.ordermanagement.aspect.CommonJoinPointConfig.loggerExecution() && args(exception)")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        log.error("An exception has been thrown in " + joinPoint.getSignature().getName() + " ()");
        log.error("Cause : " + exception.getMessage());
    }
}
