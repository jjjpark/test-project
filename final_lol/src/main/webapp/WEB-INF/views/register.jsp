<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register page</title>
</head>
<body>
    <h1>회원가입 page</h1>
<form action="/register" method="post">
    <label for="username">아이디:</label>
    <input type="text" id="username" name="username" required><br>

    <label for="userpwd">비밀번호:</label>
    <input type="password" id="userpwd" name="userpwd" required><br>
    
<label for="confirm_pwd">비밀번호 확인:</label>
<input type="password" id="confirm_pwd" name="confirm_pwd" required><br>
   

   <label for="ireum">이름:</label>
<input type="text" id="ireum" name="ireum" required><br>

    <label for="nickname">닉네임:</label>
    <input type="text" id="nickname" name="nickname" required><br>

    <label for="gender">성별:</label>
    <select id="gender" name="gender" required>
        <option value="male">남성</option>
        <option value="female">여성</option>
    </select>
    <br>

    <input type="submit" value="가입하기">
</form>
</body>
</html>