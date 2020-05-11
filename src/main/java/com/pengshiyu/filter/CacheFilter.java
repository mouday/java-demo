package com.pengshiyu.filter;

import com.pengshiyu.response.StaticResponse;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class CacheFilter implements Filter {
    private FilterConfig config;
    private final String cacheFileName = "cache";
    private String cacheFilePath = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        this.cacheFilePath = this.config.getServletContext().getRealPath(this.cacheFileName);

        File file = new File(this.cacheFilePath);
        if(file.exists()){
            file.mkdir();
        }

    }

    /**
     * 访问路径
     * http://localhost:8080/demo/book?method=findByCategory&category=4
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String category = request.getParameter("category");

        String filepath = this.cacheFilePath + "/" + category + ".html";
        File file = new File(filepath);

        // 如果页面不存在就缓存页面
        if(!file.exists()){
            StaticResponse staticResponse = new StaticResponse(response, filepath);
            filterChain.doFilter(request, staticResponse);
        }

        System.out.println("文件存在了");
        request.getRequestDispatcher(this.cacheFileName + "/" + category + ".html").forward(request, response);

    }

    @Override
    public void destroy() {

    }
}
