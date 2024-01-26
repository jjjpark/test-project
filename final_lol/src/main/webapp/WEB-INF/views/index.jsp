<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Summoner Search</title>
</head>
<body>

<h1>INDEX 메인페이지</h1>
  <a href="/register">회원가입</a>
    <a href="/login">로그인</a>
    <a href="#">게시판</a>
    
      <form action="${pageContext.request.contextPath}/search" method="post">
        <label for="summonerName">Summoner Name:</label>
        <input type="text" id="summonerName" name="summonerName" />
        <button type="submit">Search</button>
    </form>
    <h3>index.jsp</h3>
	<a href="/duo_maching/matching">매칭 들어가기</a>
</body>
</html>
