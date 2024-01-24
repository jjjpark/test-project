package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.RoomDao;
import com.example.demo.dto.RoomDto;

@Service
public class RoomService {

	private RoomDto rDto;
	private RoomDao rDao;
	public List<RoomDto> roomsearch(){
		List<RoomDto> rList=rDao.roomsearch();
		return rList;
	}
	
	public List<RoomDto> roominsert(RoomDto rDto) {
		boolean check=rDao.roomcreate(rDto);
		if(check) {return roomsearch();}
		else {return null;}
	}
}
