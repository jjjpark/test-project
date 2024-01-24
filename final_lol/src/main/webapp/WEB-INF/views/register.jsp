<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<body>
<h1>회원가입페이지</h1>
<form action="/register" method="post">
    <label for="username">아이디:</label>
    <input type="text" id="username" name="username" required><br>

    <label for="userpwd">비밀번호:</label>
    <input type="password" id="userpwd" name="userpwd" required><br>
    
    <label for="confirm_password">비밀번호 확인:</label>
    <input type="password" id="confirm_pwd" name="confirm_pwd" required><br>
   

    <label for="irum">이름:</label>
    <input type="text" id="irum" name="irum" required><br>

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