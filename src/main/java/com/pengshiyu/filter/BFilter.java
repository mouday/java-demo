package com.pengshiyu.filter;

import javax.servlet.*;
import java.io.IOException;

public class BFilter implements Filter {
    /**
     * 创建之后马上执行，用来做初始化
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 每次过滤都会执行
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Bfilter进入过滤器");
        // 调用后序方法
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Bfilter离开过滤器");
    }

    /**
     * 销毁之前的调用，用来释放资源
     */
    @Override
    public void destroy() {

    }
}
