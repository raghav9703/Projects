<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Sentbox</h1> 
<h4 align="right">
<button ><a href="inbox">Inbox</a></button>
<button><a href="draft">Draft</a></button>
<button><a href="compose">Compose</a></button>
<button><a href="deletem">DeletedMails</a></button>
<button><a href="change">ChangePassword</a></button>
<button><a href="logout">Log Out</a></button>
</h4>
<hr>
<div align="center">
<br>
<br>
<br>
<table border="1px"  style="text-align: center;">
        <tr>
        	<th>Subject</th>
            <th>Message</th>
            <th>Sent to</th>
            <th>Delete</th>
        </tr>
		<c:forEach var="elist" items="${elist }">
        <tr>
        	<td>${elist.getSubject() }</td>
            <td>${elist.getMessage() }</td>
            <td><a href="hsent?id=+${elist.getEid() }+">${elist.getSendto() }</a></td>
            <td><a href="delete?id=+${elist.getEid() }+">delete</a></td>
        </tr>
		</c:forEach>        
    	</table>
</div>
   
</body>
</html>