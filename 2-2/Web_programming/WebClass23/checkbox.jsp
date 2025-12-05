<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
    <%
    String[] fruits=request.getParameterValues("fruit");
    if(fruits!=null){
    %>
    <h3>당신이 선택한 과일은:</h3>
    <ul>
    <%for(int i=0;i<fruits.length;i++){
    %>
        <li><%=fruits[i]%></li>
    <%
    }
    %>
    </ul>
    <a href="<%= request.getRequestURL()%>">다시 시도</a>
    <%
    }
    %>
</body>