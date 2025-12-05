<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>싸인 함수 계산</title>
</head>
<body>

    <%! 
        int[] angles = {0, 30, 60, 90}; 
    %>

    <h1 align="center">싸인함수</h1>

    <table border="1" align="center">
        <tr>
            <th>각도</th>
            <th>싸인값</th>
        </tr>

        <% 
            for(int i = 0; i < angles.length; i++) { 
        %>
            <tr>
                <td><%= angles[i] %></td>
                <td><%= Math.sin(Math.toRadians(angles[i])) %></td>
            </tr>
        <% 
            } 
        %>
    </table>

</body>
</html>