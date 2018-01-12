<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="img" value="/resources/img" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>

<html>
<head>
<title>${title}</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />

<link rel="stylesheet" href="${css}/bootstrap.css">
<link rel="stylesheet" href="${css}/default.css">

</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<%@ include file="./shared/navbar.jsp"%>


		<!-- Page Contents -->
		<div class="content">
			
			<!-- Loading the home content -->
			<%@include file="./home.jsp"%>
			
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- jQuery -->
		<script type="text/javascript" src="${js}/jquery-3.2.1.js"></script>

		<!-- BootStrap core JavaScript-->
		<script type="text/javascript" src="${js}/bootstrap.js"></script>

		<!-- Default JavaScript -->
		<script type="text/javascript" src="${js}/default.js"></script>

	</div>

</body>
</html>