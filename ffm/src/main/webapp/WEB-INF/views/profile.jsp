<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@include file="./shared/navbar.jsp" %>

	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
			
				<div class="panel">
					<div class="panel-heading">
						<h3>Name</h3>
					</div>
					<div class="panel-body">
						<!-- showing details of user  -->
						<table class="table table-responsive table-bordered">
							<tr>
								<th>Personal details</th>
							</tr>
							<tr>
								<td>
									<tr>
										<td>Name : </td>
										<td>${user.firstName} ${lastName}</td>
										<!-- <td>
											<button type="button" class="btn btn-primary" data-target="#personalModal" data-toggle="modal"><span class="glyphicon glyphicon-pencil"></span>
											</button>
										</td> -->
									</tr>
									<tr>
										<td>Email Id: </td>
										<td>${user.email}</td>
									</tr>
									<tr>
										<td>Contact NO.: </td>
										<td>${user.contactNumber}</td>
									</tr>
									
								</td>
								<td>
									<img class="image-responsive" src="#" alt="profile picture">
								</td>
							</tr>
						</table>
					</div>
				</div>	
			
			</div>
		
		</div>
	</div>

<%@include file="./shared/footer.jsp"%>