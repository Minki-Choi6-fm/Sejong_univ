<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<body>
    <table border="2">
    <%
        int n=45;
        for(int i=0;i<n;i++){
    %>
        <tr><td>Number</td>
            <td><%=i+1%></td>
        </tr>
        <%}%>
    </table>
</body>