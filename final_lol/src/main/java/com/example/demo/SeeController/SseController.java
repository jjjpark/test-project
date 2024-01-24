package com.example.demo.SeeController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.example.demo.sse.SseEmitters;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SseController {
	private final SseEmitters se;

	public SseController(SseEmitters se) {
		this.se = se;
	}

	@GetMapping(value = "/duo/duo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<SseEmitter> connect() {
		SseEmitter emitter = new SseEmitter(60 * 1000L);
		se.add(emitter);
		try {
			emitter.send(SseEmitter.event().name("connect").data("connected!"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return ResponseEntity.ok(emitter);
	}
	
	@PostMapping("/count")  
    public ResponseEntity<Void> count() {
		log.info("TQ");
        se.count(); 
        return ResponseEntity.ok().build();  
    }
	
	@GetMapping("/userInfo")
	public ResponseEntity<Void> userInfo() {
		log.info("TQ");
        se.userData();
        return ResponseEntity.ok().build();
	}
	
	
}
