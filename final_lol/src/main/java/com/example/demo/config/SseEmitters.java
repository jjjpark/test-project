package com.example.demo.config;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SseEmitters {
	private final List<SseEmitter> emitters=new CopyOnWriteArrayList<>();
	
	SseEmitter add(SseEmitter emitter) {
		this.emitters.add(emitter);
		
		emitter.onError(throwable->{
			log.error("SseEmitters파일 add메서드");
			log.error("", throwable);
			emitter.complete();
		});
		
		emitter.onTimeout(()->{
			log.info("complet callback");
			emitter.complete();
		});
//		
//		emitter.onCompletion(()->{
//			this.emitters.remove(emitter);
//		});
		return emitter;
	}//add 종료
	
//	void remove(SseEmitter emitter) {
//		this.emitters.remove(emitter);
//	}//remove
	
//	public void changeRoom(Object roomInfo) {
//		emitters.forEach(emitter->{
//			try {
//				emitter.send(SseEmitter.event()
//						.name("changeRoom")
//						.data(roomInfo));
//			}catch(IOException e){
//				this.emitters.remove(emitter);
//			}
//		});
//	}
}
