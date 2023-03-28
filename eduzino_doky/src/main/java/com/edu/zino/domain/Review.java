package com.edu.zino.domain;

import lombok.Data;

@Data
//수강평
public class Review {
	private int review_idx;
	private int review_rate;//별점(1~5)
	private String review_content;//수강평
	private String review_regdate;
	private Member member;//작성자
	private Subject subject;//강의
}
