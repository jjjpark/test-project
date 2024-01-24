package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserDto;

@Mapper
public interface UserDao {

	//회원가입메소드
	void insertUser(UserDto userDto);

	
}
