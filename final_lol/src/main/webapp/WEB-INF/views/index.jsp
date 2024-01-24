<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Summoner Search</title>
</head>
<body>

<h1>INDEX 메인페이지</h1>

    <form action="${pageContext.request.contextPath}/search" method="post">
        <label for="summonerName">Summoner Name:</label>
        <input type="text" id="summonerName" name="summonerName" />
        <button type="submit">Search</button>
    </form>
</body>
</html>