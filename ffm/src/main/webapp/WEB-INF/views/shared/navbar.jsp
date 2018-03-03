<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#mynavbar">
				<span class="glyphicon glyphicon-list"></span>
			</button>
			<a class="navbar-brand" href="${contextRoot}/home"><img
				src="${img}/logo.PNG" class="img-responsive default-img"></a>
		</div>
		<div class="collapse navbar-collapse" id="mynavbar">
			<ul class="nav navbar-nav navbar-left">
				<li id="home"><a href="${contextRoot}/home">Home</a></li>
				<li id="viewPost"><a href="${contextRoot}/show/all/post">View
						Post</a></li>
				<li id="about"><a href="${contextRoot}/about">how it works</a></li>
				<li id="contact"><a href="${contextRoot}/contact">Contact
						Us</a></li>
				<security:authorize access="hasAuthority('ADMIN')">
					<li id="manageProduct"><a href="${contextRoot}/manage/post">Manage
							Product</a></li>
				</security:authorize >
				
				<security:authorize access="isAuthenticated()">
				<li id="userProfile"><a href="${contextRoot}/show/${userModel.id}/user"/>Profile
							</a></li>
				
				</security:authorize>
					
				
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="isAnonymous()">
					<li id="login"><a href="${contextRoot}/login">Login</a></li>
					<li id="signup"><a href="${contextRoot}/register">Sign Up</a></li>
				</security:authorize>
				
				<security:authorize access="isAuthenticated()">
					<li class="dropdown" id="userModel">
						<a class="btn btn-default dropdown-toggle" href="${contextRoot}/show/${userModel.id}/user"  
							id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="true"> ${userModel.fullName} <span class="caret"></span>
						</a>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li id="userProfile"><a href="${contextRoot}/show/${userModel.id}/user"/>${userModel.fullName}
							</a></li>
							<security:authorize access="hasAuthority('USER')">
								<li id="apply">
								<a href="${contextRoot}/apply/show"> 
									<span class="glyphicon glyphicon-shopping-cart">
									</span>&#160;<span class="badge">test</span> - &#8377; test apply
								</a>
								</li>
								<li role="separator" class="divider"></li>
							</security:authorize>
							<li id="logout"><a href="${contextRoot}/logout">Logout</a></li>
						</ul>
					</li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>


<!-- statr modal-->
<div class="modal fade" role="dialog" id="mymodal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">Sign In</h3>
			</div>
			<div class="modal-body" id="default-signin-modal">
				<form action="#">
					<div class="form-group">
						<label for="uname_modal">Username</label> <input type="text"
							id="uname_modal" class="form-control"
							placeholder="Enter Username">
					</div>
					<div class="form-group">
						<label for="upass_modal">Password <span
							class="glyphicon glyphicon-eye-close default-eye"></span></label> <input
							type="password" id="upass_modal"
							class="default-pass form-control" placeholder="Enter Password">
					</div>
					<button type="button" class="btn btn-default" id="b_signin_modal">sign
						in</button>
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">close</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="modal-signup" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">Create Account</h3>
			</div>
			<div class="modal-body" id="default-signup-modal">
				<form action="#">
					<div class="form-group">
						<label for="username">Username</label> <input type="text"
							id="username" class="form-control" placeholder="Username">
					</div>
					<div class="form-group">
						<label for="email">Email Id</label> <input type="text" id="email"
							class="form-control" placeholder="Email Address">
					</div>
					<div class="form-group">
						<label for="mobile">Mobile No.</label> <input type="text"
							id="mobile" class="form-control" placeholder="Mobile No.">
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="text"
							id="password" class="form-control" placeholder="Password">
					</div>
					<div class="form-group">
						<label for="repassword">Confirm Password</label> <input
							type="text" id="repassword" class="form-control"
							placeholder="Confirm Password">
					</div>
					<hr>
					<h4>captch code</h4>
					<button class="btn btn-default" id="btn-signup">Create
						Account</button>
					<button class="btn btn-default" type="reset">Reset</button>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" data-dismiss="modal" class="btn btn-default">close</button>
			</div>
		</div>
	</div>
</div>
<!--end modal-->