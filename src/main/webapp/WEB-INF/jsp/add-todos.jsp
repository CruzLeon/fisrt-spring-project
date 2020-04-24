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

		<form action="" method="post">
			<fieldset class="form-group">
				<label for="AddDesc">Description:</label> 
				<input id="AddDesc"	type="text" name="description" class="form-control" required="required"> 
				
			</fieldset>
			<input type="submit" value="Add" class="btn btn-success">
		</form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>