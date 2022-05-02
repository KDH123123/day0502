<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="list">목록보기</a>
	<table id="detail">
		<tr>
			<td>no</td>
			<td>${detail.no }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${detail.writer }</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${detail.createdDate }</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${detail.readCount }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${detail.subject }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${detail.content }</td>
		</tr>
		<tr>
			<td colspan="2"><a href="delete?no=${detail.no }"><button
						type="button">삭제</button></a>
				<button type="button" id="btn-edit">수정</button>
		</tr>
	</table>

	<script type="text/javascript">
		$(function() {
			$("#btn-edit").click(function() {
				$("#detail").hide();
				$("#edit-form").show();
			});
			//취소버튼 누를때
			$("#btn-cancel").click(function() {
				$("#edit-form").hide();
				$("#detail").show();
			});
		});
	</script>

	<form action="update" method="post" id="edit-form"
		style="display: none;">
		<table>
			<tr>
				<td>NO</td>
				<td>${detail.no }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" value=${detail.subject }></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="5" cols="50">${detail.content}</textarea>
			</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="hidden" name="no" value="${detail.no }" />
				<button type="submit">수정완료</button>
				<button type="button" id="btn-cancel">취소</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>