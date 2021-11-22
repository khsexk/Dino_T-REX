<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title> Dino T-REX HomePage </title>
	<link rel="stylesheet" href="resources/member.css" type="text/css"></link>
</head>

<body id="login">
	<header> Dino T-REX </header>
	<form action="http://localhost:8080/hyunseok_free/MemberServlet?cmd=login" method="post">
		<fieldset>
		<legend> LOG - IN </legend>
			<p id=sect>
					Welcome to Jurassic World<br>
					If you want to enjoy "Dino T-REX",<br>
					Please LOG-IN first!
			</p>
			<ul>
				<li>ID: <input type="text" name="id" autofocus required placeholder="공백없이 입력하세요"></li>
				<li>PW: <input type="password" name="passwd" required placeholder="공백없이 입력하세요"></li>
			</ul>
			<div align="center">
				<button type="button" onclick="location.href= 'http://localhost:8080/hyunseok_free/MemberServlet?cmd=join' ">Register</button>
				<input type="submit" name="submit" value="Log-In">
			</div>
		</fieldset>
	</form>
</body>
</html>