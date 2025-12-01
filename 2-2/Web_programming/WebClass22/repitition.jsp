<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!int fontSize;%>
<head>
    <title>반복 구조 예제</title>
</head>
<body>
    <% for(fontSize=1;fontSize<=6;fontSize++){%>
        <font color="red" size="<%=fontSize%>">
            안녕하세요?
        </font><br>
    <%}%>
</body>