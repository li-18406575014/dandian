<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>请登录</h1>
	<form action="<%=request.getContextPath() %>/LoginController/getLogin" method="post">
		<span>用户名:</span><input type="text" name="username">
		<span>密&nbsp;码</span><input type="password" name="password">
		<input type="hidden" name="gotoURL">
		<input type="submit">
	</form> 
</body>
</html>