package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class SummonerController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

}