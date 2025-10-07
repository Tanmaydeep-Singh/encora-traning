<%@page import="jakarta.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Hello USER</h1>


<p>a</p>
<%
out.println(request.getAttribute("myObjReq"));
%>
<p>b</p>

<%
out.println(	request.getAttribute("myObj"));

%>
<p>c</p>
<%
out.println(request.getAttribute("myObj2")
);

%>

<p>d</p>
<%
out.println(session.getAttribute("mySessionObj")
);

%>


	
</body>
</html>