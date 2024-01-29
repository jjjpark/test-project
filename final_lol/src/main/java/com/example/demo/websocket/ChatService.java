package com.example.demo.websocket;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ChatRoom;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatService {
	
	private final ObjectMapper objectMapper;
	private Map<String, ChatRoom> chatRooms;
	
	@PostConstruct
	private void init() {
		chatRooms=new LinkedHashMap<>();
	}
	
	public ChatRoom findRoomById(Object roomId) {
		return chatRooms.get(roomId);
	}
	
	public ChatRoom createRoom(String name) {
		String randomId=UUID.randomUUID().toString();
		ChatRoom chatRoom=ChatRoom.builder()
								  .roomId(randomId)
								  .build();
		chatRooms.put(randomId, chatRoom);
		return chatRoom;
	}

	public List<ChatRoom> findAllRoom() {
		return new ArrayList<>(chatRooms.values());
	}
}
