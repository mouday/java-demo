package com.pengshiyu.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.log(method.getName());
        Object result = method.invoke(proxy, args);
        return result;
    }

    public void log(String message){
        System.out.println(message);
    }
}
