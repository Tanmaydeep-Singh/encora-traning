<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop - Welcome</title>
</head>
<body>
    <h1>Welcome to the Shop</h1>
    <br/>

    <form action="logout.do" method="post">
        <input type="hidden" name="action" value="logout"/>
        <input type="submit" value="Logout"/>
    </form>
    
     <form action="addItems.jsp" method="post">
        <input type="hidden" name="action" value="addItems"/>
        <input type="submit" value="Add Items"/>
    </form>
    
    
    <hr>
	<h1>Fruit Shop....</h1>
	<form action="shopping.do" method="post">
		<input type="hidden" name="action" value="shopping"> <input
			type="hidden" name="shopid" value="shop1"> 
			Apple:<input type="checkbox" name="c1" value="Apple"> 
			Mango:<input type="checkbox" name="c2" value="Mango"> 
			Banana:<input type="checkbox" name="c3" value="Banana"> 
			<input type="submit" value="Next Shop">
	</form>
	<hr>
</body>
</html>
