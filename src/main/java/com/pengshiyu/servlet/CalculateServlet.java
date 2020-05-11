package com.pengshiyu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        String s1 = request.getParameter("num1");
        String s2 = request.getParameter("num2");

        // 类型转换
        int num1 = Integer.parseInt(s1);
        int num2 = Integer.parseInt(s2);

        // 求和
        int result = num1 + num2;

        // 赋值
        request.setAttribute("result", result);

        // 转发
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
