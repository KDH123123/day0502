<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/join.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section class="join-form">
		<h1>회원가입 페이지</h1>
		<form action="insert" method="post">
			<div class = "int-area">
				<input type="text" name="email" placeholder="이메일">
			</div>
			<div class = "int-area">
			<input type="text" name="name" placeholder="이름">
			</div>
			<div class = "int-area">
				<input type="password" name="pass" placeholder="비밀번호">
			</div>
			<div class = "btn-area">
				<button type="submit">회원가입</button>
				<button type="button">취소</button>
			</div>
		</form>
	</section>
</body>
</html>