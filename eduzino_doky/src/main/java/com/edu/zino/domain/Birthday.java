package com.edu.zino.domain;

import lombok.Data;

@Data
public class Birthday {
	private int birthday_idx; //고유키
	private String age; //생일
	
	private Member member;
}
