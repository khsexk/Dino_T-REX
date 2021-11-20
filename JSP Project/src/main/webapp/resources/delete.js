function leaveAccount() {
	const element = document.getElementById('id');
	if (confirm("이 버튼에 대한 동작을 수행합니다. 계속합니까?")) {
		// 확인 버튼 클릭 시 동작
		alert("동작을 시작합니다.");
		location.href=`http://localhost:8080/hyunseok_free/MemberServlet?cmd=delete&id=${element}`;
	} else {
		// 취소 버튼 클릭 시 동작
		alert("동작을 취소했습니다.");
	}
} 