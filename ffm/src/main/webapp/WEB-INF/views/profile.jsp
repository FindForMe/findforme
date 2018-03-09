<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@include file="./shared/navbar.jsp" %>

	<div class="container">
	
	<c:if test="${not empty message}">
		<div class="row">
			<div class="col-xs-12 col-md-offset-2 col-md-8">
				<div class="alert alert-info alert-dismissable ">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</div>
	</c:if>
	
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
												
									<img src="${contextRoot}/resources/img/${user.id}.jpg" class="img img-responsive imgDataTable" alt="Profile Image"/>
											
								</div>
								
							</div>
							<div class="col-xs-12 col-sm-8">
							
								<p>${user.firstName} ${user.lastName}</p>
								<p>${user.email}</p>
								<p>${user.contactNumber}</p>
							
								<hr/>
								<div class="profileEditbtn">
									<button type="button" class="btn btn-primary" data-target="#personalEditModal" data-toggle="modal"><span class="glyphicon glyphicon-pencil"></span></button>
								</div>
							
							</div>
							
					
						</div>
						<hr>
						<!-- Address -->
						<div class="row">
							<div class="col-xs-12 col-sm-6">
					
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
								<div class="profileEditbtn">
									<button type="button" class="btn btn-primary" data-target="#pAddressEditModal" data-toggle="modal"><span class="glyphicon glyphicon-pencil"></span></button>
								</div>
								
							</div>
							<div class="col-xs-12 col-sm-6">
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
								<div class="profileEditbtn">
									<button type="button" class="btn btn-primary" data-target="#cAddressEditModal" data-toggle="modal"><span class="glyphicon glyphicon-pencil"></span></button>
								</div>
							</div>
						</div><hr/>
						
						<!-- Education Details -->
						
						<div class="row">
							<div class="col-xs-12">
								<h4>Education Details</h4>
							</div>
							<hr/>
							
							<c:if test = "${education.id != 0}">
								<div class="col-xs-12 col-sm-4">
									<h5>Graduation Details</h5><hr/>
									<p>${education.graduation}</p>
									<p>${education.graduationOther}</p>
									<p>${education.graduationYear}</p>
									<p>${education.graduationPercentage}</p>
								</div>
								<div class="col-xs-12 col-sm-4">
									<h5>Intermediate Details</h5><hr/>
									<p>${education.intermediate}</p>
									<p>${education.intermediateYear}</p>
									<p>${education.intermediatePercentage}</p>
								</div>
								<div class="col-xs-12 col-sm-4">
									<h5>HighSchool Details</h5><hr/>
									<p>${education.highSchool}</p>
									<p>${education.highSchoolYear}</p>
									<p>${education.highSchoolPercentage}</p>
								</div>	
							</c:if>
							<c:if test = "${education.id == 0}">
								<p>Education is not updated..</p>
							</c:if>
							<hr>
								<div class="profileEditbtn">
									<button type="button" class="btn btn-primary" data-target="#educationEditModal" data-toggle="modal"><span class="glyphicon glyphicon-pencil"></span></button>
								</div>
						</div><hr/>
						<!-- Experience Details -->
						<div class="row">
							<div class="col-xs-12 col-sm-6">
								<h4>Experience</h4><hr/>
								<c:if test = "${not empty experienceList}">
								<c:forEach var="experience" items="${experienceList}">
									<p>Total Experience of ${experience.total}</p>
									<p>${experience.description}</p>
									<p>${experience.fromDate} - ${experience.toDate}</p>
									<p>${experience.other}</p>
									<hr/>
									<a href="${contextRoot}/update/${userModel.id}/experience/${experience.id}/delete"><span class="glyphicon glyphicon-remove"></span></a>
									
								</c:forEach>
									
									
								</c:if>
								<c:if test = "${empty experienceList}">
									<p>Experience is not updated..</p>
								</c:if>
								<hr>
								<div class="profileEditbtn">
									<button type="button" class="btn btn-primary" data-target="#experienceEditModal" data-toggle="modal"><span class="glyphicon glyphicon-pencil"></span></button>
								</div>
								
							</div>
						
						</div><hr/>
						
						<!-- Company details -->
						
						<div class="row">
							<div class="col-xs-12 col-sm-6">
					
								<h4>Company Details</h4><hr/>
								<c:if test = "${not empty companyList}">
									<c:forEach var="company" items="${companyList}">
										<p>${company.name}"</p>
										<p>${company.description}</p>
										<p>${company.address}</p>
										<hr/>
										<a href="${contextRoot}/update/${userModel.id}/company/${company.id}/delete"><span class="glyphicon glyphicon-remove"></span></a>
									</c:forEach>
									
								</c:if>
								<c:if test = "${empty companyList}">
									<p>No Details Available</p>
								</c:if>
								<hr>
								<div class="profileEditbtn">
									<button type="button" class="btn btn-primary" data-target="#companyEditModal" data-toggle="modal"><span class="glyphicon glyphicon-pencil"></span></button>
								</div>
								
							</div>
						
						</div><hr/>
					</div>
					<div class="panel-footer">
					</div>
				</div>	
			
			
			</div>
		
		</div>
	</div>

	
	<!-- Personal Modal -->
	
	<div class="modal fade" role="dialog" id="personalEditModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Edit Personal Info</h4>
				</div>
				<sf:form action="${contextRoot}/update/${userModel.id}/personal" method="post"
						modelAttribute="user"
							class="form-horizontal"
							id="updatePersonalForm"
							enctype="multipart/form-data"
						>
					<div class="modal-body">
					
							<div class="form-group">
								<label class="control-label col-md-4">First Name</label>
								<div class="col-md-8">
									<sf:input type="text" path="firstName" class="form-control" value="${user.firstName}"
										placeholder="First Name" />
									<sf:errors path="firstName" cssClass="help-block" element="em"/> 
								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-md-4">Last Name</label>
								<div class="col-md-8">
									<sf:input type="text" path="lastName" class="form-control" value="${user.lastName}"
										placeholder="Last Name" />
									<sf:errors path="lastName" cssClass="help-block" element="em"/> 
								</div>
							</div>
						
							<div class="form-group">
								<label class="control-label col-md-4">Email</label>
								<div class="col-md-8">
									<sf:input type="text" path="email" class="form-control" value="${user.email}"
										placeholder="abc@zyx.com" />
									<sf:errors path="email" cssClass="help-block" element="em"/> 									
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Contact Number</label>
								<div class="col-md-8">
									<sf:input type="text" path="contactNumber" class="form-control" value="${user.contactNumber}"
										placeholder="XXXXXXXXXX" maxlength="10" />
									<sf:errors path="contactNumber" cssClass="help-block" element="em"/> 
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4">Select Image</label>
								<div class="col-md-8">
									<sf:input type="file" path="file" class="form-control" />
								</div>
							</div>
							
							<sf:hidden path="password" />
							<sf:hidden path="id" />
							<sf:hidden path="role" />
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary">Save </button>																	 
							<button type="button" class="btn btn-warnning close" data-dissmiss="modal">Cancel</button>
						</div>
					
					</sf:form>
				
			</div>
		</div>
	
	</div>
	
		<!-- Permanent Address Modal -->
	
	<div class="modal fade" role="dialog" id="pAddressEditModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Edit Permanent Address</h4>
				</div>
				<sf:form action="${contextRoot}/update/${userModel.id}/pAddress" 
							class="form-horizontal"
							id="pAddressUpdateForm"
							method="POST"
							modelAttribute="pAddress"
						>
						
					<div class="modal-body">	
							<div class="form-group">
								<label class="control-label col-md-4" for="addressLineOne">Address Line One</label>
								<div class="col-md-8">
									<sf:input type="text" path="addressLineOne" class="form-control" value="${pAddress.addressLineOne }"
										placeholder="Enter Address Line One" />
									<sf:errors path="addressLineOne" cssClass="help-block" element="em"/> 
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="addressLineTwo">Address Line Two</label>
								<div class="col-md-8">
									<sf:input type="text" path="addressLineTwo" class="form-control" value="${pAddress.addressLineTwo }"
										placeholder="Enter Address Line Two" />
									<sf:errors path="addressLineTwo" cssClass="help-block" element="em"/> 
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="city">City</label>
								<div class="col-md-8">
									<sf:input type="text" path="city" class="form-control" value="${pAddress.city }"
										placeholder="Enter City Name" />
									<sf:errors path="city" cssClass="help-block" element="em"/> 
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4" for="postalCode">Postal Code</label>
								<div class="col-md-8">
									<sf:input type="text" path="postalCode" class="form-control" value="${pAddress.postalCode }"
										placeholder="XXXXXX" />
									<sf:errors path="postalCode" cssClass="help-block" element="em"/> 
								</div>
							</div>							
						
							<div class="form-group">
								<label class="control-label col-md-4" for="state">State</label>
								<div class="col-md-8">
									<sf:input type="text" path="state" class="form-control" value="${pAddress.state }"
										placeholder="Enter State Name" />
									<sf:errors path="state" cssClass="help-block" element="em"/> 
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="country">Country</label>
								<div class="col-md-8">
									<sf:input type="text" path="country" class="form-control" value="${pAddress.country }"
										placeholder="Enter Country Name" />
									<sf:errors path="country" cssClass="help-block" element="em"/> 
								</div>
							</div>
							<sf:hidden path="id"/>
							<sf:hidden path="permanentAddress"/>
							<sf:hidden path="currentAddress"/>
							<sf:hidden path="userId" value="${userModel.id}"/>
							
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary">Save </button>																	 
							<button type="button" class="btn btn-warning close" data-dissmiss="modal">Cancel</button>
						</div>
					
					</sf:form>
			</div>
		</div>
	
	</div> 
	 
	
		<!--Current Address Modal -->
		
	<div class="modal fade" role="dialog" id="cAddressEditModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Edit Current Address</h4>
				</div>
				<sf:form action="${contextRoot}/update/${userModel.id}/cAddress" 
							class="form-horizontal"
							id="cAddressUpdateForm"
							method="POST"
							modelAttribute="cAddress"
						>
						
					<div class="modal-body">	
							<div class="form-group">
								<label class="control-label col-md-4" for="addressLineOne">Address Line One</label>
								<div class="col-md-8">
									<sf:input type="text" path="addressLineOne" class="form-control" value="${cAddress.addressLineOne }"
										placeholder="Enter Address Line One" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="addressLineTwo">Address Line Two</label>
								<div class="col-md-8">
									<sf:input type="text" path="addressLineTwo" class="form-control" value="${cAddress.addressLineTwo }"
										placeholder="Enter Address Line Two" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="city">City</label>
								<div class="col-md-8">
									<sf:input type="text" path="city" class="form-control" value="${cAddress.city }"
										placeholder="Enter City Name" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4" for="postalCode">Postal Code</label>
								<div class="col-md-8">
									<sf:input type="text" path="postalCode" class="form-control" value="${cAddress.postalCode }"
										placeholder="XXXXXX" />
								</div>
							</div>							
						
							<div class="form-group">
								<label class="control-label col-md-4" for="state">State</label>
								<div class="col-md-8">
									<sf:input type="text" path="state" class="form-control" value="${cAddress.state }"
										placeholder="Enter State Name" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="country">Country</label>
								<div class="col-md-8">
									<sf:input type="text" path="country" class="form-control" value="${cAddress.country }"
										placeholder="Enter Country Name" />
								</div>
							</div>
							<sf:hidden path="id"/>
							<sf:hidden path="permanentAddress"/>
							<sf:hidden path="currentAddress"/>
							<sf:hidden path="userId" value="${userModel.id}"/>
							
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary">Save </button>																	 
							<button type="button" class="btn btn-warning close" data-dissmiss="modal">Cancel</button>
						</div>
					
					</sf:form>
			</div>
		</div>
	
	</div> 
	
	<!-- Education Modal -->
	
			
	<div class="modal fade" role="dialog" id="educationEditModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Edit Education</h4>
				</div>
				<sf:form action="${contextRoot}/update/${userModel.id}/education" 
							class="form-horizontal"
							id="educationUpdateForm"
							method="POST"
							modelAttribute="education"
						>
					<div class="modal-body">	
						<div class="form-group">
						<label class="control-label col-md-4" for="graduation">Graduation</label>
							<div class="col-md-8">
								<sf:input type="text" path="graduation" class="form-control" value="${education.graduation}"
									placeholder="Enter Graduation" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="graduationOther">Graduation From</label>
							<div class="col-md-8">
								<sf:input type="text" path="graduationOther" class="form-control" value="${education.graduationOther }"
									placeholder="Enter Graduation From" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="graduationYear">Graduation Year</label>
							<div class="col-md-8">
								<sf:input type="text" path="graduationYear" class="form-control" value="${education.graduationYear}"
									placeholder="Enter City Name" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="graduationPercentage">Graduation Percentage</label>
							<div class="col-md-8">
								<sf:input type="text" path="graduationPercentage" class="form-control" value="${education.graduationPercentage}"
									placeholder="Graduation Percentage" />
							</div>
						</div>							

						<hr/>						
						<div class="form-group">
							<label class="control-label col-md-4" for="intermediate">Intermediate</label>
							<div class="col-md-8">
								<sf:input type="text" path="intermediate" class="form-control" value="${education.intermediate }"
									placeholder="Enter Intermediate Board" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="intermediateYear">Year Of Passing</label>
							<div class="col-md-8">
								<sf:input type="text" path="intermediateYear" class="form-control" value="${education.intermediateYear}"
									placeholder="Enter Passing year of Intermediate" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="intermediatePercentage"></label>
							<div class="col-md-8">
								<sf:input type="text" path="intermediatePercentage" class="form-control" value="${education.intermediatePercentage}"
									placeholder="Enter Percentage of Intermediate" />
							</div>
						</div>
						
						<hr>
						<div class="form-group">
							<label class="control-label col-md-4" for="highSchool">highSchool</label>
							<div class="col-md-8">
								<sf:input type="text" path="highSchool" class="form-control" value="${education.highSchool }"
									placeholder="Enter highSchool Board" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="highSchoolYear">Year Of Passing</label>
							<div class="col-md-8">
								<sf:input type="text" path="highSchoolYear" class="form-control" value="${education.highSchoolYear}"
									placeholder="Enter Passing year of highSchool" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="highSchoolPercentage"></label>
							<div class="col-md-8">
								<sf:input type="text" path="highSchoolPercentage" class="form-control" value="${education.highSchoolPercentage}"
									placeholder="Enter Percentage of highSchool" />
							</div>
						</div>
						
						<sf:hidden path="id"/>
						
						<sf:hidden path="userId" value="${userModel.id}"/>
						
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">Save </button>																	 
						<button type="button" class="btn btn-warning close" data-dissmiss="modal">Cancel</button>
					</div>
				</sf:form>
			</div>
		</div>
	</div> 
	
	<!-- Experience Modal -->
			
	<div class="modal fade" role="dialog" id="experienceEditModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Edit Experience</h4>
				</div>
				<sf:form action="${contextRoot}/update/${userModel.id}/experience" 
							class="form-horizontal"
							id="experienceUpdateForm"
							method="POST"
							modelAttribute="nExperience"
						>
					<div class="modal-body">	
						<div class="form-group">
						<label class="control-label col-md-4" for="total">Total Experience </label>
							<div class="col-md-8">
								<sf:input type="text" path="total" class="form-control" 
									placeholder="Enter Total Experience" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Description</label>
							<div class="col-md-8">
								<sf:input type="text" path="description" class="form-control" 
									placeholder="Enter Description" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="fromDate">From Date</label>
							<div class="col-md-8">
								<sf:input type="text" path="fromDate" class="form-control"
									placeholder="Enter From Date " />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="toDate">To Date</label>
							<div class="col-md-8">
								<sf:input type="text" path="toDate" class="form-control" 
									placeholder="Enter To Date" />
							</div>
						</div>							

						<hr/>						
						<div class="form-group">
							<label class="control-label col-md-4" for="other">Other Details</label>
							<div class="col-md-8">
								<sf:input type="text" path="other" class="form-control" 
									placeholder="Enter Other Details" />
							</div>
						</div>
						<sf:hidden path="id"/>
						<sf:hidden path="userId" value="${userModel.id}"/>
						
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">Save </button>																	 
						<button type="button" class="btn btn-warning close" data-dissmiss="modal">Cancel</button>
					</div>
				</sf:form>
			</div>
		</div>
	</div> 	
	
	<!-- Company Modal -->
			
	<div class="modal fade" role="dialog" id="companyEditModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Edit company</h4>
				</div>
				<sf:form action="${contextRoot}/update/${userModel.id}/company" 
							class="form-horizontal"
							id="companyUpdateForm"
							method="POST"
							modelAttribute="nCompany"
						>
					<div class="modal-body">	
						<div class="form-group">
						<label class="control-label col-md-4" for="name">Name </label>
							<div class="col-md-8">
								<sf:input type="text" path="name" class="form-control" 
									placeholder="Enter Comapny Name" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Description</label>
							<div class="col-md-8">
								<sf:input type="text" path="description" class="form-control" 
									placeholder="Enter Description" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="address">Address</label>
							<div class="col-md-8">
								<sf:input type="text" path="address" class="form-control"
									placeholder="Enter Address" />
							</div>
						</div>
						<sf:hidden path="id"/>
						<sf:hidden path="userId" value="${userModel.id}"/>
						
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">Save </button>																	 
						<button type="button" class="btn btn-warning close" data-dissmiss="modal">Cancel</button>
					</div>
				</sf:form>
			</div>
		</div>
	</div> 
		
	
	
<%@include file="./shared/footer.jsp"%>