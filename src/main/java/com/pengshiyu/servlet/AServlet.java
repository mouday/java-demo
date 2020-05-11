package com.pengshiyu.servlet;

import com.pengshiyu.bean.User;
import sun.java2d.SurfaceDataProxy;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().print(request.getSession().getAttribute("user"));

        User user = new User();
        System.out.println(user);
        // request.getSession().setAttribute("user", user);
        response.getWriter().print("hhhxxxxxyyy");

        Cookie cookie = new Cookie("key", "value");
        response.addCookie(cookie);

        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie c: cookies){
                System.out.println(c.getName() + ": "+ c.getValue());
            }
        }


    }
}
