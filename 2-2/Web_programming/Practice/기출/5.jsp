<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
    <form method="post" action="">
        첫 번째 숫자: <input type="text" name="first"><br>
        두 번째 숫자: <input type="text" name="second"><br>
        <input type="submit" value="제출">
    </form>
    <%
        String x=request.getParameter("first");
        String y=request.getParameter("second");
        int first=0;
        int second=0;
        if(x!=null){
            first=Integer.parseInt(x);
        }
        if(y!=null){
            second=Integer.parseInt(y);
        }
        int result=first+second;
    %>
    <p id="result">합 =<%= result%></p>
</body>