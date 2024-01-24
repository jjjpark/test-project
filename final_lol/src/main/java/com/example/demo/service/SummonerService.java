package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.Summoner;
import com.example.demo.exception.SummonerNotFoundException;

@Service
public class SummonerService {

    private static final String RIOT_API_KEY = "RGAPI-839c783f-7df0-462c-8b80-1c7ea25cf990";
    private static final String RIOT_API_URL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";

    private final RestTemplate restTemplate;

    @Autowired
    public SummonerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Summoner getSummonerInfo(String summonerName) throws SummonerNotFoundException {
        try {
            String url = RIOT_API_URL + summonerName + "?api_key=" + RIOT_API_KEY;

            // Riot API로부터 소환사 정보 가져오기
            Summoner summoner = restTemplate.getForObject(url, Summoner.class);

            // 가져온 데이터에서 필요한 정보만 세팅
            Summoner result = new Summoner();
            result.setName(summoner.getName());
            result.setLevel(String.valueOf(summoner.getLevel()));

            return result;
        } catch (HttpClientErrorException.NotFound e) {
            // 404 Not Found 에러가 발생한 경우
            throw new SummonerNotFoundException("소환사를 찾을 수 없습니다.");
        }
    }
}