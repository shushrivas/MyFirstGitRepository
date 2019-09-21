<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>StudentIdInformation</title>
</head>
<body style="background-color:powderblue;">

	<div class="container">
		<h2>Hover Rows</h2>
		<p>The .table-hover class enables a hover state on table rows:</p>
		<table class="table table-hover">
			<thead>
				<tr>
				     <th>StudentId</th>
					<th>StudentName</th>
					<th>StudentAddress</th>
					<th>StudentMobileNo</th>
					<th>action</th>


				</tr>
			</thead>

			<tbody>
				<c:forEach items="${listOfStudents}" var="s">

					<tr>
					<td><c:out value="${s.studId}"></c:out></td>
					<td><c:out value="${s.studName}"></c:out></td>
					<td><c:out value="${s.studAddress}"></c:out></td>
					<td><c:out value="${s.studMobileNumber}"></c:out></td>
					<td><a href="edit?id=${s.studId}">EDIT</a>
					<a href="delete?id=${s.studId}">DELETE</a></td>
					
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>