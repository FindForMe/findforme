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
								<!-- <div class="col-xs-12">Personal Details</div> -->
								<!-- showing personal details -->
								<hr/>
								
								<div class="col-xs-12 col-sm-4">
		
										<div class="thumbnail">
														
											<img src="#" class="img img-responsive" alt="Profile Image"/>
													
										</div>
									
									</div>
								<div class="col-xs-12 col-sm-6">
								
									<p><span class="labelText">Full Name </span>: ${user.firstName} ${user.lastName}</p>
									<p><span class="labelText">Email </span>: ${user.email}</p>
									<p><span class="labelText">Contact No. </span>: ${user.contactNumber}</p>
								</div>
								<div class="col-sm-2">
									<hr>
									<button type="button" class="btn btn-primary" data-target="#personalModal" data-toggle="modal"><span class="glyphicon glyphicon-pencil"></span></button>
								</div>
								<div class="col-xs-12">
									<hr>
									<button type="button" class="btn btn-primary" data-target="#personalModal" data-toggle="modal"><span class="glyphicon glyphicon-pencil"></span></button>
								</div>
							
							</div>
							<hr>
							<!-- Address -->
							<div class="row">
								<div class="col-xs-12 col-sm-5">
						
									<h4>Permanent Address</h4><hr/>
									<c:if test = "${not empty pAddress}">
										<p>${pAddress.addressLineOne}</p>
										<p>${pAddress.addressLineTwo}</p>
										<p>${pAddress.city} - ${pAddress.postalCode}</p>
										<p>${pAddress.state}</p>
										<p>${pAddress.country}</p>
									</c:if>
									<c:if test = "${empty pAddress}">
										<p>Address is not set please update your Address</p>
									</c:if>
									<hr>
									<div class="col-xs-12 col-sm-2">
										<button type="button" class="btn btn-primary" data-target="#personalModal" data-toggle="modal"><span class="glyphicon glyphicon-pencil"></span></button>
									</div>
									
								</div>
								<div class="col-xs-12 col-sm-5">
									
									
										<h4>Present Address</h4><hr/>
										<c:if test="${not empty cAddress}">
											<p>${cAddress.addressLineOne}</p>
											<p>${cAddress.addressLineTwo}</p>
											<p>${cAddress.city} - ${cAddress.postalCode}</p>
											<p>${cAddress.state}</p>
											<p>${cAddress.country}</p>
										</c:if>
										<c:if test = "${empty cAddress}">
											<p>Address is not set please update your Address</p>
										</c:if>
									<hr/>
									<div class="col-xs-12 col-sm-2">
										<button type="button" class="btn btn-primary" data-target="#personalModal" data-toggle="modal"><span class="glyphicon glyphicon-pencil"></span></button>
									</div>
							
										
								</div>
								
							</div>
					</div>
					<div class="panel-footer">
					</div>
				</div>	
			<!-- Address Details -->			
			
			
			</div>
		
		</div>
	</div>

<%@include file="./shared/footer.jsp"%>