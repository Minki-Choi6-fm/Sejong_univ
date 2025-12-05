<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!int day=7;%>
<head>
    <title>if/else 예제</title>
</head>
<body>
    <%if(day==1||day==7){%>
        <p>오늘은 주말입니다</p>
    <%}else{%>
        <p>오늘은 평일입니다</p>
    <%}%>
</body>