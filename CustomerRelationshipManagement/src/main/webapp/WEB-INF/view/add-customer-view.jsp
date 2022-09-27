<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<link href="<c:url value="/resources/css/CRMStyle.css" />" rel="stylesheet">
<title>Add Customer</title>
</head>
<body>
	<div class="container">
		<div id="headersection">
			<h2> Customer Relationship Management </h2>
		</div>
		<h5>Add Customer</h5>
		<form action="save" method="post">
			<input type="hidden" name="id" value="${customer.id}">
			<div class="form-inline">
			FirstName:<input type="text"  name="firstName" value="${customer.firstName}" placeholder="First Name" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
			LastName:<input type="text"  name="lastName" value="${customer.lastName}" placeholder="Last Name" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
			Email:<input type="text"  name="email" value="${customer.email}" placeholder="Email" class="form-control mb-4 col-4" style="margin-left: 128px;">
			</div>
			<button type="submit" class="btn btn-info col-2" style="margin-top: 15px;margin-left: 250px;">Submit</button>
		</form>
		<a href="list" style="text-decoration: underline;">Back to List</a>
	</div>
</body>
</html>