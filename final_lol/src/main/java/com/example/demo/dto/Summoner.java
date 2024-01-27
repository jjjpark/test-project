package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Summoner {
    private String gameName;
    private String tagLine;
    private String puuid;
    private List<String> matchId;

    // 생성자, getter, setter 등 필요한 메소드 추가
}
