<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <%@ page import="java.util.*"%>
        <%!
            Date date=new Date();
            Date getDate(){
                return date;
            }
        %>
        하이. 현재 시간은 <%=getDate()%>임.
    </body>
    <%-- 이건 선언이라고 함, 메쏘드나 전역변수 선언할 때 사용 --%>
</html>