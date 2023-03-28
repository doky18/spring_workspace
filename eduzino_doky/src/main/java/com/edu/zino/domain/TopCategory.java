package com.edu.zino.domain;

import java.util.List;

import lombok.Data;

@Data
public class TopCategory {
	private int top_category_idx;
	private String top_name;//대분류명
	
	private List<MidCategory> midCategoryList;
}
