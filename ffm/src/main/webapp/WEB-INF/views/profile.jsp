<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@include file="./shared/navbar.jsp" %>

	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
			
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3>${user.firstName} ${user.lastName}</h3>
					</div>
					<div class="panel-body">
						<!-- showing details of user  -->
						
							<div class="row">
								<div class="col-xs-12">Personal Details</div>
								<!-- showing personal details -->
								<div class="col-xs-8">
								<table class="table table-responsive table-bordered">
									<tr>
										<td>Name : </td>
										<td>${user.firstName} ${user.lastName}</td>
									</tr>
									<tr>
										<td>Email Id: </td>
										<td>${user.email}</td>
									</tr>
									<tr>
										<td>Contact NO.: </td>
										<td>${user.contactNumber}</td>
									</tr>
									</table>
								</div>
								<div class="col-xs-4">
									<img class="img img-responsive" src="#" alt="profile image">
								</div>
							
							</div>
					</div>
				</div>	
			
			</div>
		
		</div>
	</div>

<%@include file="./shared/footer.jsp"%>