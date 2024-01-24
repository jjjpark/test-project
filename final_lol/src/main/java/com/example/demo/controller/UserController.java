package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
public class UserController {
	@Autowired
	private UserService uSer;
	
	@GetMapping("/")
	public String home() {
		return "index"; // 기본적으로 찾아감
	}
	
	@GetMapping("/user/loginfrm")
	public String loginfrm() {
		return "layout/loginfrm";
	}
	
	@GetMapping("/user/joinfrm")
	public String joinfrm() {
		return "layout/joinfrm";
	}
	
	@GetMapping("/user/logout")
	public String logout(HttpSession session) {
	    session.invalidate();
	    log.info("User logged out successfully.");
	    return "redirect:/";
	}

	@GetMapping("/user/login/error")
	public String loginError(Model model) {
		model.addAttribute("msg", "로그인 실패-model");
		return "member/loginfrm";
	}
	
	@PostMapping("/join")
	public String join(UserDto uDto, Model m) {
		
		log.info("uDto : {}", uDto);
		boolean result = uSer.join(uDto);
		
		if(result) {
			m.addAttribute("msg", "회원가입이 완료되었습니다.");
			return "redirect:/";
		} else {
			m.addAttribute("msg", "회원가입에 실패하셨습니다.");
			return "redirect:/user/joinfrm";
		}
	}
	
	@GetMapping("/duo/duo")
	public String duo() {
		return "duo/duo";
	}
	
}
