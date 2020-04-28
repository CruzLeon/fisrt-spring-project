<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	Bienvenido<br /> Ingrese sus credenciales <br /> ${errorMessage}
	<form action="" method="post">
		<label for="Pname">Nombre:</label> 
		<input id="Pname" type="text"
			name="name"> 
		<label for="Ppass">Pass:</label> 
		<input
			id="Ppass" type="text" name="password">
		<input type="submit"
			value="Save" class="btn btn-success">
	</form>

</div>
<%@ include file="common/footer.jspf"%>