const sse=new EventSource("http://localhost:80/duo_matching/matching");

$(document).ready(function(){
	$.ajax({
		method:'get',
		url:'/start',
	}).done()
})

sse.addEventListener('connect', (e) => { // connect라는 이름을 가진 이벤트를 받는다
	const { data: receivedConnectData } = e;
	console.log('connect event data: ',receivedConnectData);  // "connected
});


sse.addEventListener('count', (e) => { // count라는 이름을 가진 이벤트를 받는다
	const { data: roomlist} = e;
//	let i=0;
//	console.log('count event data: ',result);  // "connected
//	result.forEach((result, i)=>{
//		console.log(result)
	let result=JSON.parse(roomlist)
//	console.log(result[0])
//	console.log(result[result.length-1].title)
		const temp=document.createElement("div");
		temp.innerHTML=`<div id="rlist">
						<h1>${result[0].title}</h1>
						<p>${result[0].position}</p>
						<p>${result[0].memo}</p>
						<p>${result[0].champion}</p>
						`
		document.querySelector(".rlist").prepend(temp);
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