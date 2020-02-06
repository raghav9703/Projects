<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 align="center">Re-compose Message</h1> 

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
width: 390px;
height: 455px;
}
</style>
<form action="composeDraft" method="post" style="margin-top: 20px; margin-bottom: 30px;">
<input type="text" name="to" value="${elist.getSendto() }" style="width: 290px; height: 20px"  /><br><br>
<input type="text" name="subject" value="${elist.getSubject() }" style="width: 290px; height: 20px"   /><br><br>
<input type="text"  name="message" value="${elist.getMessage() }" style="width: 320px; height: 250px"  /><br><br>
<input type="submit" value="Compose" style="width: 160px; height: 40px" />

</form>
</fieldset>
</div>

</body>
</html>