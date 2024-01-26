const sse = new EventSource("http://localhost:80/duo/duo");


sse.addEventListener('connect', (e) => {
	const { data: receivedConnectData } = e;
	console.log('connect event data: ', receivedConnectData);
});

sse.addEventListener('count', (e) => { // count라는 이름을 가진 이벤트를 받는다
	const { data: result } = e;
	console.log('count event data: ', result);

	const div = document.querySelector('.roomList');
	// div.setAttribute('class', 'roomList');

	let result2 = JSON.parse(result);

	console.log(result2);
	
	console.log(result2[0].t_id)

	const divChild = document.getElementById('room');

	console.log(divChild)
	
	const newDiv = document.createElement('div')
	newDiv.setAttribute('class', 'room2')
	
	newDiv.innerHTML = "글번호 : " + result2[0].t_id + "<br><br>" +
		"제목 : <a href='/user/chatting'>" + result2[0].title + "</a> <br><br>" +
		"포지션 : " + result2[0].position + "<br><br>" +
		"메모 : " + result2[0].memo + "<br><br>" +
		"챔피언 : " + result2[0].champion + "<br><br>" + 
		"<button id='delete'>삭제</button> <hr>";
		

	divChild.prepend(newDiv);
});



$(document).ready(function() {
	$.ajax({
		method: 'get',
		url: '/start'
	}).done(function() {
		// AJAX 요청이 완료되면 실행할 코드
	});
});


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

$(document).ready(function() {
    $('.delete').on('click', function() {
        console.log('delete Start!');
        let t_id = $(this).data('t_id');
        
        $.ajax({
            method: 'post',
            url: '/delete/room',
            data: { t_id: t_id },
            success: function(res) {
                console.log("res", res);
            },
            error: function(error) {
                console.error('Error deleting entry', error);
            }
        });
    });
});
