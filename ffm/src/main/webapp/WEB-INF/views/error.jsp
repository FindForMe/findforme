<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url var="css" value="/resources/css" />
<spring:url var="img" value="/resources/img" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Comatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
		
		<!-- Bootstrap Core Css -->
		<link rel="stylesheet" href="${css}/bootstap.min.css">
		<!-- Bootstrap Readable Theme -->
		<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
		
		<!-- Custom CSS -->
		<link href="${css}/default.css" rel="stylesheet">
	
		<title>
			FFM - ${title}
		</title>
	
	</head>
	<body>
		
		<div class="wrapper">
			
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="navbar-header">
					<a href="${contextRoot}/home"><img src="${img}/logo.PNG"></a>
				
				</div>
			
			</nav>
			
			<div class="content">
				<div class="container">
					<div class="row">
						<div class="col-xs-12">
							<div class="jumbotron">
								<h1>${errorTitle}</h1>
								<hr>
								<blockquote style="word-wrap:break-word">
									${errorDescription}
								</blockquote>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<!-- footer -->
			<%@include file="./shared/footer.jsp" %>
			
		</div>
	</body>

</html>



