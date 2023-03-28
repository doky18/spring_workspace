package com.edu.zino.domain;

import lombok.Data;

@Data
public class Subject {
	private int subject_idx;
	private String subject_title;//제목
	private String subject_subTitle;//부제목
	private String subject_pic;//강의 이미지
	private int subject_price;//가격
	private String subject_detail;//강의 설명
	private Teacher teacher;//강사
	private SubCategory sub_category;//소분류
}
