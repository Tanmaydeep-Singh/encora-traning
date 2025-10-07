<%@page import="com.strutsShoppingProject.repository.UserRepo"%>
<%@page import="com.strutsShoppingProject.model.Users"%>
<%@page import="com.strutsShoppingProject.model.Bill"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bill Summary</title>
</head>
<body>
<h1>Bill has been generated:</h1>

<%
    Bill billdetails = (Bill) request.getAttribute("billdetails");
    if (billdetails != null) {
%>
    <p><strong>Bill ID:</strong> ₹<%= billdetails.getId() %></p>
    <p><strong>Customer ID:</strong> <%= billdetails.getUser().getId() %></p>

    <p><strong>Items:</strong></p>
    <ul>
    <%
        for (String itemId : billdetails.getItems()) {
    %>
        <li><%= itemId %></li>
    <%
        }
    %>
    </ul>

    <p><strong>Total Amount:</strong> ₹<%= billdetails.getTotalCost() %></p>
<%
    } else {
%>
    <p>Bill details not available.</p>
<%
    }
%>
</body>
</html>
