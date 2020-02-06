<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>
<h1 align="center">Forget Password</h1>
<h4 align="right">
<button><a href="login">Login</a></button>
<button><a href="registeration">Registeration</a></button>
</h4>
<hr>
<div style="color: red;">${forget }</div>
<br>
<br>
<br>
<div align="center">
<fieldset>
<style>
fieldset{
width: 350px;
height: 215px;
}
</style>

<form action="ForgetPassword" method="post" style="margin-top: 20px; margin-bottom: 30px;" >
<input type="email" name="email" placeholder="Enter email" required="required" style="width: 250px; height: 20px" /><br><br>
<select name='question' id='question' required="required" style="width: 250px; height: 30px" >

		<option value=''selected disabled>Security Question</option>
		<option value="1">What's your fav color</option>
		<option value="2">What's your fav pet</option>
		<option value="3">What's your fav fruit</option>
		<option value="4">What's your fav teacher</option>
		</select><br><br>
		<input type="text" name="answer" placeholder="Enter answer" required="required" style="width: 250px; height: 20px" /><br><br>
		<input type="submit" value="Enter" style="width: 160px; height: 40px" />
		
</form>
</fieldset>
</div>
</body>
</html>