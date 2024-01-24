package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	@GetMapping("/")
	public String main() {
		return "index";
	}
	@GetMapping("/duo_maching/matching")
	public String room() {
		log.info("======move");
		return "duo_matching/matching";
	}
}
