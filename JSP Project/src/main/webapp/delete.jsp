<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.Domain.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		MemberVO member = (MemberVO)request.getAttribute("member");
		request.setAttribute("memberDel", member);
	%>
	<div align="center">
		<button type="button" onclick="location.href= 'http://localhost:8080/hyunseok_free/home.jsp' ">Register</button>
		<form action="http://localhost:8080/hyunseok_free/MemberServlet?cmd=delete&id=<%=member.getId() %>" method="post">
			ID: <input type="text" name="id" value=<%=member.getId() %> readonly >
			<input type="submit" name="submit" value="탈퇴" />
		</form>
	</div>
</body>
</html>