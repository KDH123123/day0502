<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section class="login-form">
	<h1>로그인 페이지</h1>
	<p>${msg}</p>
	<form action ="insert" method="post">
		<div class = "int-area">
			<input type="text" name="email" placeholder="email">
		</div>
		<div class = "int-area">
			<input type="password" name="password" placeholder="password">
		</div>
		<div class = "btn-area">
		<button type="submit" value="로그인">로그인</button>
		</div>
	</form>
	</section>
</body>
</html>