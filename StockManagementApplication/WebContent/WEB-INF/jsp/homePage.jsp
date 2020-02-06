<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Welcome to home page</h1>
<h2  style="font-style: italic; color: blue; " align="right"> ${udto.getFullname() } </h2>
<h4 align="right">
<button><a href="addproduct" >Add Product</a></button>
<button><a href="view">View Product</a></button>
<button><a href="logout">Logout</a></button>
</h4>

<div align="right">
<form action="SearchProduct">
<input type="text" name="product" placeholder="Enter product name" />
<input type="submit" value="Search" />
</form>
</div>
<hr>
<div style="color: green;"> ${add }</div>
<div style="color: green;"> ${cart }</div>
<div style="color: green;"> ${delete }</div>
<div style="color: green;"> ${update }</div>
<div style="color: red;">${error }</div>


</body>
</html>