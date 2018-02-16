<%@taglib prefix = "sf" uri="http://www.springframework.org/tags/form" %>


<div class="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Update Post</h4>
				</div>
				<div class="panel-body">
					<sf:form action="${contextRoot}/manage/post" method="post" modelAttribute = "post">
						<div class="form-group">
							<label for="title">Title</label>
							<sf:input path="title" id="title" class="form-control"/>
						</div>
						<div class="form-group">
							<label for="description">Description</label>
							<sf:input path="description" class="form-control"/>
						</div>
						<div class="form-grpup">
							<label for="expireDate">Post Expire Date</label> 
							<sf:input path="expireDate" id="expireDate" class="form-control"/>
						</div> 
						<div class="form-group">
							<label for="categoryId">Select Category</label>
							<sf:select path="categoryId" items="${categories}" itemLable="name" itemValue="id" class="form-control"/> 
						</div>
						<sf:hidden path="active"/>
						<sf:hidden path="created"/>
						<sf:hidden path="rowId"/>
						<sf:hidden path="view"/>
						<sf:hidden path="apply"/>
						
						<sf:button class="btn btn-defualt" type="submit">Submit</sf:button>
					</sf:form>
				</div>
			
			</div>
			
			<sf:form modelAttribute = "postManage" >
				
			
			</sf:form>
		</div>
	</div>
</div>