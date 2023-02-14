package com.edu.springboard.domain;

import lombok.Data;

@Data
public class ReBoard {
	private int reboard_idx;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int hit;
	private int team;
	private int step;
	private int depth;
}
