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
<h1 align="center">Order details as per order</h1>
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
            <th>Total price</th>
            <th>Total price with GST</th>
        </tr>
		<c:forEach var="pdto" items="${pdto2.getOrderlist() }">
        <tr>
        	<td>${pdto2.getPname() }</td>
            <td>${pdto2.getCompany() }</td>
            <td>${pdto2.getPcategory() }</td>
            <td>${pdto2.getPrice() }</td>
            <td>${pdto.getTotalPrice() }</td>
            <td>${pdto.getTotalPriceWithGst() }</td>
        </tr>
		</c:forEach>        
    	</table>
    	</div>
    	</body>
</html>