package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.Summoner;
import com.example.demo.exception.SummonerNotFoundException;
import com.example.demo.service.SummonerService;

@Controller
public class SummonerController {

    @Autowired
    private SummonerService summonerService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam("summonerName") String summonerName, Model model) throws SummonerNotFoundException {
        Summoner summoner = summonerService.getSummonerInfo(summonerName);
        model.addAttribute("summoner", summoner);
        return "search-results";
    }
}