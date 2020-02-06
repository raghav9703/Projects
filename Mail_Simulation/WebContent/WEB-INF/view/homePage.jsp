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
<h1 align="center">Welcome to Home Page </h1> <h2  style="font-style: italic; color: blue; " align="right"> ${udto.getFullname() } </h2>
<h4 align="right">
<button ><a href="inbox">Inbox</a></button>
<button><a href="sent">Sent</a></button>
<button><a href="draft">Draft</a></button>
<button><a href="compose">Compose</a></button>
<button><a href="deletem">DeletedMails</a></button>
<button><a href="change">ChangePassword</a></button>
<button><a href="logout">Log Out</a></button>
<br>
</h4>
 <hr>
<div style="color: green;">${pass }</div>
<div style="color: green;">${msg }</div>
<div style="color: red;">${msg1 }</div>
<div style="color: red;">${delete1 }</div>
<div style="color: green;">${delete }</div>



    	   
    	
</body>
</html> 