<div class="list-group">

<p class="lead">Find For Me</p>
	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/post" class="list-group-item" id="a_${category.name}">${category.name}</a>
		
	</c:forEach>
</div>