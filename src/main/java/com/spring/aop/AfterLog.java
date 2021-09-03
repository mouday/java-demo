package com.spring.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

// 后置通知
public class AfterLog implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object result, Method method, Object[] objects, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + ": "+ method.getName());
    }
}
