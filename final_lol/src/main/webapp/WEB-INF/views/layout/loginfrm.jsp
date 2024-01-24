<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginFrm</title>
</head>
<body>
<form action="/login" method="post">
	id : <input type="text" id="userId" name="id" placeholder="아이디를 입력해주세요.">
	pw : <input type="text" id="userPw" name="pw" placeholder="비밀번호를 입력해주세요.">
	<input type="submit" id="login" value="로그인">

</form>
</body>
</html>