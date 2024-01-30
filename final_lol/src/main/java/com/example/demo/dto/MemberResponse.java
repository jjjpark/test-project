package com.example.demo.dto;

import java.time.LocalDate;
import lombok.Getter;

@Getter
//조회,삭제
public class MemberResponse {

	private Long id;                       // 회원 번호 (PK)
    private String loginId;                // 로그인 ID
    private String password;               // 비밀번호
    private String nickname;				// 닉네임
    private String gender;                 // 성별
    private LocalDate birthday;            // 생년월일
    private Boolean deleteYn;              // 삭제 여부


    public void clearPassword() {
        this.password = "";
    }

	
	
}
