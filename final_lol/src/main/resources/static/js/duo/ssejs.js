const sse=new EventSource("http://localhost:80/duo/duo");

sse.addEventListener('connect', (e) => { // connect라는 이름을 가진 이벤트를 받는다
	const { data: receivedConnectData } = e;
	console.log('connect event data: ',receivedConnectData);  // "connected
});


sse.addEventListener('count', (e) => { // count라는 이름을 가진 이벤트를 받는다
	const { data: result } = e;
//	let i=0;
	console.log('count event data: ',result);  // "connected
//	result.forEach((result, i)=>{
//		console.log(result)
//			
	let result2=JSON.parse(result)
	for(let i in result){
		console.log(result2[i])
		
	}
			
//	})
});

$('#test').on("click",function(){
	console.log("ajax steart")
	let title=$("#title").val()
	let position=$("#position").val()
	let memo=$("#memo").val()
	let champion=$("#champion").val()
	
//	console.log(title)
	
	data={
		"title": title,
		"position": position,
		"memo": memo,
		"champion": champion
	}
	$.ajax({
		method:'post',
		url:'/count',
		data:data,
	}).done(function(count){
//		console.log(count);
//		$("result").html(count)
	})
})