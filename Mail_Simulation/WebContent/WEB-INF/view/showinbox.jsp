<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
 <br>
<br>
<br>


<div align="center">
<fieldset>
<style>
fieldset{
width: 350px;
height: 175px;
}
</style>

<label for="by">By:</label><br>
<input type="text" name="by" value="${elist.getSendby() }" disabled="disabled" style="width: 250px; height: 20px" /><br>
<label for="subject">Subject:</label><br>
<input type="text" name="subject" value="${elist.getSubject() }" disabled="disabled" style="width: 250px; height: 20px" /><br>
<label for="message">Message: </label><br>
<input type="text"  name="message" value="${elist.getMessage() }" disabled="disabled" style="width: 250px; height: 50px" ><br>
</fieldset>
</div>
</body>
</html>