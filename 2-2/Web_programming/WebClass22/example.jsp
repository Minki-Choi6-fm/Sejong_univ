<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<body>
    <%!
        int square(int n){
            return n*n;
        }
    %>
    <%= new String("Hello World").toUpperCase()%>
    <br>
    <%
        for(int i=0;i<10;i++){
            out.println(i);
        }
    %>
    <br>
    <%=square(9)%>
</body>