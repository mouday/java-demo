<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 从session中获取
// String username =(String)session.getAttribute("username");

// 从cookie中获取
String username = null;
Cookie[] cookies = request.getCookies();
if(cookies != null){
    for (Cookie c :cookies){
        if(c.getName().equals("username")){
            username = c.getValue();
            break;
        }
    }
}
if(username == null){
    request.getSession().setAttribute("msg", "用户未登录");
    response.sendRedirect("login.jsp");
}
%>

<h2>欢迎<%=username%></h2>

