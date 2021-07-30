package com.czy.study.core;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.client.ResponseContextReceiver;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class BaseControllerAspect {


    @AfterReturning(value = "execution(* com.czy.study.controller.*.*(..)))",returning = "obj")
    public void afterController(JoinPoint jp,Object obj){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String uri = request.getRequestURI();
        log.info(String.format("请求接口%s，返回参数%s",uri,JSONObject.toJSONString(obj)));
    }

    @Around("execution(* com.czy.study.controller.*.*(..)))")
    public Object around(ProceedingJoinPoint jp) {
        try {
            ResponseVo result = (ResponseVo) jp.proceed();
            return result;
        } catch (Throwable throwable) {
            log.error("接口异常：",throwable);
            if (throwable instanceof GlobalException) {
                GlobalException e = (GlobalException) throwable;
                return new ResponseVo<>(e.getCode(), e.getMessage(), null);
            }
            return ResponseVo.fail();
        }

    }

    @Before("execution(* com.czy.study.controller.*.*(..)))")
    public void beforeController(JoinPoint jp){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String uri = request.getRequestURI();
        Map<String, String[]> parameterMap = request.getParameterMap();
        log.info(String.format("接口：%s，请求参数：%s",uri,JSONObject.toJSONString(parameterMap)));
    }


}
