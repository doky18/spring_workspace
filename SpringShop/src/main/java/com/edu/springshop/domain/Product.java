package com.edu.springshop.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
	private int product_idx;
	private String product_name;
	private String brand;
	private int price;
	private int discount;
	private String detail;
	private Category category; //fk
	private List<Pimg> pimgList;		//리스트로 보유중....
	private MultipartFile[] photo; //html에서 전송되는 파라미터명과 일치..
	
	
}



