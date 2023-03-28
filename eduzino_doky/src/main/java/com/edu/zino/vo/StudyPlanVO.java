package com.edu.zino.vo;

import lombok.Getter;

@Getter
public class StudyPlanVO {
	int stataus;
	String name;
	public StudyPlanVO(int status, String name) {
		this.stataus = status;
		this.name = name;
	}
}
