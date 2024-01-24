<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>matching</title>
</head>
<body>
<h3>matching</h3>
<script>
	const sse=new EventSource("http://localhost:8081/duo_matching/matching");
	
	sse.addEventListener('connect', (e) => { // connect라는 이름을 가진 이벤트를 받는다
		const { data: receivedConnectData } = e;
		console.log('connect event data: ',receivedConnectData);  // "connected
	});
</script>
</body>
</html>