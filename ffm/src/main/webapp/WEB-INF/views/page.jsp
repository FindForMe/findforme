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
			<%@ include file="./shared/navbar.jsp"%>
	
	
			<!-- Page Contents -->
			<div class="content">
				
				<!-- Loading the home content -->
				<c:if test="${userClickHome == true}" >
					<%@include file="./home.jsp"%>
				</c:if>
				
				<!-- Loading the about content -->
				<c:if test="${userClickAbout == true}" >
					<%@include file="./about.jsp"%>
				</c:if>
				
				<!-- Loading the Hire content -->
				<c:if test="${userClickHire == true}" >
					<%@include file="./hire.jsp"%>
				</c:if>
				
				<!-- Loading the find content -->
				<c:if test="${userClickFind == true}" >
					<%@include file="./find.jsp"%>
				</c:if>
				
				<!-- Loading the contact content -->
				<c:if test="${userClickContact == true}" >
					<%@include file="./contact.jsp"%>
				</c:if>
				<!-- Loading All Products -->
				<c:if test="${userClickAllProducts == true}">
					<%@include file="./listProducts.jsp" %>
				</c:if>
				<!-- Loading Category Product -->
				<c:if test="${userClickShowProduct == true}">
					<%@include file="./singleProduct.jsp" %>
				</c:if>
				<!-- Loading All Post -->
				<c:if test="${userClickAllPost == true or userClickCategoryPost == true }">
					<%@include file="./post.jsp" %>
				</c:if>
				
				<%-- <!-- Loading All Post -->
				<c:if test="${userClickAllPost == true or userClickCategoryPost == true }">
					<%@include file="./post.jsp" %>
				</c:if> --%>
				
				<%-- 
				<!-- Loading All Post -->
				<c:if test=" ${userClickCategoryPost == true }">
					<%@include file="./post.jsp" %>
				</c:if> 
				--%>
				
				<!-- Loading Single Post -->
				<c:if test="${userClickSinglePost == true}">
					<%@include file="./singlePost.jsp" %>
				</c:if>
				
				<!-- Loading ManagePost -->
				<c:if test="${userClickManagePost == true}">
					<%@include file="./managePost.jsp" %>
				</c:if>
			</div>
			<!-- Footer -->
			<%@include file="./shared/footer.jsp"%>
			
			<!-- jQuery -->
			<script src="${js}/jquery.js"></script>
	
			<script src="${js}/jquery.validate.js"></script>
	
			<!-- Bootstrap Core JavaScript -->
			<script src="${js}/bootstrap.min.js"></script>
			
			<!-- DataTable Plugin -->
			<script src="${js}/jquery.dataTables.js"></script>
			
			<!-- DataTable Bootstrap Script -->
			<script src="${js}/dataTables.bootstrap.js"></script>
			
			<!-- DataTable Bootstrap Script -->
			<script src="${js}/bootbox.min.js"></script>
			
			<!-- Default JavaScript -->
			<script type="text/javascript" src="${js}/default.js"></script>
			
		</div>
	
	</body>
</html>