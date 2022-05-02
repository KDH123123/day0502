<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/login.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>로고</h1>
		<div class="wrap view-size">
			<a href="/web03"> <!-- <img alt="로고이미지" src="../images/neverlogo.png"> -->
			</a>
		</div>
	</header>
	<main>
		<h1>로그인페이지입니다.</h1>
		<div class="wrap view-size">
			<form>
				<!-- form에 대해서 공부필요 -->
				<div>
					<input type="text" placeholder="아이디">
					<!-- input 타입은 id적 속성도 있다.  -->
				</div>
				<div>
					<input type="password" placeholder="비밀번호">
				</div>
				<div class="flex between">
					<span> <input type="checkbox" id="cb">
					<!--체크박스--> <label for="cb">로그인상태유지</label> <!-- for="cb"연결함으로 로그인상태유지문자를 클릭해도 체크박스 체크  -->
					</span> <span> IP보안 <input type="radio">
					<!-- o 클릭가능한 동그라미 -->
					</span>
				</div>
				<div>
					<!-- <input type="submit" value="로그인"> -->
					<button type="submit">로그인</button>
				</div>
			</form>
			<ul class="flex center">
				<li><a href="#">비밀번호찾기</a></li>
				<li><a href="#">아이디찾기</a></li>
				<li><a href="#">회원가입</a></li>
			</ul>
		</div>
	</main>
	<footer>
		<h1>footer</h1>
		<div class="wrap view-size">푸터영역입니다.</div>
	</footer>
</body>
</html>