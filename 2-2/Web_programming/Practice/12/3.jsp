<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<body>
    <form method="post" action="">
        정수를 입력하시오:<input type="text" name="input">
        <br><input type="submit" value="팩토리얼 계산">
    </form>
    <%
        String str=request.getParameter("input");
        long sum=1;
        if(str!=null){
            int s=Integer.parseInt(str);

            for(int i=1;i<=s;i++){
                sum*=i;
            }
        } 
    %>
    <p>팩토리얼 = <%=sum%></p>
</body>