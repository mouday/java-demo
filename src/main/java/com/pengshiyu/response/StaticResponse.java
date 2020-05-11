package com.pengshiyu.response;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class StaticResponse extends HttpServletResponseWrapper {
    private PrintWriter pw;

    public StaticResponse(HttpServletResponse response, String filename) throws FileNotFoundException {
        super(response);
        this.pw = new PrintWriter(filename);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        // 掉包输出流
        return this.pw;
    }
}
