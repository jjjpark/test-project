package com.example.demo.config;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.example.demo.dto.RoomDto;
import com.example.demo.service.RoomService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SseEmitters {

	private static final AtomicLong counter = new AtomicLong();
	@Autowired
	private RoomService rSer;
//	@Autowired
//	private RoomDto rDto;
	private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

	public SseEmitter add(SseEmitter emitter) {
		this.emitters.add(emitter);
		log.info("new emitter added:{}", emitter);
		log.info("emitter list size:{}", emitters.size());
//		this.emitters.remove(emitter);
		emitter.onCompletion(() -> {
			log.info("onCompletion callback");
			this.emitters.remove(emitter);
		});
		emitter.onError(throwable -> {
			log.error("SseEmitters파일 add메서드");
			log.error("", throwable);
			emitter.complete();
			this.emitters.remove(emitter);
		});

		emitter.onTimeout(() -> {
			log.info("timeout!");
			emitter.complete();
		});

		return emitter;
	}// add 종료

	void remove(SseEmitter emitter) {
		this.emitters.remove(emitter);
	}// remove

	public void count(RoomDto rDto) {
//		this.emitters.remove(emitter);
		long count = counter.incrementAndGet();
		log.info("count into2");
		log.info("====={}", rDto);
		List<RoomDto> rList = rSer.roominsert(rDto);
		emitters.forEach(emitter -> {
			try {
				emitter.send(SseEmitter.event().name("count").data(rList));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});
	}// count 종료

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
