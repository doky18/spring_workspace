package com.edu.zino.domain;

import lombok.Data;

@Data
public class Adminboard {
	private int adminboard_idx;
	private String adminboard_title;//게시판 제목
	private String adminboard_content;//게시판 내용
	private String adminboard_regdate;//게시판 작성일
	private int adminboard_sort;//필독 여부 
	private Target target;//공지대상
	private Admin admin;//작성한 관리자
}
