<div class="container" ng-controller="postCtrl">
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
			this is test :- {{test}}
				<div class="post-container" >
					<div class="post-img">
						<div id="img"><img alt="img" ></div>
					</div>
					<div class="post-data">
						<div class="post-title">title</div>
						<div class="post-description">description</div>
						<div class="post-other">
							<ul >
								<li>duraion</li>
								<li>view</li>
							</ul>
						</div>
					</div>
					<div class="post-footer">
						<!-- <div class="post-duration">duration</div>
						<div class="post-view">view count</div> -->
						<!-- <div class="post-apply"> -->
							<button type="button" class="btn btn-primary">apply</button>
					</div>
				</div>
		</div>
	</div>
</div>