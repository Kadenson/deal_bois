<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>My Account</title>
</head>
<body>
	<div class="container">
		<h1>My Account</h1>
		<h5>First Name: <c:out value="${user.firstName }"/></h5>
		<h5>Last Name: <c:out value="${user.lastName }"/></h5>
		<h5>Email: <c:out value="${user.email }"/></h5>
		<a href="/dashboard">Return to dashboard</a>
		<a href="/logout">Log out</a>

		
	</div>
</body>