<div class="container">

	<!-- Breadcrumb -->
	<div class="row">
		
		<div class="col-xs-12">
		
			
			<ol class="breadcrumb">
			
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/posts">posts</a></li>
				<li class="active">${post.title}</li>
			
			</ol>
		
		
		</div>
	
	
	</div>
	
	
	<div class="row">
	
		<!-- Display the post image -->
		<div class="col-xs-12 col-sm-4">
		
			<div class="thumbnail">
							
				<img src="${img}/${post.code}.jpg" class="img img-responsive"/>
						
			</div>
		
		</div>
	
		
		<!-- Display the post description -->	
		<div class="col-xs-12 col-sm-8">
		
			<h3>${post.title}</h3>
			<hr/>
			
			<p>${post.description}</p>
			<hr/>
			<p>Total view : ${post.view}</p>
			<hr/>
	
			
			<security:authorize access="isAnonymous() or hasAuthority('USER')">	

					
				
				<a href="${contextRoot}/apply/add/${post.id}/post" class="btn btn-success">
				<span class="glyphicon glyphicon-shopping-ok"></span> Apply</a>
				
				
		
			</security:authorize>
			
			
			<security:authorize access="hasAuthority('ADMIN')">
				<a href="${contextRoot}/manage/${post.id}/post" class="btn btn-success">
				<span class="glyphicon glyphicon-pencil"></span> Edit</a>
			</security:authorize>	
						
			

			<a href="${contextRoot}/show/all/post" class="btn btn-warning">
				Show All Post</a>
					
		</div>

	
	</div>

</div>