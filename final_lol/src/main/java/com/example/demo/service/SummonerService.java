package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SummonerService {
	@Autowired
	WebClientService webClient;

	public String puuId(String gameName, String tagLine) {
		String puuId = webClient.getSummonerInfo(gameName,tagLine);
		return puuId;
	}

	public List<String> matchIdList(String puuid) {
		List<String> matchIdList = webClient.getMatchIdInfo(puuid);
		return matchIdList;
	}

	public List<Map> gameInfoList(List<String> matchId) {
		List<Map> gameInfoList = new ArrayList<>();
		for (int i = 0; i < matchId.size(); i++) {
			Map gameInfo = webClient.getgameinfo(matchId.get(i));
			gameInfoList.add(gameInfo);
		}
		return gameInfoList;
	}

}