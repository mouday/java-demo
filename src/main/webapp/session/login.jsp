<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String msg = (String)session.getAttribute("msg");
if(msg == null){
    msg = "";
}
%>

<h2>登录</h2>

<div style="color: red"><%=msg%></div>

<%
  // 清空session
  session.removeAttribute("msg");
%>

<form action="/demo/login" method="post">
    用户名：<input type="text" name="username"><br/>
    密码：<input type="text" name="password"><br/>
    验证码：<input type="text" name="verify_code">
    <img src="/demo/code" id="code">  <a href="javascript:changeImage()">换一张</a>
    <br/>
    <input type="submit">
</form>

<script>
function changeImage(){
    let code = document.getElementById("code");
    code.src = "/demo/code?" + new Date().getTime();
}
</script>