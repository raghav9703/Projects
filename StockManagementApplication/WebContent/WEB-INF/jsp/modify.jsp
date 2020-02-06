<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
<h1 align="center">Product after search</h1>
<h4 align="right">
<button><a href="addproduct" >Add Product</a></button>
<button><a href="view">View Product</a></button>
<button><a href="logout">Logout</a></button>
</h4>
<hr>

<br><br>


<div align="center">
<fieldset>
<style>
fieldset{
width: 350px;
height: 400px;
}
</style>

<form action="modifyProduct" method="post" style="margin-top: 20px">
Name:<br><input type="text" name="name" value="${pdto.getPname() }" style="width: 250px; height: 20px" /><br><br>
Category:<br><input type="text" name="category" value="${pdto.getPcategory()}" style="width: 250px; height: 20px" /><br><br>
Company:<br><input type="text" name="company" value="${pdto.getCompany()}" style="width: 250px; height: 20px" /><br><br>
Price:<br><input type="text" name="price" value="${pdto.getPrice()}" style="width: 250px; height: 20px" /><br><br>
Quantity:<br><input type="text" name="quantity" value="${pdto.getQuantity()}" style="width: 250px; height: 20px" /><br><br>
<input type="submit" value="submit" style="width: 160px; height: 40px" /><br>
</form>
</fieldset>
</div>
 	</body>
</html>