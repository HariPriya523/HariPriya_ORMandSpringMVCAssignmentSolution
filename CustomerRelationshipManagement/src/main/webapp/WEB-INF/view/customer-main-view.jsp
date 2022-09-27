<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer RelationShip Management</title>
<link rel="stylesheet"
	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<link href="<c:url value="/resources/css/CRMStyle.css" />" rel="stylesheet">
</head>
<body>
	<div class = "container">
		<div id="headersection">
		<h2> Customer Relationship Management </h2>
		</div>
		
		<a href ="add" class="btn btn-primary btn-sm mb-3">Add Customer</a>
		<br>
		<table class ="table table-bordered table-striped">
			<thead class ="thead-dark">
				<tr>
					<th>First Name</th>
					<th>Last Name </th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customerlist}" var="customer">
					<tr>
						<td><c:out value="${customer.firstName}"></c:out></td>
						<td><c:out value="${customer.lastName}"></c:out></td>
						<td><c:out value="${customer.email}"></c:out></td>
						<td>
							<a href="update?id=${customer.id}"class="btn btn-primary btn-sm mb-3" style="margin-top: 2px;margin-bottom: 2px;">Update</a>
							<a href="delete?id=${customer.id}" class="btn btn-primary btn-sm mb-3" style="margin-top: 2px;margin-bottom: 2px;">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>