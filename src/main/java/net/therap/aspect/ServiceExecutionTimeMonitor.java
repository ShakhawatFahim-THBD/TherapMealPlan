package net.therap.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * author: shakhawat.hossain
 * Date: 6/5/14
 * Time: 12:05 PM
 *
 */
@Aspect
public class ServiceExecutionTimeMonitor {

    private static final Logger LOGGER  = LoggerFactory.getLogger(ServiceExecutionTimeMonitor.class);

    private long executionStartTime;
    private long executionEndTime;

    @Before ("execution(* net.therap.service..*.*(..))")
    public void setServiceMethodInvocationTime(){
        this.executionStartTime = System.currentTimeMillis();
    }

    @After ("execution(* net.therap.service..*.*(..))")
    public void setServiceMethodEndTime(){
        this.executionEndTime = System.currentTimeMillis();
    }

    @After ("execution(* net.therap.service..*.*(..))")
    public void logServiceMethodExecutionTime(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        LOGGER.info("Execution time : "+methodName+"() : "+(executionEndTime - executionStartTime)+" ms");
    }

}
