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
<hr><br><br><br>
<div align="center"> 
<table border="1px"  style="text-align: center;">
        <tr>
        	<th >Name</th>
            <th>Company</th>
            <th>Category</th>
            <th>Price</th>
            <th>Add to cart</th>
        </tr>
		<c:forEach var="elist" items="${plist }">
        <tr>
        	<td>${elist.getPname() }</td>
            <td>${elist.getCompany() }</td>
            <td>${elist.getPcategory() }</td>
            <td>${elist.getPrice() }</td>
            <td><a href="cartPage?id=+${elist.getPid() }+">Add to cart</a></td>
        </tr>
		</c:forEach>        
    	</table>
    	</div>
    	</body>
</html>