package com.example.demo.websocket;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.example.demo.dto.ChatMessage;
import com.example.demo.dto.ChatRoom;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketHandler extends TextWebSocketHandler{
	private final ObjectMapper objectMapper;
	private final ChatService cSer;
	private final Set<WebSocketSession> sessions = ConcurrentHashMap.newKeySet();
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
	}
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload=message.getPayload();
		ChatMessage chatMessage=objectMapper.readValue(payload,ChatMessage.class);
		ChatRoom room=cSer.findRoomById(chatMessage.getRoomId());
//		Set<WebSocketSession> sessions=room.getSessions();
		log.info("handler");
		if(chatMessage.getType().equals(ChatMessage.MessageType.ENTER)) {
			sessions.add(session);
			chatMessage.setMessage(chatMessage.getSender()+"입장");
			sendToEachSocket(sessions, new TextMessage(objectMapper.writeValueAsString(chatMessage)));
		}else if(chatMessage.getType().equals(ChatMessage.MessageType.QUIT)){
			sessions.remove(session);
			chatMessage.setMessage(chatMessage.getSender()+"퇴장");
			sendToEachSocket(sessions,new TextMessage(objectMapper.writeValueAsString(chatMessage)));
		}else {
			log.info(payload);
			sendToEachSocket(sessions,message);
		}
	}
	private void sendToEachSocket(Set<WebSocketSession> sessions, TextMessage message) {
		sessions.parallelStream().forEach(roomSession->{
			try {
				roomSession.sendMessage(message);
			}catch(IOException e) {
				throw new RuntimeException(e);
			}
		});
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
			
	}
	
	
}
