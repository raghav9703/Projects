
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Product page</h1>
<h4 align="right">
<button><a href="view" >View Product</a></button>
<button><a href="logout">Logout</a></button>
</h4>
<hr>
<br><br><br>



<div align="center">
<fieldset>
<style>
fieldset{
width: 350px;
height: 300px;
}
</style>

<form action="AddProduct" method="post" style="margin-top: 20px">
<input type="text" name="pname" placeholder="Product Name" style="width: 250px; height: 20px"><br><br>
<input type="text" name="pcategory" placeholder="Product Category" style="width: 250px; height: 20px"><br><br>
<input type="text" name="company" placeholder="Company Name" style="width: 250px; height: 20px"><br><br>
<input type="number" name="quantity" placeholder="Enter Quantity" style="width: 250px; height: 20px"><br><br>
<input type="number" name="price" placeholder="Enter Price" style="width: 250px; height: 20px"><br><br>
<input  type="submit" value="Add" style="width: 160px; height: 40px"><br>
</form>
</fieldset>
</div>
</body>
</html>