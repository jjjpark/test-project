package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessage {
	public enum MessageType{
		ENTER,TALK,QUIT,ROOM
	}
	private MessageType type;
	private String roomId;
	private String sender;
	private String message;
}
