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
	const sse=new EventSource("http://localhost:80/connect");
	
	sse.addEvenetListener('count', e=>{
		const {data:receivedCount}=e;
		console.log("count event data",receivedCount);
		setCount(receivedCount);
	});
</script>
</body>
</html>