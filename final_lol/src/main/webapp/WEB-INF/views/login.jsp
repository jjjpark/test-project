<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인페이지</title>
</head>
<body>
	<form action="/login" method="post">
		<input type="text" name="userid" placeholder="아이디"><br> <input
			type="text" name="userpwd" placeholder="비밀번호"><br> <input
			type="submit" value="로그인"><br>

	</form>
	<button>
		<a href="register">회원가입</a>
	</button>
	<br>
</body>
</html>
