package com.edu.zino.domain;

import lombok.Data;

@Data
//학습목표
public class Goal {
	private int goal_idx;
	private String goal_name;//학습목표
	private Subject subject;//어떤 강의의
}
