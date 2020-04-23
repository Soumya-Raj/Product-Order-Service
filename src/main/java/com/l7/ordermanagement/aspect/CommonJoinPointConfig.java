package com.l7.ordermanagement.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Defines common pointcut for LoggingAspect
 */
public class CommonJoinPointConfig {
    @Pointcut("@annotation(com.l7.ordermanagement.aspect.LoggerAspect)")
    public void loggerExecution(){
    }
}
