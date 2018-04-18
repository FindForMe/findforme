


<div class="container" ng-controller="postCtrl">
	<div class="row">
		<!-- sidebar -->
		<%-- <div class="col-md-3">
			<%@include file="./shared/sidebar.jsp" %>
		</div> --%>
		<!-- content -->
		<div class="col-md-10 col-md-offset-1">
		
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
			<div class="panel panel-primary">
				<div class="panel-heading">
					<p >
						<span class="glyphicon glyphicon-search"></span><input type="text" class="form-control" placeholder="search" ng-model="textFilter" >
					</p>
				</div>
				<div class="panel-body">
					<div class="post-container" ng-repeat="x in obj | filter:textFilter" >
					<div class="post-img">
						<div id="img"><img alt="{{x.code}}" ></div>
					</div>
					<div class="post-data">
						<div class="post-title"><h4>{{x.title}}</h4></div>
						<div class="post-description">{{x.description}}</div>
						<div class="post-other">
							<ul >
								<li>will be expire on {{x.expireDate}} *</li>
								<li>view {{x.view}} *</li>
								
							</ul>
						</div>
					</div>
					<div class="post-footer">
						<!-- <div class="post-duration">duration</div>
						<div class="post-view">view count</div> -->
						<!-- <div class="post-apply"> -->
							<button type="button" class="btn btn-primary" >select</button>
					</div>
				</div>
				</div>
				<div class="panel-footer">
				
				</div>
			</div>
				
		</div>
	</div>
</div>