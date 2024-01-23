package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.UserService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class UserController {
	@Autowired
	private UserService uSer;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@
}
