<div class="container">
	<div class="row">
	<!-- include side bar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp" %>
		</div>
		<!-- products main content -->
		<div class="col-md-9">
			<!-- Breadcrumb -->
			<div class="row">
				<div class="col-sm-12">
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/index">Home</a></li>
						<li><a href="${contextRoot}/show/all/products">All Products</a></li>
						<li>${category.name}</li>
					
					</ol>
				</div>
			
			</div>
		</div>
	</div>

</div>

