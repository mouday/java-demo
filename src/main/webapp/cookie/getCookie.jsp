<h2>获取Cookie</h2>
<%
Cookie[] cookies = request.getCookies();

if(cookies != null){
    for(Cookie c: cookies){
        out.print(c.getName() + ": "+ c.getValue());
    }
}
%>