<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<body>
    <form method="post" action="2.jsp">
        텍스트를 입력하시오:<input type="text" name="input">
        <br><input type="submit" value="제출">
    </form>
    <%
        String s=request.getParameter("input");
        for(int i=10;i<15;i++){
    %>
            <p style="font-size: <%= i %>;"> <%= s %> </p>
    <%}%>
</body>