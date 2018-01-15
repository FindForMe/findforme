<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#mynavbar">
				<span class="glyphicon glyphicon-list"></span>
			</button>
			<a class="navbar-brand" href="${contextRoot}/home"><img src="${img}/logo.PNG" class="img-responsive default-img"></a>
		</div>
		<div class="collapse navbar-collapse" id="mynavbar">
			<ul class="nav navbar-nav navbar-right">
				<li id="home"><a href="${contextRoot}/home">Home</a></li>
				<li id="listProducts">
                      <a href="${contextRoot}/show/all/products">View Products</a>
                 </li>				
				<li id="about"><a href="${contextRoot}/about">how it works</a></li>
				<li id="contact"><a href="${contextRoot}/contact">Contact Us</a></li>
				<!--</ul>
                        <ul class="nav navbar-nav navbar-right">-->
				
				<li><a data-target="#mymodal" data-toggle="modal">sign in<span
						class="glyphicon glyphicon-log-in"></span></a></li>
				<li><a data-target="#modal-signup" data-toggle="modal">sign
						up<span class="glyphicon glyphicon-user"></span>
				</a></li>
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
						<label for="uname_modal">Username</label> <input type="text" id="uname_modal"
							class="form-control" placeholder="Enter Username">
					</div>
					<div class="form-group">
						<label for="upass_modal">Password <span
							class="glyphicon glyphicon-eye-close default-eye"></span></label> <input
							type="password" id="upass_modal" class="default-pass form-control"
							placeholder="Enter Password">
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