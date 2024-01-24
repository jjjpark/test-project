package com.example.demo.sse;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SseEmitters {
	// thread-safe한 자료구조 사용 필요. (콜백이 SseEmitter를 관리하는 다른 스레드에서 실행되기 때문)
	private final List<SseEmitter> em = new CopyOnWriteArrayList<>();
	
	private static final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private UserDao uDao;
	
	// sse emitter 메서드 등록
	 public SseEmitter add(SseEmitter emitter) {  
	        this.em.add(emitter);  
	        log.info("new emitter added: {}", emitter);  
	        log.info("emitter list size: {}", em.size());  
	        emitter.onCompletion(() -> {  
	            log.info("onCompletion callback");  
	            this.em.remove(emitter);    // 만료되면 리스트에서 삭제
	        });  
	        emitter.onTimeout(() -> {  
	            log.info("onTimeout callback");  
	            emitter.complete();  
	        });  
	  
	        return emitter;  
	    }  
	
//	public void remove(SseEmitter se) {
//		this.em.remove(se);
//	}
	
	public void count() {  
        long count = counter.incrementAndGet();
        log.info("TQfus");
        em.forEach(emitter -> {  
            try {  
                emitter.send(SseEmitter.event()  
                        .name("count")
                        .data(count));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }  
        });
    }
	
	public void userData() {
		UserDto uDto = uDao.userInfo();
		
		log.info("uDto : {}", uDto);
		
		em.forEach(emitter -> {
			try {
				emitter.send(SseEmitter.event()
						.name("uDto")
						.data(uDto));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
	}
}
