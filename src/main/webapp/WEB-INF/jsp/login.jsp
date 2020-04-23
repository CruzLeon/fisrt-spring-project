<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Login Page</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <script src='main.js'></script>
</head>

<body>
    Bienvenido<br />
    Ingrese sus credenciales <br/>
	${errorMessage}
    <form action="" method="post">
        <label for="Pname">Nombre:</label>
        <input id="Pname" type="text" name="name">
        <label for="Pother">Other:</label>
        <input id="Pother" type="text" name="other">
        <label for="Ppass">Pass:</label>        
        <input id="Ppass" type="text" name="password">
        <input type="submit" value="Save">
    </form>
</body>

</html>