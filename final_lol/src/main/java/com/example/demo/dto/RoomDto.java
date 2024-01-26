package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
	private int t_id;
	private String id;
	private String title;
	private String tier;
	private String position;
	private String memo;
	private String champion;
}
