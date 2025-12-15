<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<body>
    <form method="post" action="">
        텍스트를 입력하시오:<input type="text" name="input">
        <br><input type="submit" value="제출">
    </form>
    <%
        String s = request.getParameter("input");
        
        if (s != null && !s.equals("")) {
            for(int i=12; i<=21; i+=2){
    %>
                <p style="font-size: <%= i %>px;"> <%= s %> </p>
    <%
            }
        }
    %>
</body>