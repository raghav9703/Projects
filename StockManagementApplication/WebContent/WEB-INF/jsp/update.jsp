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
<button><a href="logout">Logout</a></button>
</h4>
<hr>

<br><br>
<div align="center">
<table border="1px"  style="text-align: center;">
        <tr>
        	<th>Id</th>
        	<th >Name</th>
            <th>Company</th>
            <th>Category</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Add to Cart</th>
            <th>Modify</th>
            <th>Delete</th>
        </tr>
		<c:forEach var="elist" items="${plist }">
        <tr>
        	<td>${elist.getPid() }</td>
        	<td>${elist.getPname() }</td>
            <td>${elist.getCompany() }</td>
            <td>${elist.getPcategory() }</td>
            <td>${elist.getQuantity() }</td>
            <td>${elist.getPrice() }</td>
            <td><a href="cartPage?id=+${elist.getPid() }+">Add to cart</a></td>
            <td><a href="modify?id=+${elist.getPid() }+">Update</a></td>
            <td><a href="delete?id=+${elist.getPid() }+">Delete</a></td>
            
        </tr>
		</c:forEach>        
    	</table>
    	</div>
    	</body>
</html>