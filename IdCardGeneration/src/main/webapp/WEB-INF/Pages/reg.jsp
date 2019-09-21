<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>

<spring:url value="/resources/css/main.css" var="mainCss" />
<spring:url value="/resources/js/jquery.1.10.2.min.js" var="jqueryJs" />
<spring:url value="/resources/js/main.js" var="mainJs" />

<link href="${mainCss}" rel="stylesheet" />
<script src="${jqueryJs}"></script>
<script src="${mainJs}"></script>
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
<title>Student RegistrationForm</title>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<div align="center">
		${msg} ${msgg}
		<form:form class="form-horizontal" modelAttribute="studForm"
			action="saveInfo" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Form Name</legend>
				<form:input type="hidden" id="studId" path="studId"></form:input>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="studName">StudentName</label>
					<div class="col-md-4">
						<form:input id="studName" name="studName" path="studName"
							type="text" placeholder="Enter the name "
							class="form-control input-md"></form:input>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="studAddress">studentAddress</label>
					<div class="col-md-4">
						<form:input id="studAddress" name="studAddress" path="studAddress"
							type="text" placeholder="Enter the Address"
							class="form-control input-md"></form:input>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="studmobile">MobileNumber</label>
					<div class="col-md-4">
						<form:input id="studMobileNumber" path="studMobileNumber"
							name="studMobileNumber" type="text"
							placeholder="Enter the MobileNo" class="form-control input-md"></form:input>

					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit">SaveInformation</label>
					<div class="col-md-4">
						<button id="submit" name="submit" class="btn btn-primary">Save</button>
					</div>


				</div>

			</fieldset>
		</form:form>
	</div>
	<a href="displayInfo">Show All Student Infomation</a>
</body>
</html>