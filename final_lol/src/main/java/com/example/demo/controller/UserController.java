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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
@Slf4j
public class UserController {

	@Autowired
	private UserService uSer;

	@GetMapping("/login")
	public String loginForm(HttpSession session) {
	    Long userId = (Long) session.getAttribute("userId");
	    if (userId != null) { // 로그인된 상태
	        return "redirect:/";
	    }
	    return "login"; // 로그인되지 않은 상태
	}


	@GetMapping("/userList")
	public String getUserList(Model model) {
		List<UserDto> userList = uSer.getUserList();
		model.addAttribute("list", userList);
		return "userList";
	}

	@GetMapping("/register")
	public String RrgisterForm() {

		return "register";

	}

	@PostMapping("/register")
	public String signup(UserDto userDto) { // 회원가입
		try {
			uSer.register(userDto);
		} catch (DuplicateKeyException e) {
			return "redirect:/register?error_code=-1";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/register?error_code=-99";
		}
		return "redirect:/login";
	}
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
