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
						<li>All Products</li>
					</ol>
				</div>
			</div>
			<hr>
			<table class="table table-striped table-responsive" id="dataTable">
				<thead>
					<tr>
						<th>Image</th>
						<th>Title</th>
						<th>Category</th>
						<th>Posted By</th>
						<th>View</th>
						<th>Apply</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
					
				<tfoot>
					<tr>
						<th>Image</th>
						<th>Title</th>
						<th>Category</th>
						<th>Posted By</th>
						<th>View</th>
						<th>Apply</th>
					</tr>
				</tfoot>
			</table>
			
		</div>
	</div>

</div>

