<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>Hello ${name} your todos are:</h1>
	<table class="table table-striped">
		<caption>Listing</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Date</th>
				<th>Done?</th>
				<th>Update</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="itemTodo">
				<tr>
					<td>${itemTodo.desc}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${itemTodo.targetDate}" /></td>
					<td>${itemTodo.done}</td>
					<td><a class="btn btn-warning"
						href="/update-todo?id=${itemTodo.id}">Update</a></td>
					<td><a class="btn btn-warning"
						href="/delete-todo?id=${itemTodo.id}">Delete</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<br />
	<div>
		<a class="btn btn-default" href="/add-todo">Clic Here to Add todo</a>
	</div>
</div>

<%@ include file="common/footer.jspf"%>