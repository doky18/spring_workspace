package com.edu.springboard.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Gallery {
	private int gallery_idx;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int hit;
	private List<Photo> photoList;		//mybatis의 collection을 위한 변수
	
	MultipartFile[] photo;//apache file upload 구현
    //변수명이 클라이언트와 일치해야함
}
