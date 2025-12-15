<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
    <%
    String[] str=request.getParameterValues("eat");
    if(str.length==0){
        out.println("메뉴를 선택해주세요");
    }
    int sum=0;
    for(int i=0;i<str.length;i++){
        out.println(str[i]+"<br>");
        if(str[i].equals("pizza")){
            sum=15000;
        }
        else if(str[i].equals("chicken")){
            sum+=18000;
        }
        else if(str[i].equals("hamburger")){
            sum+=8000;
        }
        else if(str[i].equals("spaghetti")){
            sum+=12000;
        }
    }
    out.println("합계: "+sum);
    %>
</body>