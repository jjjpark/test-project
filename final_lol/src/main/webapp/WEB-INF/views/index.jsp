<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- jsp에 사용하는 시큐리티 태그 

		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-taglibs</artifactId>
		</dependency>
		
		추가해야됨

-->
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
<h1>index</h1>
<!-- 로그인 안하면 나옴 -->
<sec:authorize access="isAnonymous()">
	<a href="/user/loginfrm">login</a>
	<a href="/user/joinfrm">join</a>
</sec:authorize>

<!-- 로그인 한 후 나옴 -->
<sec:authorize access="isAuthenticated()">
	<a href="/user/logout">logout</a>
	<a href="/duo/duo">duo</a>	
</sec:authorize>



</body>
</html>