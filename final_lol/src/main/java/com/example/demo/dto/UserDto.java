package com.example.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class UserDto {
	
	private Long user_id;// 유저(롤 아이디)PK값
	private String user_name;
	private String user_pwd;// 유저 비밀번호
	private String nickname;// 닉네임
	private String gender; // 성별
	


	}

