let socket = new WebSocket("ws://localhost:80/ws/chat");


function enterRoom(socket){
	var enterMsg={"type": "ENTER", "roomId":'${room.roomId}',"sender":"chee","msg":""};
	socket.send(JSON.stringify(enterMsg));
}


socket.onopen=function(e){
	console.log('open server')
	enterRoom(socket);
};

socket.onclose=(e) => {
    console.log("close");
    console.log(e.code, e.wasClean);
}

socket.onerror=function(e){
	console.log(e);
}

socket.onmessage=function(e){
	console.log(e.data);
	let msgArea=document.querySelector('.msgArea');
	let newMsg=document.createElement('div');
	newMsg.innerText=e.data;
	msgArea.append(newMsg);
}
function sendMsg(){
	let content=document.querySelector('.content').value;
	var talkMsg={"type":"TALK","roomId":'${room.roomId}',"sender":"chee","msg":content};
	socket.send(JSON.stringify(talkMsg));
}

function quit(){
	var quitMsg={"type":"QUIT","roomId":'${room.roomId}',"sender":"chee","msg":""}
	socket.send(JSON.stringify(quitMsg));
	socket.close();
	location.href="/chat/chatList";
}