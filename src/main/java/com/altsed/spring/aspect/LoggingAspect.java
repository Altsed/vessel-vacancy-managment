package com.altsed.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    // set up logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //setup pointcut declaration
    @Pointcut("execution(* com.altsed.spring.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.altsed.spring.controller.*.*(..))")

    private void forDaoPackage(){}
    @Pointcut("execution(* com.altsed.spring.controller.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
        //display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("========> in @Before: calling method: " + theMethod);

        //display the args to the method
        Object[] args = theJoinPoint.getArgs();
        for (Object tempObject : args){
            myLogger.info("=======> argument: " + tempObject);
        }

    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){
        //display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("========> in @AfterReturning: calling method: " + theMethod);

        //display data returned
        myLogger.info("=======>> result: " + theResult);

    }




}
