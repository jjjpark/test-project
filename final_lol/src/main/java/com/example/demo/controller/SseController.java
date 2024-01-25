package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.example.demo.config.SseEmitters;
import com.example.demo.dto.RoomDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SseController {
	private final SseEmitters sseEmitters;
//	@Autowired
//	RoomDto rDto;
	public SseController(SseEmitters sseEmitters) {
		this.sseEmitters=sseEmitters;
	}
	
	@GetMapping(value="/duo_matching/matching", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<SseEmitter> connect(){
		SseEmitter emitter=new SseEmitter(5*60*1000L);
		try {
			emitter.send(SseEmitter.event()
					.name("connect")
					.data("connected"));
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
		sseEmitters.add(emitter);
		return ResponseEntity.ok(emitter);
	}
	@GetMapping("/start")
	public ResponseEntity<Void> start(){
		log.info("=====dummy data");
		sseEmitters.start();
		return ResponseEntity.ok().build();
	}
	@PostMapping("/count")
	public ResponseEntity<Void> count(RoomDto rDto){
		log.info("==============into count");
		sseEmitters.count(rDto);
		return ResponseEntity.ok().build();
	}
}
