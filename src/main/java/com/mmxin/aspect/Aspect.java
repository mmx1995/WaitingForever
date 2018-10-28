package com.mmxin.aspect;


import com.alibaba.fastjson.JSON;
import com.mmxin.mapper.RequestLogMapper;
import com.mmxin.pojo.RequestLog;
import com.mmxin.service.RequestLogService;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 切面
 * */
@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RequestLogService service ;

    @Pointcut("execution(* com.mmxin.controller.*.*(..))")
    public void log(){
        System.out.println("log()");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={},method={},Ip={},class_method={},args={}", request.getRequestURI(),
                request.getMethod(),this.getRealIp(request),
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),JSON.toJSONString(joinPoint.getArgs()));
    }

    @After("log()")
    public void doAfter(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
    }

    @Around("log()")
    public void aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //打印进入方法的时间
        Date begin = new Date();
        Object obejct = proceedingJoinPoint.proceed();
        //打印方法执行完毕的时间
        Date end = new Date();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        RequestLog log = new RequestLog();
        log.setUrl(request.getRequestURI());
        log.setMethod(request.getMethod());
        log.setClassmethod(proceedingJoinPoint.getSignature().getDeclaringTypeName() +"."+proceedingJoinPoint.getSignature().getName());
        log.setRequest(JSON.toJSONString(proceedingJoinPoint.getArgs()));
        log.setResponse(JSON.toJSONString(obejct));
        log.setRequesttime(begin);
        log.setReponsetime(end);
        log.setIp(this.getRealIp(request));
        log.setUsetime(end.getTime() - begin.getTime());
        this.service.save(log);
    }

    /**
     * 获取真实IP
     * */
    public String getRealIp(HttpServletRequest request){
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if(index != -1){
                return XFor.substring(0,index);
            }else{
                return XFor;
            }
        }
        XFor = Xip;
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            return XFor;
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return  XFor;
    }
}
