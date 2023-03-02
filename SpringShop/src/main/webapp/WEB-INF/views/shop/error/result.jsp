<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background:green">
이용에 불편을 드려 죄송합니다
<%RuntimeException e = (RuntimeException)request.getAttribute("e");%>
<%= e.getMessage() %>
</body>
</html>