<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Registeration Form</h1>
<h4 align="right">
<button><a href="login">Login</a></button>
<button><a href="forget">Forget Password</a></button>
</h4>
<hr>
<div style="color: red;"> ${fail }</div>
<br>
<br>
<br>
<div align="center">
<fieldset>
<style>
fieldset{
width: 350px;
height: 300px;
}
</style>

 <form action="RegisterationForm" method="post" style="margin-top: 30px; margin-bottom: 30px;">
 

<input type="text" name="fullname" placeholder="Enter Fullname" required="required" style="width: 250px; height: 20px" /><br><br>
<input type="text" name="address" placeholder="Enter address" required="required" style="width: 250px; height: 20px" /><br><br>
<input type="email" name="email" placeholder="Enter email" required="required" style="width: 250px; height: 20px" /><br><br>
<input type="password" name="password" placeholder="Enter password" required="required" style="width: 250px; height: 20px" /><br><br>
<input type="submit" value="registeration" style="width: 160px; height: 40px" />
</form>

</fieldset>
</div>

</body>
</html>