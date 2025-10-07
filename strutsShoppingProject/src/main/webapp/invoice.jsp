<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Purchased Items</title>
</head>
<body bgcolor="pink">
    <h1>Items You Purchased:</h1>
    <ul>
    <%
        Enumeration<String> e = session.getAttributeNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            Object value = session.getAttribute(name);
            
            if(name != "uid"){
    %>
    
            <li><b><%= name %>:</b> <%= value %></li>
    <%
            }        }
    %>
    </ul>
  <br/>
  <h1>GET BILL:</h1>
  <form action="bill.do" method="post" >
	<input type="hidden" name="action" value="bill">		
<input type="submit" value="submit">	</form>
  
</body>
</html>
