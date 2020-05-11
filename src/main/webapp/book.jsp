<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>图书列表</h2>
分类：
<a href="book?method=findAll">全部</a>
<a href="book?method=findByCategory&category=1">第一类</a>
<a href="book?method=findByCategory&category=2">第二类</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>书名</th>
        <th>价格</th>
        <th>分类</th>
    </tr>
    <c:forEach items="${bookList}" var="book">
        <tr>
            <td>${book.bid}</td>
            <td>${book.bname}</td>
            <td>${book.price}</td>
            <td>${book.category}</td>
        </tr>
    </c:forEach>
</table>
