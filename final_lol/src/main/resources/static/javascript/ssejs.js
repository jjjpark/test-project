const sse=new EventSource("http://localhost:80/duo_matching/matching");

sse.addEventListener('connect', (e) => { // connect라는 이름을 가진 이벤트를 받는다
	const { data: receivedConnectData } = e;
	console.log('connect event data: ',receivedConnectData);  // "connected
});
sse.addEventListener('count', (e) => { // connect라는 이름을 가진 이벤트를 받는다
	const { data: receivedConnectData } = e;
	console.log('count event data: ',receivedConnectData);  // "connected
});


$('#test').on("click",function(){
	console.log("ajax steart")
	$.ajax({
		method:'post',
		url:'/count',
//		data:{"test":"test"}
	}).done(function(count){
		console.log(count);
//		$("result").html(count)
	})
})