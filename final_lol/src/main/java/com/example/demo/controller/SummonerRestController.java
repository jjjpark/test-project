package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Summoner;
import com.example.demo.service.SummonerService;

@RestController
public class SummonerRestController {
	@Autowired
	private SummonerService summonerService;

	@PostMapping("/search")
	public List<Map> matchId(Summoner gameName, Summoner tagLine) {
		String puuid = summonerService.puuId(gameName.getGameName(),tagLine.getTagLine());
		List<String> matchIdList = summonerService.matchIdList(puuid);
		List<Map> gameInfoList = summonerService.gameInfoList(matchIdList);
		return gameInfoList;
	}
}
