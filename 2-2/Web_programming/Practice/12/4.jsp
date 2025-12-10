<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Request 정보 출력</title>
</head>
<body>
    <h2>클라이언트 및 서버 정보 확인</h2>
    
    <ul>
        <%-- 1. 호스트 이름 (도메인) --%>
        <li>호스트 이름: <%= request.getServerName() %></li>

        <%-- 2. 요청 방식 (GET 또는 POST) --%>
        <li>요청 방식: <%= request.getMethod() %></li>

        <%-- 3. 컨텐츠 길이 (GET 방식이면 body가 없어서 -1이 나옵니다) --%>
        <li>컨텐츠 길이: <%= request.getContentLength() %></li>

        <%-- 4. 클라이언트의 포트 번호 --%>
        <li>클라이언트 포트: <%= request.getRemotePort() %></li>

        <%-- 5. 클라이언트의 IP 주소 --%>
        <li>클라이언트 IP: <%= request.getRemoteAddr() %></li>
        
        <%-- 6. 요청한 URI (파일 경로) --%>
        <li>요청 URI: <%= request.getRequestURI() %></li>

        <%-- 7. 세션 ID (사용자 식별용 고유 키) --%>
        <li>세션 ID: <%= session.getId() %></li>
    </ul>

</body>
</html>