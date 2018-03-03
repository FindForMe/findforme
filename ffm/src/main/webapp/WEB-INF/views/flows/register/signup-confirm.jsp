<%@include file="../flows-shared/header.jsp" %>
<div class="container">
	
	<div class="row">
	
		<div class="col-sm-6">
	
			<div class="panel panel-primary">
				
				<div class="panel-heading">
					<h4>Personal Details</h4>
				</div>
			
				<div class="panel-body">
					<div class="text-center">
						<%-- <h3>Name : <strong>${registerModel.user.firstName} ${registerModel.user.lastName}</strong></h3>
						<h4>Email : <strong>${registerModel.user.email}</strong></h4>
						<h4>Contact : <strong>${registerModel.user.contactNumber}</strong></h4>
						<h4>Role : <strong>${registerModel.user.role}</strong></h4> --%>
						<h4>Name: <strong>${registerModel.user.firstName} ${registerModel.user.lastName}</strong>,</h4>
						<h4>Email: <strong>${registerModel.user.email}</strong>,</h4>
						<h4>Contact No.: <strong>${registerModel.user.contactNumber}</strong>,</h4>
						<h4>Role: <strong>${registerModel.user.role}</strong></h4>
						
						<p>
							<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit Personal</a>
						</p>
					</div>
				</div>
			
			</div>
					
		
		</div>
		
		<div class="col-sm-6">
		
			<div class="panel panel-primary">
				
				<div class="panel-heading">
					<h4>address Address</h4>
				</div>
			
				<div class="panel-body">
					<div class="text-center">
						<%-- <p>${registerModel.address.addressLineOne}, </p>
						<p>${registerModel.address.addressLineTwo}, </p>
						<p>${registerModel.address.city} -  ${registerModel.address.postalCode}, </p>
						<p>${registerModel.address.state}</p>
						<p>${registerModel.address.country}</p> --%>
						
						<p>${registerModel.address.addressLineOne}, </p>
						<p>${registerModel.address.addressLineTwo}, </p>
						<p>${registerModel.address.city} - ${registerModel.address.postalCode} ,</p>
						<p>${registerModel.address.state}, </p>
						<p>${registerModel.address.country} </p>
						<p>
							<a href="${flowExecutionUrl}&_eventId_address" class="btn btn-primary">Edit Address</a>
						</p>
					</div>
				</div>
			
			</div>
		
		</div>
	
	</div>
	
	<div class="row">
		
		<div class="col-sm-4 col-sm-offset-4">
			
			<div class="text-center">
				
				<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-lg btn-primary">Confirm</a>
				
			</div>
			
		</div>
		
	</div>

</div>
<%@include file="../flows-shared/footer.jsp" %>