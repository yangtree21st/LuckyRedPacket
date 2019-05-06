package org.zipcode.luckyMoney.Aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

//
//@Aspect
//@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * org.zipcode.luckyMoney.Controller.LuckymoneyController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
//        url
        logger.info("url={}",request.getRequestURI());
//        method
        logger.info("method={}",request.getMethod());
//        ip
        logger.info("ip={}",request.getRemoteAddr());
//        class methods
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+ "." + joinPoint.getSignature().getName());
//        parameter
         logger.info("args ={}", joinPoint.getArgs());

    }


    @After("log()")
    public void doAfter(){
    //    logger.info("Please log out your account");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterreturn (Object object){
        logger.info("response={}",object.toString());
    }
}
