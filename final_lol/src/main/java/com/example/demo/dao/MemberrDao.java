package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.MemberRequest;
import com.example.demo.dto.MemberResponse;

@Mapper
public interface MemberrDao {

	void save(MemberRequest params);

	MemberResponse findByLoginId(String loginId);

	void update(MemberRequest params);

	void deleteById(Long id);

	int countByLoginId(String loginId);

}
