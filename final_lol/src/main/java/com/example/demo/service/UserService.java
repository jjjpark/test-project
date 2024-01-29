package com.example.demo.service;


import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;

@Service
public class UserService {

	@Autowired
	private UserDao uDao;

	public List<UserDto> getUserList() {
        return uDao.getUserList();
    }
	
	    }

