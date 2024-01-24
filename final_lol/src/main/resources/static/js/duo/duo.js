const sse = new EventSource("http://localhost:80/duo/duo");


sse.addEventListener('connect', (e) => {
	const { data: receivedConnectData } = e;
	console.log('connect event data: ', receivedConnectData);
	
	// 버튼 클릭 이벤트 리스너
	$('#btn').click(function() {
		// AJAX 요청 수행
		$.ajax({
			url: "/userInfo",
			method: 'get',
			data: { test: 'test' },
			success: function(res) {
				//console.log('AJAX 요청 성공:', res);	
				console.log('AJAX 요청 성공:', res);
				
				
			},
			error: function(error) {
				console.error('AJAX 요청 실패:', error);
			}
		});
	});
});

sse.addEventListener("count", function(event) {
	const { data : tsetData } = event;
	console.log("Received count:", tsetData);
});

sse.addEventListener("uDto", function(event) {
	const { data : userInfo } = event;
	console.log("Received userInfo:", userInfo);
});