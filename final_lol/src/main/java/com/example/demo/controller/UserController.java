package com.example.demo.controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class UserController {

	@Autowired
	private UserService uSer;
	@GetMapping("/login")
	public String Showlogin() {
		log.info("로그인페이지");
		return "login";
	}

	@GetMapping("/register")
	public String UserRrgister() {
		log.info("회원가입페이지");
		return "register";
	}

	@PostMapping("/register")
	//회원가입
	public String Register(UserDto userDto, Model model) {
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			uSer.register(userDto);
			resultMap.put("success", true);
			resultMap.put("message", "회원가입 성공");
		} catch (Exception e) {
			resultMap.put("success", false);
			resultMap.put("message", "회원가입 실패: " + e.getMessage());
		}
		//회원가입 성공하면 로그인페이지 ,실패하면 다시회원가입페이지로
		model.addAllAttributes(resultMap);
		return resultMap.get("success") == Boolean.TRUE ? 
				"redirect:/login" : "/register";
	}
}
