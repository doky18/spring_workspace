package com.edu.zino.domain;

import lombok.Data;

@Data
public class Grade {
	private int grade_idx;//고유키
	private int grade_rank;//1: 최상위 관리자 2: 중간관리자  3:하급관리자
}
