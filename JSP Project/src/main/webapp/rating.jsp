<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.Domain.MemberVO, member.Persistence.MemberDAO, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:useBean id="MemberList" class="member.Persistence.MemberDAO"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="resources/member.css" type="text/css"></link>
	<title> Dino Game Rate </title>
</head>
<body>
	<header> 순 위 표</header> <HR>
	<p align="center">
		<a href="http://localhost:8080/hyunseok_free/main.jsp" target="_self">메인 페이지 이동</a>
	</p>
	
	<table border="2">
		<% int i = 1; %>
		<tr> <td>순위</td> <td>계정</td> <td>이름</td> <td>국적</td> <td>나이</td> <td>핸드폰</td> <td>메일주소</td> <td>점수</td></tr>
		<c:forEach var="member" items="${memberList}">
			<tr> 
				<td><%=i %></td> 
				<td><c:out value="${ member.id }" /></td> 
				<td><c:out value="${ member.username }" /></td> 
				<td><c:out value="${ member.nation }" /></td> 
				<td><c:out value="${ member.old }" /></td> 
				<td><c:out value="${ member.mobile }" /></td> 
				<td><c:out value="${ member.email }" /></td>
				<td><c:out value="${ member.score }" /></td>
			</tr>
			<% i++; %>
		</c:forEach>
	</table>
</body>
</html>