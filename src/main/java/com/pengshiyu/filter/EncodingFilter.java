package com.pengshiyu.filter;

import com.pengshiyu.request.EncodingRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String method = httpServletRequest.getMethod();

        // 设置响应编码
        response.setContentType("text/html; charset=UTF-8");

        if ("GET".equals(method)) {
            // 放行
            EncodingRequest encodingRequest = new EncodingRequest(httpServletRequest);
            filterChain.doFilter(encodingRequest, response);
        } else if ("POST".equals(method)) {
            request.setCharacterEncoding("utf-8");
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
