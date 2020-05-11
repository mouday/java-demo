package com.pengshiyu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String verifyCode = request.getParameter("verify_code");

        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("code");

        // 验证码校验
        if(!code.equalsIgnoreCase(verifyCode)){
            session.setAttribute("msg", "验证码不正确");
            response.sendRedirect("session/login.jsp");
            return;
        }

        if ("admin".equals(username) && "123456".equals(password)) {

            session.setAttribute("username", username);

            // 添加Cookie
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 24); // 保存一天
            response.addCookie(cookie);

            response.sendRedirect("session/admin.jsp");
        } else {
            session.setAttribute("msg", "账号或密码不正确");
            response.sendRedirect("session/login.jsp");
        }


    }
}