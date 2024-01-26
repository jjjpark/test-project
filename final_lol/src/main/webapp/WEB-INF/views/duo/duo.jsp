<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>duo</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="/js/duo/duo.js"></script>
</head>
<body>
<h1>DUO</h1>
	title : <input id="title" type="text"></input></br>
	position : <input id="position" type="text"></input></br>
	memo  : <input id="memo" type="text"></input></br>
	champion : <input id="champion" type="text"></input></br>
<button id="test">test</button>

<%-- <c:if test="${not empty rList}"> --%>
<!-- <div class="roomList"> -->
<!-- 	<div class="room" id="room"> -->
<%-- 		<c:forEach var="room" items="${r}"> --%>
<%-- 			<p id="t_id">글번호 : ${room.t_id}</p> --%>
<%-- 			<a href="/user/chatting"><p>제목 : ${room.title}</p></a> --%>
<%-- 			<p>라인 : ${room.position}</p> --%>
<%-- 			<p>메모 : ${room.memo}</p> --%>
<%-- 			<p>챔피언 : ${room.champion}</p> --%>
<!-- 			<button id="delete"> 삭제 </button> -->
<!-- 			<hr> -->
<%-- 		</c:forEach> --%>
<!-- 	</div> -->
<!-- </div> -->

<div class="roomList">
    <div class="room" id="room">
        <c:forEach var="room" items="${r}" varStatus="status">
            <p id="t_id_${status.index}">글번호 : ${room.t_id}</p>
            <a href="/user/chatting"><p>제목 : ${room.title}</p></a>
            <p>라인 : ${room.position}</p>
            <p>메모 : ${room.memo}</p>
            <p>챔피언 : ${room.champion}</p>
            <button class="delete" data-t_id="${room.t_id}"> 삭제 </button>
            <hr>
        </c:forEach>
    </div>
</div>

<%-- </c:if> --%>
</body>
</html>