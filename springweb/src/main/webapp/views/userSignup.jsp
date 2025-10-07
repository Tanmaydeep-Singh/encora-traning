<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp Page</title>
</head>
<body>

<h1> User Signup </h1>

<form:form action="/user/signup" method="POST" modelAttribute="userObj">
	UserName:<form:input path="uname"/>
	<form:errors path="uname"></form:errors><br>
	PassWord:<form:input path="upass"/><br>
	Email:<form:input path="email"/><br>
	Phone:<form:input path="phone"/><br>
	
	<input type="submit" value="click...">
	
</form:form>

</body>
</html>