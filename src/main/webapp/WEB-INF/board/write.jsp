<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>">HOME</a>
	<a href="list">목록보기</a>
	<h1>글쓰기 페이지</h1>
	<form action="insert" method="post">
		<p>
			<input type="text" name="subject">
		</p>
		<p>
			<textarea rows="5" cols="50" name="content"></textarea>
		</p>
		<p>
			<input type="hidden" name="writer" value="guest">
			<button type="submit">글쓰기</button>
		</p>
	</form>
</body>
</html>