<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do" method="post" >
	<input type="hidden" name="action" value="login">
		UserName:<input type="text" name="uname">
		PassWord:<input type="password" name="upass">
		<br/>
		
<input type="submit" value="submit">	</form>
</body>
</html>