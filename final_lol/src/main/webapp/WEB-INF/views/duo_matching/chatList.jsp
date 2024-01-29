<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chatList</title>
</head>
<body>
<form action="/chat/createRoom" method="post">
	<input type="text" name="name" placeholder="채팅방 이름">
	<input type="text" name="username" placeholder="유저이름">
	<button type="submit">방 만들기</button>
</form>
<c:forEach var="rList" items="${roomList}">
	<a href="/chatroom?roomId=${room.roomId}"> ${room.name}</a>
</c:forEach>
</body>
</html>