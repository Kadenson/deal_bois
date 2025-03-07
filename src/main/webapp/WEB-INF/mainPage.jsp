<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>This is the main page</h1>
		<h1>Deal Bois</h1>
		<a href="/login">Log in</a>
		<a href="/register">Register</a>
		<a href="/products/new">new</a>
		<c:forEach var="product" items="${products}">
					<tr>
					
						<td><a href="/products/${product.id}"><c:out value="${product.name }"/> </a>
						<td>$<c:out value="${product.price }"/></td>	
						<td><c:out value="${product.description }"/></td>
						
						
						
					</tr>
				</c:forEach>
	</div>
</body>
</html>