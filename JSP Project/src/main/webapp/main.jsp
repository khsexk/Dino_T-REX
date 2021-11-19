<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.Domain.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> Dino T-REX HomePage </title>
	<link rel="stylesheet" href="resources/student.css" type="text/css"></link>
	<script>
		alert('로그인에 성공하셨습니다');
	</script>
</head>
<body>
	<header> Dino T-REX </header>
	
	<div>
	
		<%
			MemberVO member = (MemberVO)request.getAttribute("member");
		%>
		<br>
		Member Information <br>
		<table>
		<tr> <td>계정</td> <td>이름</td> <td>국적</td> <td>나이</td> <td>핸드폰</td> <td>메일주소</td><td>Score</td></tr>
			<tr> 
				<td><%=member.getId() %></td> 
				<td><%=member.getUsername() %></td> 
				<td><%=member.getNation() %></td> 
				<td><%=member.getOld() %></td> 
				<td><%=member.getMobile() %></td> 
				<td><%=member.getEmail() %></td>
				<td><%=member.getScore() %></td>
			</tr>
		</table>
	</div>
	
	<div align="center">
			<button type="button" onclick="location.href='gameFolder/game.html' ">Game</button>
			<button type="button" onclick="location.href='gameFolder/list.html' ">Rating</button>
	</div>
</body>
</html>