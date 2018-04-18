<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	
<!-- Header -->
	<header id="home">
		<!-- Background Image -->
		 <div class="bg-img none" style="background-image: url('${img}/background1.jpg');">
			<div class="overlay"></div>
		</div> 
		<!-- /Background Image -->

<!-- Nav -->
		<nav id="nav" class="navbar nav-transparent">
			<div class="container">
				<div class="navbar-header">
				<!-- <button type="button" class="pull-left navbar-toggle" data-toggle="slide-collapse"
					data-target="#mynavbar" aria-expanded="false" aria-controls="navbar">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button> -->
				<a class="navbar-brand" href="${contextRoot}/home">
				<img src="${img}/logo.png" class="logo">
				<%-- <img class="logo-alt" src="${img}/logo-alt.png" alt="logo"> --%>
				</a>
				
				<!-- Collapse nav button -->
						<div class="nav-collapse">
							<span></span>
						</div>
				<!-- /Collapse nav button -->
			</div>
		<!-- <div class="collapse navbar-collapse" id="mynavbar"> -->
			<ul class="main-nav nav navbar-nav navbar-right">
				<li ><a href="${contextRoot}/home">Home</a></li>
				<li ><a href="${contextRoot}/show/all/post">ViewPost</a></li>
				<li ><a href="${contextRoot}/about">how it works</a></li>
				<li ><a href="${contextRoot}/contact">Contact
						Us</a></li>
				<security:authorize access="hasAuthority('ADMIN')">
					<li id="managePost"><a href="${contextRoot}/manage/post">Manage
							Post</a></li>
				</security:authorize >
				
				<security:authorize access="isAuthenticated()">
				<li id="userProfile"><a href="${contextRoot}/show/${userModel.id}/user"/>Profile
							</a></li>
				
				</security:authorize>
				<li id="profileEdit"><a href="${contextRoot}/profile">Edit Profile</a></li>
			<!-- 	
			</ul>

			<ul class="main-nav nav navbar-nav navbar-right"> -->
				<security:authorize access="isAnonymous()">
					<li ><a href="${contextRoot}/login">Login</a></li>
					<li ><a href="${contextRoot}/register">Sign Up</a></li>
				</security:authorize>
				
				<security:authorize access="isAuthenticated()">
					<li class="has-dropdown" id="userModel">
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
	<!-- </div> -->
</nav>
<!-- home wrapper -->
		<div class="home-wrapper none">
			<div class="container">
				<div class="row">

					<!-- home content -->
					<div class="col-md-10 col-md-offset-1">
						<div class="home-content">
							<h1 class="white-text">We Are Creative Agency</h1>
							<p class="white-text">Morbi mattis felis at nunc. Duis viverra diam non justo. In nisl. Nullam sit amet magna in magna gravida vehicula. Mauris tincidunt sem sed arcu. Nunc posuere.
							</p>
							<button class="white-btn">Get Started!</button>
							<button class="main-btn">Learn more</button>
						</div>
					</div>
					<!-- /home content -->

				</div>
			</div>
		</div>
		<!-- /home wrapper -->

	</header>
	<!-- /Header -->


	
