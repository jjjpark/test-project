<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinfrm</title>
</head>
<body>
<div class="container">
<h2>회원가입</h2>
<form action="/join" method="post">
    <div class="form-group">
    <label for="email">Email :</label>
    <input type="text" class="form-control" placeholder="Enter id" id="id" name="id">
  </div>
  
  <div class="form-group">
    <label for="pwd">Password :</label>
    <input type="password" class="form-control" placeholder="Enter password" id="pw" name="pw">
  </div>

  <div class="form-group">
    <label for="name">UserName :</label>
    <input type="text" class="form-control" placeholder="Enter UserName" id="lolId" name="lolId">
  </div>
  
  <button type="submit" class="btn btn-primary">회원가입 완료</button>
</form>
</div>
</body>
</html>