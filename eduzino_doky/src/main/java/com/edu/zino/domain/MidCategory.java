package com.edu.zino.domain;

import java.util.List;

import lombok.Data;

@Data
public class MidCategory {
	private int mid_category_idx;
	private String mid_name;//중분류명
	private TopCategory top_category;//대분류
	
	private List<SubCategory> subCategoryList;
}
