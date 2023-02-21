package com.edu.springshop.domain;

import lombok.Data;

@Data
public class Product {
	private int product_idx;
	private String product_name;
	private String brand;
	private int price;
	private int discount;
	private String detail;
	
	private Category category;		//fk
}
