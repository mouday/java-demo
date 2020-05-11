package com.pengshiyu.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.nio.charset.StandardCharsets;

// 装饰器
public class EncodingRequest extends HttpServletRequestWrapper {

    public EncodingRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        // 处理编码问题
        String value = super.getParameter(name);
        value = new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return value;

    }
}
