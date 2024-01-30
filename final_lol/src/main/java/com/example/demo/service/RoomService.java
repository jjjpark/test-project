package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoomDao;
import com.example.demo.dto.RoomDto;

@Service
public class RoomService {
	@Autowired
	private RoomDao rDao;
	
	public List<RoomDto> roomsearch(){
		List<RoomDto> rList=rDao.roomsearch();
		return rList;
	}
	
	public List<RoomDto> roomInfo() {
		List<RoomDto> rList = rDao.roomData();
	    return rList;
	}
	
	public List<RoomDto> roominsert(RoomDto rDto) {
		boolean check=rDao.roomcreate(rDto);
		if(check) {return roomInfo();}
		else {return null;}
	}

	public RoomDto roomDelete(RoomDto rDto) {
		RoomDto rd = rDao.deleteRoom(rDto);
		return rd;
	}
}
