package com.pengshiyu.servlet;

import util.ImageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VerifyCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = ImageUtil.getVerifyCode(4);
        request.getSession().setAttribute("code", code);
        ImageUtil.writeImage(code, response.getOutputStream());
    }
}
