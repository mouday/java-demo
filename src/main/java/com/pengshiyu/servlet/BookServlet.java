package com.pengshiyu.servlet;

import com.pengshiyu.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookServlet extends BaseServlet {
    private BookDao bookDao = new BookDao();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("bookList", bookDao.findAll());
        request.getRequestDispatcher("book.jsp").forward(request, response);
    }

    public void findByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int category = Integer.parseInt(request.getParameter("category"));
        System.out.println("即将查询数据库");
        request.setAttribute("bookList", bookDao.findByCategory(category));
        request.getRequestDispatcher("book.jsp").forward(request, response);

    }
}
