<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
</head>
<body>
<h1>로그인page</h1>
 <form action="/login" method="post">
        <label for="username">아이디</label>
        <input type="text" id="username" name="username" required><br>
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" required><br>
        <input type="submit" value="Login">
    </form>

</body>
</html>