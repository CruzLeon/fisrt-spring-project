<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>

<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Add todo</title>

</head>
<body>
	<div class="container">
		<h2>Hello ${name} add your todos</h2>
		<br>

		<form:form action="" method="post" modelAttribute="todo">
			<fieldset class="form-group">
				<form:hidden path="id" />
				<form:label path="desc">Description:</form:label>
				<form:input path="desc" type="text" name="description"
					class="form-control" required="required" />
				<form:errors path="desc" cssClass="text-warning" />
				<form:label path="targetDate">Target Date</form:label>
				<form:input path="targetDate" type="text" name="targetDate"
					class="form-control" required="required" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>
			<input type="submit" value="Add" class="btn btn-success">
		</form:form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>

	<script>
		$('#targetDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>

</body>

</html>