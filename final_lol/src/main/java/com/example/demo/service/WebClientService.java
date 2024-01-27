package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.Summoner;

@Service
public class WebClientService {
	private static final String RIOT_API_KEY = "RGAPI-839c783f-7df0-462c-8b80-1c7ea25cf990";
	private static final String RIOT_API_URL = "https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/";
	private static final String RIOT_API_URL2 = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/";

	public String getSummonerInfo(String gameName, String tagLine) {
		String url = RIOT_API_URL + gameName + "/" + tagLine + "?api_key=" + RIOT_API_KEY;
		WebClient webClient = WebClient.builder().baseUrl(url).build();
		Summoner response = webClient.get().uri(uriBuilder -> uriBuilder.build()).retrieve().bodyToMono(Summoner.class)
				.block();
		return response.getPuuid();
	}

	public List<String> getMatchIdInfo(String puuid) {
		System.out.println("service");
		String url = RIOT_API_URL2 + puuid + "/ids?start=0&count=20&api_key=" + RIOT_API_KEY;
		WebClient webClient = WebClient.builder().baseUrl(url).build();
		List<String> matchIdList = webClient.get().uri(uriBuilder -> uriBuilder.build()).retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<String>>() {
				}).block();
		return matchIdList;

	}

	public Map getgameinfo(String matchId) { // 매치id를 통해서 데이터를 받음
		String url = "https://asia.api.riotgames.com/lol/match/v5/matches/" + matchId + "?api_key=" + RIOT_API_KEY;
		WebClient webClient = WebClient.builder().baseUrl(url).build();
		Map response = webClient.get() // 맵으로 받으면 됨
				.uri(uriBuilder -> uriBuilder.build()).retrieve().bodyToMono(Map.class).block();
		return response;
	}

	public Map getgameTimelineInfo(String matchId) {
		String url = "https://asia.api.riotgames.com/lol/match/v5/matches/" + matchId + "/timeline?api_key="
				+ RIOT_API_KEY;
		WebClient webClient = WebClient.builder()
				.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(30 * 1024 * 1024)).baseUrl(url)
				.build();
		Map response = webClient.get() // 맵으로 받으면 됨
				.uri(uriBuilder -> uriBuilder.build()).retrieve().bodyToMono(Map.class).block();
		return response;
	}
}
