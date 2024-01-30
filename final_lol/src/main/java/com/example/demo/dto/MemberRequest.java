package com.example.demo.dto;

import lombok.Getter;

import org.springframework.security.crypto.password.PasswordEncoder;

//가입,수정
@Getter
public class MemberRequest {

	private Long id; // 회원 번호 (PK)
	private String loginId; // 로그인 ID(UQ)
	private String password; // 비밀번호
    private String nickname;// 닉네임
	private String gender; // 성별


	public void encodingPassword(PasswordEncoder passwordEncoder) {
		password = passwordEncoder.encode(password);
	}



}
