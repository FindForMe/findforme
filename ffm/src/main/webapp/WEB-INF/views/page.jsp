<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="img" value="/resources/img" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>

<html ng-app="ffmApp">
	<head >
		<title>${title}</title>
		
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1" name="viewport" />
		<meta content="" name="description" />
		<meta content="" name="author" />
		<%-- <!-- bootstrap core -->
		<link rel="stylesheet" href="${css}/bootstrap.css"> --%>
		<!-- Bootstrap -->
		<link  rel="stylesheet" href="${css}/bootstrap.min.css" />
		<%-- <!-- bootstrap readable theme -->
		 <link rel="stylesheet" href="${css}/bootstrap-readable-theme.css">  --%>
		
		<!-- datatable css -->
		<link rel="stylesheet" href="${css}/dataTables.bootstrap.css">
		 <!-- default -->
		<link rel="stylesheet" href="${css}/default.css"> 
		
		<!-- Google font -->
		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700%7CVarela+Round" rel="stylesheet">
	
		<!-- Owl Carousel -->
		<link  rel="stylesheet" href="${css}/owl.carousel.css" />
		<link  rel="stylesheet" href="${css}/owl.theme.default.css" />
	
		<!-- Magnific Popup -->
		<link rel="stylesheet" href="${css}/magnific-popup.css" />
	
		<!-- Font Awesome Icon -->
		<link rel="stylesheet" href="${css}/font-awesome.min.css">
	
		<!-- Custom stlylesheet -->
		<link  rel="stylesheet" href="${css}/style.css" />
		
		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/jquery.validate.js"></script>
		<script type="text/javascript" src="${js}/jquery.magnific-popup.js"></script>
		<script src="${js}/jquery.dataTables.js"></script> 

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		<!-- DataTable Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		<!-- DataTable Bootstrap Script -->
		<script src="${js}/bootbox.min.js"></script>
		
		<script>
			window.menu = '${title}';
			window.contextRoot = "${contextRoot}";
			//window.imgRoot = "${img}";
		</script>
	
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
				
			
				<!-- Loading the find content -->
				<c:if test="${userClickFind == true}" >
					<%@include file="./find.jsp"%>
				</c:if>
				
				<!-- Loading the contact content -->
				<c:if test="${userClickContact == true}" >
					<%@include file="./contact.jsp"%>
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
				<c:if test="${userClickShowUser == true}">
					<%@include file="./profile.jsp"%>
				</c:if>
				
			</div>
			<!-- Footer -->
			<%@include file="./shared/footer.jsp"%>
			
			<%-- <!-- jQuery -->
			<script src="${js}/jquery.js"></script>
			<script src="${js}/jquery.validate.js"></script>
			<script type="text/javascript" src="${js}/jquery.magnific-popup.js"></script>
			<script src="${js}/jquery.dataTables.js"></script> 
	
			<!-- Bootstrap Core JavaScript -->
			<script src="${js}/bootstrap.min.js"></script>
			<!-- DataTable Bootstrap Script -->
			<script src="${js}/dataTables.bootstrap.js"></script>
			<!-- DataTable Bootstrap Script -->
			<script src="${js}/bootbox.min.js"></script> --%>
			
			<!-- Globalffm JavaScript -->
			<script type="text/javascript" src="${js}/ffmGlobal.js"></script>
			
			<!-- angular js -->
			<script type="text/javascript" src="${js}/angular.js"></script>
		 	
			<!-- Default JavaScript -->
			<script type="text/javascript" src="${js}/default.js"></script> 
			
			<!-- default Angular -->
			<script type="text/javascript" src="${js}/ffmAngular.js"></script>
			
			<!-- jQuery Plugins -->
			
			<script type="text/javascript" src="${js}/owl.carousel.min.js"></script>
			
			<script type="text/javascript" src="${js}/main.js"></script>
			
			
		</div>
	
	</body>
</html>