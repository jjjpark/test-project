package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.example.demo.config.SseEmitters;
import com.example.demo.dto.RoomDto;
import com.example.demo.service.RoomService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	@Autowired
	SseEmitters smit;
	@Autowired
	RoomService rSer;
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
	@GetMapping("/duo_maching/matching")
	public String room(Model model) {
		log.info("======move");
		List<RoomDto> rList=rSer.roomsearch();
		model.addAttribute("rList", rList);

		return "duo_matching/matching";
	}
}
