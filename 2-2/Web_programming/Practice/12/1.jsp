<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form name="test" method="post" action="1.jsp">
        첫 번째 숫자: <input type="text" name="first"><br>
        두 번째 숫자: <input type="text" name="second"><br>
        <input type="submit" value="제출">
    </form>

    <%
        String s1 = request.getParameter("first");
        String s2 = request.getParameter("second");

        if (s1 != null && s2 != null) {
            int a = Integer.parseInt(s1);
            int b = Integer.parseInt(s2);
            int c = a + b;
    %>
            <p name="sum">합: <%= c %></p>
    <%
        }
    %>
</body>
</html>