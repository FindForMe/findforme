<div class="container">
	<div class="row">
		<!-- sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp" %>
		</div>
		<!-- content -->
		<div class="col-md-9">
		
			<!-- Added breadcrumb component -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllPost == true }">
						<script>
							window.categoryId = '';	
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Post</li>
						</ol>
					</c:if>
					
					<c:if test="${userClickCategoryPost == true }">
						<script>
							window.categoryId = ${category.id}	
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>
			<table class="table table-responsive" id="dataTable">
				<thead>
					<tr>
						<th>Image</th>
						<th>Title</th>
						<th>Description</th>
						<th>Posted By</th>
						<th>Date</th>
						<th>View</th>
						<th>Apply</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
				<!-- <tfoot>
					<tr>
						<th>Image</th>
						<th>Title</th>
						<th>Description</th>
						<th>Posted By</th>
						<th>Date</th>
						<th>View</th>
						<th>Apply</th>
					</tr>
				</tfoot> -->
			</table>
		</div>
	</div>
</div>