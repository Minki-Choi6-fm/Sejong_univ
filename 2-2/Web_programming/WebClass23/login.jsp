<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
    <%
        String id,pw;
        id=request.getParameter("id");
        pw=request.getParameter("pw");

        out.println("id"+id+"<br>");
        out.println("pw"+pw+"<br>");

        if(id.equals("hong")&&pw.equals("1234")){
            out.println("로그인 성공<br>");
        }
        else{
            out.println("로그인 실패<br>");
        }
    %>
    <a href="/">GoToHome</a>
</body>