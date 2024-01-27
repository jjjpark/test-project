package com.example.demo.exception;


public class SummonerNotFoundException extends RuntimeException {

    public SummonerNotFoundException(String message) {
        super(message);
    }
}
