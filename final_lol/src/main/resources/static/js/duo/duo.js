const sse = new EventSource("http://localhost:80/duo/duo");


sse.addEventListener('connect', (e) => {
	const { data: receivedConnectData } = e;
	console.log('connect event data: ', receivedConnectData);
});

sse.addEventListener('count', (e) => { // count라는 이름을 가진 이벤트를 받는다
	const { data: result } = e;
	console.log('count event data: ', result);

	const div = document.createElement('div');
	div.setAttribute('class', 'roomList');

   	let result2 = JSON.parse(result);

    console.log(result2.length);

	const divChild = document.createElement('div');
	divChild.setAttribute('class', 'room');
	divChild.innerHTML = "제목 : " + result2.title + "<br>" +
		"포지션 : " + result2.position + "<br>" +
		"메모 : " + result2.memo + "<br>" +
		"챔피언 : " + result2.champion + "<br> <br>";

	div.appendChild(divChild);
	document.body.appendChild(div);

});

$.ajax({
	method : 'post',
	url : '/start'
})

$(document).ready(function() {
	// 스크립트 코드
	$('#test').on("click", function() {
		console.log("ajax start");
		let title = $("#title").val();
		let position = $("#position").val();
		let memo = $("#memo").val();
		let champion = $("#champion").val();


		data = {
			"title": title,
			"position": position,
			"memo": memo,
			"champion": champion
		};

		$.ajax({
			method: 'post',
			url: '/count',
			data: data,
		}).done(function() {
			console.log("성공");
		});
	});
});