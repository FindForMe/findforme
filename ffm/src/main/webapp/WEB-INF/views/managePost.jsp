<%@taglib prefix = "sf" uri="http://www.springframework.org/tags/form" %>


<div class="container">

	<c:if test="${not empty message}">
		<div class="row">
			<div class="col-xs-12 col-md-offset-2 col-md-8">
				<div class="alert alert-info alert-dismissable ">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</div>
	</c:if>
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Update Post</h4>
				</div>
				<div class="panel-body">
					<sf:form action="${contextRoot}/manage/post" method="post" modelAttribute = "post" enctype="multipart/form-data">
						<div class="form-group">
							<label for="title">Title</label>
							<sf:input type="text" path="title" id="title" class="form-control"/>
							<sf:errors path="title" cssClass="help-block" element="em"/>
							
						</div>
						<div class="form-group">
							<label for="description">Description</label>
							<sf:textarea path="description" class="form-control"/>
							<sf:errors path="description" cssClass="help-block" element="em"/> 
						</div>
						<div class="form-grpup">
							<label for="postAddress">Address</label> 
							<sf:input  path="address" id="postAddress" class="form-control"/>
							<sf:errors path="address" cssClass="help-block" element="em"/> 
						</div> 
						<div class="form-grpup">
							<label for="expireDate">Post Expire Date</label> 
							<sf:input  path="expireDate" id="expireDate" class="form-control"/>
							<sf:errors path="expireDate" cssClass="help-block" element="em"/> 
						</div> 
						
						<div class="form-group">
							<label for="file">Select File</label>
							<sf:input type="file" id="file" path="file" class="form-control"/>
						</div>
						<div class="form-group">
							<label for="categoryId">Select Category</label>
							<sf:select path="categoryId" items="${categories}" itemLabel="name" itemValue="id" class="form-control"/> 
							<sf:errors path="categoryId" cssClass="help-block" element="em"/> 
						</div>
						<div class="text-right">
							<sf:hidden path="id"/>
							<sf:hidden path="code"/>
							<sf:hidden path="active"/>
							<sf:hidden path="created"/>
							<sf:hidden path="rowId"/>
							<sf:hidden path="view"/>
							<sf:hidden path="apply"/>
							
						</div>
						<button type="button" class="btn btn-primary" data-target="#categoryModal" data-toggle="modal">Add New Category</button>
						<sf:button class="btn btn-defualt" type="submit">Submit</sf:button>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Category Modal -->
<div class="modal fade" id="categoryModal" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">Add New Category</h3>
			</div>
			<div class="modal-body">
					
			<sf:form id="categoryForm" class="form-horizontal" modelAttribute="category" action="${contextRoot}/manage/category" method="POST">
	        	
       			<div class="form-group">
					<label class="control-label col-md-4">Name</label>
					<div class="col-md-8 validate">
						<sf:input type="text" path="name" class="form-control"
							placeholder="Category Name" /> 
					</div>
				</div>
       			
       			<div class="form-group">				
					<label class="control-label col-md-4">Description</label>
					<div class="col-md-8 validate">
						<sf:textarea path="description" class="form-control"
							placeholder="Enter category description here!" /> 
					</div>
				</div>	        	        
	        	<sf:hidden path="active"/>
				<sf:hidden path="imgURL"/>
	        
				<div class="form-group">				
					<div class="col-md-offset-4 col-md-4">					
						<input type="submit" name="submit" value="Save" class="btn btn-primary"/>						
					</div>
				</div>
					        
	        </sf:form>
				
			</div>
		</div>
	</div>
</div>
