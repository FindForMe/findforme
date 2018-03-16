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
				<li id="profileEdit"><a href="${contextRoot}/profile">Edit Profile</a></li>
				
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


