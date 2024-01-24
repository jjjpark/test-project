package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class roomDto {
	private String id;
	private String title;
	private String tier;
	private String position;
	private String memo;
}
