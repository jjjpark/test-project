package com.example.demo.dto;

import java.util.Set;

import org.springframework.web.socket.WebSocketSession;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoom {
	private String roomId;
	private String name;
	private Set<WebSocketSession> sessions;
	public ChatRoom(String roomId, String name) {
		this.roomId= roomId;
		this.name= name;
	}
	
}
