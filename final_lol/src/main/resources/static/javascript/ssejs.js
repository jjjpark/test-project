const sse=new EventSource("http://localhost:80/duo_matching/matching");

sse.addEventListener('connect', (e) => { // connect라는 이름을 가진 이벤트를 받는다
	const { data: receivedConnectData } = e;
	console.log('connect event data: ',receivedConnectData);  // "connected
});
sse.addEventListener('count', (e) => { // count라는 이름을 가진 이벤트를 받는다
	const { data: result } = e;
	console.log('count event data: ',result);  // "connected
});

var roomdata=$("form[name=newroom]").serialize();
$('#test').on("click",function(){
	console.log("ajax steart")
	let title=$("#title").val()
	let id=$("#id").val()
	let tier=$("#tier").val()
	let position=$("#position").val()
	let memo=$("#memo").val()
	let champion=$("#champion").val()
	
	data={
		id: id,
		title: title,
		tier: tier,
		position: position,
		memo: memo,
		champion: champion
	}
	$.ajax({
		method:'post',
		url:'/count',
		data:{"roomdata":data}
	}).done(function(count){
//		console.log(count);
//		$("result").html(count)
	})
})