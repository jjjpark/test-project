package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.RoomDto;

@Mapper
public interface RoomDao {
	boolean roomcreate(RoomDto rDto);
	List<RoomDto> roomsearch();
}
