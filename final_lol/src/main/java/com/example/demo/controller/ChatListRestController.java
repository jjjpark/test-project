package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RoomDto;
import com.example.demo.service.ChatRoomService;

import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
public class ChatListRestController {
	@Autowired
	ChatRoomService cSer;
	
	@GetMapping("/duo_matching/chatList")
	public List<RoomDto> roomList(){
		log.info("get rlist");
		List<RoomDto> rList=cSer.getchatList();
		return rList;
	}
	
	
	
}
