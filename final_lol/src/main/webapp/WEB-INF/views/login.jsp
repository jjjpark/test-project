<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
<h1>로그인페이지</h1>

 <form id="login-form" onsubmit="return validateLoginForm()" action="login" method="post">
    <input type="text" id="id" name="id" required placeholder="아이디"><br>
    <input type="password" id="password" name="password" required placeholder="비밀번호"><br>
    <button class="login-button" type="submit">로그인</button>
  
    <div class="find_signupcontain">
    <div class="findidpwtt"> 
    <a href="/findId">아이디,비밀번호를 잊으셨나요?</a> </div> 
     <div class="register">
     <span>got.gg에 가입ㄱㄱ?</span>
     <a href="/register">가입하기</a></div>
</div>
  </form>

	<br>
</body>
</html>
