package com.pengshiyu.proxy;

import org.omg.CORBA.OBJ_ADAPTER;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class VehicalInvacationHandler implements InvocationHandler {

    private Object target;

    public VehicalInvacationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---------before-------");
        Object result = method.invoke(target, args);
        System.out.println("---------after-------");
        return result;
    }

}
