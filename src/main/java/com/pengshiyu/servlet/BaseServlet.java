package com.pengshiyu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String methodName = req.getParameter("method");

        if(methodName == null || methodName.trim().isEmpty()){
            throw new RuntimeException("method is null or empty");
        }
        System.out.println(methodName);

        // 通过参数获取方法
        Class clazz = this.getClass();

        Method method = null;
        try {
            method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 调用方法
        try {
            method.invoke(this, req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
