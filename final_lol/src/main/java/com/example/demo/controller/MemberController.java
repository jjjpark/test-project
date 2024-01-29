package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.MemberRequest;
import com.example.demo.dto.MemberResponse;
import com.example.demo.service.MemberService;

@Controller

public class MemberController {

    private MemberService mService;

    // 로그인 페이지
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    // 회원 정보 저장 (회원가입)
    @PostMapping("/members")
    public Long saveMember(MemberRequest params) {
        return mService.saveMember(params);
    }

    // 회원 상세정보 조회
    @GetMapping("/members/{loginId}")
    public MemberResponse findMemberByLoginId(@PathVariable  String loginId) {
        return mService.findMemberByLoginId(loginId);
    }

    // 회원 정보 수정
    @PatchMapping("/members/{id}")
    public Long updateMember(@PathVariable Long id, MemberRequest params) {
        return mService.updateMember(params);
    }

    // 회원 정보 삭제 (회원 탈퇴)
    @DeleteMapping("/members/{id}")
    public Long deleteMemberById(final Long id) {
        return mService.deleteMemberById(id);
    }

}