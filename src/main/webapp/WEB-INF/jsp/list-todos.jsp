<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset='utf-8'>
<title>Todos</title>
</head>

<body>

	<nav role="navigation" class="navbar navbar-default">
		<div class="">
			<a href="http://www.in28minutes.com" class="navbar-brand">in28Minutes</a>
		</div>
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/login">Home</a></li>
				<li><a href="/list-todos">Todos</a></li>

			</ul>
		</div>
	</nav>
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
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>

</html>