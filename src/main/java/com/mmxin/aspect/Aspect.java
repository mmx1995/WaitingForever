package com.mmxin.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
/**
 * 切面
 * */
@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.mmxin.controller.MainController.register(..))")
    public void log(){
        System.out.println("log()");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURI());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //method
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //param
        logger.info("args={}", joinPoint.getArgs());
        System.out.println("before");
    }

    @After("log()")
    public void doAfter(){
    }

    /*@AfterReturning(returning="obj",pointcut="log()")
    public void doAfterReturnig(Object obj){
        logger.info("reponse={}", obj);
    }*/
}
