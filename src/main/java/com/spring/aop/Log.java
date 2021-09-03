package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Log {
    @Before("execution(* com.spring.service.impl.UserServiceImpl.* (..))")
    public void before(){
        System.out.println("--before--");
    }

    @After("execution(* com.spring.service.impl.UserServiceImpl.* (..))")
    public void after(){
        System.out.println("--after--");
    }

    @Around("execution(* com.spring.service.impl.UserServiceImpl.* (..))")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("--Around before--");
        Object result = pjp.proceed();
        System.out.println("--Around after--");
        return result;
    }
}
