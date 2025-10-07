<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>add items:</h1>

<form action="addItems.do" method="post" >
	<input type="hidden" name="action" value="addItems">
		Name:<input type="text" name="itemName">
		Price:<input type="number" name="itemPrice">
		<br/>
		
<input type="submit" value="Add">	</form>

</body>
</html>