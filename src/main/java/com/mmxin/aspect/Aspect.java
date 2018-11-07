package com.mmxin.aspect;


import com.alibaba.fastjson.JSON;
import com.mmxin.mapper.RequestLogMapper;
import com.mmxin.pojo.Menu;
import com.mmxin.pojo.RequestLog;
import com.mmxin.service.MenuService;
import com.mmxin.service.RequestLogService;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 切面
 * */
@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RequestLogService service ;

    @Autowired
    MenuService menuService ;

    RequestLog requestLog ;

    Date start ;

    /**
     * 定义切点
     * */
    @Pointcut("execution(* com.mmxin.controller.*.*(..))")
    public void log(){
        System.out.println("log()");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        start = new Date();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        requestLog = new RequestLog();
        requestLog.setIp(this.getRealIp(request));
        requestLog.setClassmethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        requestLog.setIp(this.getRealIp(request));
        requestLog.setMethod(request.getMethod());
        requestLog.setRequest(JSON.toJSONString(joinPoint.getArgs()));
        requestLog.setRequesttime(start);
        requestLog.setUrl(request.getRequestURI());
        logger.info("url={},method={},Ip={},class_method={},args={}", request.getRequestURI(),
                request.getMethod(),this.getRealIp(request),
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),JSON.toJSONString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "log()", returning = "returnObject")
    public void doAfter(JoinPoint joinPoint,Object returnObject){
        requestLog.setResponse(JSON.toJSONString(returnObject));
        requestLog.setReponsetime(new Date(System.currentTimeMillis()));
        requestLog.setUsetime(System.currentTimeMillis() - start.getTime());
        System.out.println(returnObject.getClass().toString());
        if (returnObject instanceof ModelAndView){
            ModelAndView modelAndView = (ModelAndView) returnObject;
            List<Menu> menuList=menuService.getInUseMenu();
            modelAndView.getModel().put("allMenuList",menuList);
        }
        this.service.save(requestLog);
    }

    //@Around("log()")
    public void aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //打印进入方法的时间
        Date begin = new Date();
        //执行方法，获取返回值
        Object obejct = proceedingJoinPoint.proceed();
        //对返回值的类型进行判断，如果是ModelAndView 类型，开始对参数进行修改，将菜单参数进行注入
        if (obejct.getClass().equals("org.springframework.web.servlet.ModelAndView")){
            ModelAndView modelAndView = (ModelAndView) obejct;
            List<Menu> menuList=menuService.getInUseMenu();
            modelAndView.getModelMap().addAttribute("allMenuList",menuList);
        }

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
