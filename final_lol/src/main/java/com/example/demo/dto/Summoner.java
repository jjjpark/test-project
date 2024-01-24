package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Summoner {
    private String name;
    private String level;
//    // 다른 필드들도 추가 가능
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getLevel() {
//		return level;
//	}
//	public void setLevel(String level) {
//		this.level = level;
//	}

    // 생성자, getter, setter 등 필요한 메소드 추가
}
