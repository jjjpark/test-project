package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j

public class UserController {

	@Autowired
	private UserService uSer;

	@GetMapping("/login")
	public String loginForm() {
	log.info("로그인화면");
		return "login"; 
	}

	
	
	
	@GetMapping("/userList")
	public String getUserList(Model model) {
		List<UserDto> userList = uSer.getUserList();
		model.addAttribute("list", userList);
		return "userList";
	}

	@GetMapping("/register")
	public String rgisterForm() {
		log.info("회원가입화면!");
		return "register";

	}

	@PostMapping("/register")
	public String register(UserDto userDto, Model model) { // 회원가입

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

}