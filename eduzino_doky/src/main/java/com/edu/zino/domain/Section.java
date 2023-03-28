package com.edu.zino.domain;

import lombok.Data;

@Data
public class Section {
	private int section_idx;
	private String section_name;//섹션명
	private Subject subject;//어떤강의 인지
}
