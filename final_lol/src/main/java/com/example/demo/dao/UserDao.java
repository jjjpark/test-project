package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserDto;

@Mapper
public interface UserDao {

	List<UserDto> getUserList();
<<<<<<< HEAD
	
	void insertUser(UserDto userDto); //회원가입 insert


=======
	
	void insertUser(UserDto userDto); //회원가입 insert

	

	


	


	

>>>>>>> main
}
