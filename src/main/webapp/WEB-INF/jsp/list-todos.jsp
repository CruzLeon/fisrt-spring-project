<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset='utf-8'>
<title>Todos</title>
</head>

<body>
	<div class="container">
		<h1>Hello ${name} your todos are:</h1>
		<table class="table table-striped">
			<caption>Listing</caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>Date</th>
					<th>Done?</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="itemTodo">
					<tr>
						<td>${itemTodo.desc}</td>
						<td>${itemTodo.targetDate}</td>
						<td>${itemTodo.done}</td>
						<td><div>
								<a class="btn btn-warning" href="/delete-todo?id=${itemTodo.id}">Delete</a>
							</div>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<br />
		<div>
			<a class="btn btn-default" href="/add-todo">Clic Here to Add todo</a>
		</div>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>

</html>