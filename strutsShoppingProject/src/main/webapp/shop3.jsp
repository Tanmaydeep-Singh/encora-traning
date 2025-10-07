<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Grocery Shop....</h1>
	<form action="shopping.do" method="post">
		<input type="hidden" name="action" value="shopping"> <input
			type="hidden" name="shopid" value="shop3"> 
			Rice:<input type="checkbox" name="c7" value="Rice"> 
			Flour:<input type="checkbox" name="c8" value="Flour"> 
			MustardOil:<input type="checkbox" name="c9" value="MustardOil"> 
			<input type="submit" value="Invoice">
	</form>
</body>
</html>