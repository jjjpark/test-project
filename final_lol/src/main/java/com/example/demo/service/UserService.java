package com.example.demo.service;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
}
=======
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;

@Service
public class UserService {

	@Autowired
	private UserDao uDao;

	public List<UserDto> getUserList() {
        return uDao.getUserList();
    }
	
	public void register(UserDto userDto) {
		uDao.insertUser(userDto);
	}

	
	
	    }
>>>>>>> 8ee57d56921c3022c0de2b7b2c2bd56467dd8554
