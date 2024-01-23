package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.UserDto;

@Mapper
public interface UserDao {

	UserDto getUserInfo(String id);

	
	
}
