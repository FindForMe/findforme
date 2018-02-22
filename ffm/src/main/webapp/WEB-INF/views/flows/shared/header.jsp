<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		<script>
			window.menu = '${title}';
			window.contextRoot = "${contextRoot}";
			//window.imgRoot = "${img}";
		</script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1" name="viewport" />
		<meta content="" name="description" />
		<meta content="" name="author" />
		<!-- bootstrap core -->
		<link rel="stylesheet" href="${css}/bootstrap.css">
		
		<!-- bootstrap readable theme -->
		<link rel="stylesheet" href="${css}/bootstrap-readable-theme.css">
		
		<!-- datatable css -->
		<link rel="stylesheet" href="${css}/dataTables.bootstrap.css">
		<!-- default -->
		<link rel="stylesheet" href="${css}/default.css">
	
	</head>
	
	<body>

		<div class="wrapper">
	
			<!-- Navigation -->
			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		        <div class="container">
		            <!-- Brand and toggle get grouped for better mobile display -->
		            <div class="navbar-header">
		                <a class="navbar-brand" href="${flowExecutionUrl}&_eventId=home">Find For Me</a>
		            </div>
				</div>
			</nav>
			
	
			<!-- Page Contents -->
			<div class="content">