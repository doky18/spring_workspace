package com.edu.zino.domain;

import lombok.Data;

@Data
//준비물
public class Requirement {
	private int requirement_idx;
	private String requirement_name;//준비물명
	private Subject subject;//어떤강의의
}
