<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Login Page</h1>
<h4 align="right">
<button><a href="registeration">Registeration</a></button>
<button><a href="forget">Forget Password</a></button>
</h4>
<hr>
<div style="color: green;"> ${register }</div>
<div style="color: red;">${login }</div>
<div style="color: green;">${pass }</div>
<div style="color: red;">${msg }</div>
<div style="color: green;">${logout }</div>
<br>
<br>
<br>


<div align="center">
<fieldset>
<style>
fieldset{
width: 350px;
height: 165px;
}
</style>

<form action="LogionForm" method="post" style="margin-top: 20px; margin-bottom: 30px;" >

<input type="email" name="email" placeholder="Enter email" required="required" style="width: 250px; height: 20px" /><br><br>
<input type="password" name="password" placeholder="Enter password" required="required" style="width: 250px; height: 20px" /><br><br>
<input type="submit" value="Login" style="width: 160px; height: 40px" />

</form>
</fieldset>
</div>


</body>
</html>