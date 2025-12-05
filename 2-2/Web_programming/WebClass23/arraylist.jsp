<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>

<body>
    <%
        ArrayList arr=new ArrayList();
        arr.add("Gray");
        arr.add("Purple");
        arr.add("Orange");

        for(int i=0;i<arr.size();i++){
            out.println("배열 요소:"+arr.get(i)+"<br>");
        }
    %>
</body>
