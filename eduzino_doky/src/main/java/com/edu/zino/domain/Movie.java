package com.edu.zino.domain;

import lombok.Data;

@Data
public class Movie {
	private int movie_idx;
	private String movie_name;//커리큘럼명
	private String movie_link;//영상링크
	private Section section;//어떤 섹션인지
}
