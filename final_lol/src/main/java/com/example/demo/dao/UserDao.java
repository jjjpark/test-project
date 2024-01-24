package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.UserDto;

@Mapper
public interface UserDao {

	UserDto getUserInfo(String id);

	boolean join(UserDto uDto);

	UserDto userInfo();

}
