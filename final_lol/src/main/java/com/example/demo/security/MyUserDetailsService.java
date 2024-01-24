package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

//MemberService 클래스에서 구핸해도 됨
@Component
@Slf4j
//UserDetailsService인테페이스의 loadUserByUsername메소드로 로그인 구현 
public class MyUserDetailsService implements UserDetailsService {
	// 시큐리티 전용 service이다. (그렇게 생각해도 무방)
	@Autowired
	private UserDao uDao; // 개발자가 만든 Dao
	
	@Autowired
	private HttpSession s; // 신경 X 나중에 커스텀할 떄 사용
	
	//UserDetails인터페이스: 시큐리티에서 회원정보를 담기위한 용도
	//User클래스: UserDetails인터페이스 구현체
	@Override 
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		//로그인 성공시 User를  반환, 실패시 핸들러에 전달 
		UserDto mb = uDao.getUserInfo(id); // DAO에 id값을 보내서 DB에 저장한 DTO데이터들을 가져옴
		
//		s.setAttribute("name", mb.getUserName());
		
		log.info("======member:{}",mb);
		
		// 가져온 데이터들을 확인하고 매칭이 잘 되는지 확인
		if(mb==null) {
			//로그인실패시 예외를 로그인실패 핸들러에 던짐
			throw new UsernameNotFoundException(id + " 사용자를 찾을 수 없습니다");
		}
		//User클래스: UserDetails의 구현체
		//필수:아이디,비밀번호, 권한, 선택: disabled(t/f(로그인안됨)), accountLocked(t/f(로그인안됨)),accountExpired(t/f) 
//		return User.builder().username(u_id).password(mb.getU_pw()).roles(mb.getRole()).build();
		return User.builder().username(id).password(mb.getPw()).build();
	}
}