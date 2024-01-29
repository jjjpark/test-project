package com.example.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dao.MemberrDao;
import com.example.demo.dto.MemberRequest;
import com.example.demo.dto.MemberResponse;

@Service
public class MemberService {

	private MemberrDao mDao;
	private PasswordEncoder passwordEncoder;

	
	@Transactional
	public Long saveMember(MemberRequest params) {
		params.encodingPassword(passwordEncoder);
		mDao.save(params);
		return params.getId();
	}

	public MemberResponse findMemberByLoginId(final String loginId) {
		return mDao.findByLoginId(loginId);
	}

	@Transactional
	public Long updateMember(final MemberRequest params) {
		params.encodingPassword(passwordEncoder);
		mDao.update(params);
		return params.getId();
	}

	@Transactional
	public Long deleteMemberById(final Long id) {
		mDao.deleteById(id);
		return id;
	}


}
