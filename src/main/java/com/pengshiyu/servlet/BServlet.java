package com.pengshiyu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext app = getServletContext();
        Map<String, Integer> map = (Map<String, Integer>) app.getAttribute("map");

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println(map.toString());

    }
}
