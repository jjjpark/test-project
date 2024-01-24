package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;

@Service
public class UserService {

	@Autowired
	UserDao uDao;
	
	public boolean join(UserDto uDto) {
		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder(); // 비밀번호 암호화
		uDto.setPw(pwEncoder.encode(uDto.getPw()));
		return uDao.join(uDto);
	}

}
