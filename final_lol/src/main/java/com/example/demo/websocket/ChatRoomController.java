package com.example.demo.websocket;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.ChatRoom;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ChatRoomController {
	private final ChatService chatService;
	
	@RequestMapping("/duo_matching/chatList")
	public String chatList(Model model) {
		List<ChatRoom> roomList=chatService.findAllRoom();
		model.addAttribute("roomList",roomList);
		return"duo_matching/chatList";
	}
	
	@PostMapping("/chat/createRoom")
	public String createRoom(Model model, @RequestParam(name="name") String name, @RequestParam(name="username")String username) {
		log.info("name");
		ChatRoom room=chatService.createRoom(name);
		model.addAttribute("room",room);
		log.info("{}",room.getRoomId());
		model.addAttribute("username",username);
		return "duo_matching/chatroom";
	}
	
	@GetMapping("/chat/chatRoom")
	public String chatRoom(Model model,@RequestParam String roomId) {
		ChatRoom room=chatService.findRoomById(roomId);
		model.addAttribute("room", room);
		return "duo_matching/chatroom";
	}
}
