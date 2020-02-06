<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 align="center">Compose Email</h1> 

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
<div align="center">
<fieldset>
<style>
fieldset{
width: 370px;
height: 505px;
}
</style>

<form action="composeEmail" method="post" style="margin-top: 20px; margin-bottom: 30px;">
<input type="text" name="to" placeholder="Send to:" style="width: 290px; height: 20px" /><br><br>
<input type="text" name="subject" placeholder="Enter Subject" style="width: 290px; height: 20px" /><br><br>
<textarea rows="20" cols="40" name="message" placeholder="Message"></textarea><br><br>
<input type="submit" value="Compose" style="width: 160px; height: 40px" />

</form>
</fieldset>
</div>

</body>
</html>