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
	title<input id="title" type="text"></input></br>
	position<input id="position" type="text"></input></br>
	memo<input id="memo" type="text"></input></br>
	champion<input id="champion" type="text"></input></br>
<button id="test">test</button>

<%-- <c:if test="${not empty rList}"> --%>
<c:forEach var="rList" items="${rList}">
	<p>제목 : rList.title</p>
	<p>라인 : rList.position</p>
	<p>메모 : rList.memo</p>
	<p>챔피언 : rList.champion</p>
	<hr>
</c:forEach>
<%-- </c:if> --%>
</body>
</html>