<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.Domain.MemberVO, member.Persistence.MemberDAO, java.util.List"%>
<!DOCTYPE html>
<jsp:useBean id="MemberList" class="member.Persistence.MemberDAO"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="resources/student.css" type="text/css"></link>
	<title> Dino Game Rate </title>
</head>
<body>
	<header>Member Rating</header>
	<p align="center">
		<a href="http://localhost:8080/hyunseok_free/main.jsp" target="_self">메인 페이지 이동</a>
	</p>
	<table>
		<tr> <td>순위</td> <td>계정</td> <td>이름</td> <td>국적</td> <td>나이</td> <td>핸드폰</td> <td>메일주소</td> <td>점수</td></tr>
		<%
			List<MemberVO> memberList = (List<MemberVO>)request.getAttribute("memberList");
			int i = 1;
			for(MemberVO vo : memberList){
		%>
			<tr> 
				<td><%=i %></td> 
				<td><%=vo.getId() %></td> 
				<td><%=vo.getUsername() %></td> 
				<td><%=vo.getNation() %></td> 
				<td><%=vo.getOld() %></td> 
				<td><%=vo.getMobile() %></td> 
				<td><%=vo.getEmail() %></td>
				<td><%=vo.getScore() %></td>
			</tr>
		<%
				i++;
			}
		%>
	</table>
</body>
</html>