<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.Domain.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Save Score</title>
	<link rel="stylesheet" href="resources/student.css" type="text/css"></link>
</head>
<body>
	<div align="center">
		<header>Score Save</header>
		<HR>
		<form action="http://localhost:8080/hyunseok_free/MemberServlet?cmd=rate" method="post">
			<%
				MemberVO member = (MemberVO)request.getAttribute("member");
			%>
			<fieldset>
				<legend> Information Update </legend>
				<ul>
					<li>ID: <input type="text" name="id" value=<%=member.getId() %> readonly ></li>
					<li>PASSWORD: <input type="password" name="passwd" value=<%=member.getPasswd() %> autofocus /></li>
					<li>USERNAME: <input type="text" name="username" value=<%=member.getUsername() %> ></li>
					<li>NATION: <input type="text" name="nation" value=<%=member.getNation() %> ></li>
					<li>OLD: <input type="text" name="olds" value=<%=member.getOld() %> ></li>
					<li>MOBILE: <input type="text" name="mobile" value=<%=member.getMobile() %> ></li>
					<li>EMAIL: <input type="text" name="email" value=<%=member.getEmail() %> ></li>
					<li>Score: <input type="text" name="score" value=<%=member.getScore() %> readonly ></li>
				</ul>
			</fieldset>
			<br>
			<fieldset>
				<input type="submit" name="submit" value="최종 수정" />
				<input type="reset" name="reset" value="다시 수정" />
			</fieldset>
		</form>
	</div>
</body>
</html>