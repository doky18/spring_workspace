package com.edu.zino.domain;

import lombok.Data;

@Data
public class Teacherboard {
	private int teacherboard_idx;
	private String teacherboard_title;//제목
	private String teacherboard_content;//내용
	private String teacherboard_regdate;//작성일
	private int teacherboard_sort;//필독여부
	private Teacher teacher;//작성자
}
