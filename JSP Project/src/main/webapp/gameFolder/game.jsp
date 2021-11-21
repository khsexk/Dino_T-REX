<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.Domain.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="gameResources/gameDesign.css">
	<title>Dino Game</title>
	<% 
		String id = (String)request.getAttribute("id"); 
	%>
</head>
<body>
		<div id="container">
			<div id="dino">
				<img src="gameResources/dino.png" alt="dino">
			</div>
			<div id="block">
				<img src="gameResources/cactus.png" alt="blocks">
			</div>
			<div id="road">
				<img src="gameResources/road.png" alt="road">
			</div>
			<div id="cloud">
				<img src="gameResources/cloud.png" alt="cloud">
			</div>
			<div id="score">
				Score <b id="point">0</b>
			</div>
			<div id="gameOver">GAME OVER</div>
		</div>
		<script src="gameFolder/gameJS.js"></script>
		
		<div align="center">
				<button type="button" onclick="location.href='http://localhost:8080/hyunseok_free/home.jsp' ">Go Main Page</button> <br>
				<form name="saveScore" action="http://localhost:8080/hyunseok_free/MemberServlet?cmd=rate" method="post">
					id: <input type="text" name="id" value=<%=id %> readonly >
					score: <input type="text" name="save" readonly >
					<input type="submit" name="submit" value="save" />
				</form>
		</div>
</body>
</html>