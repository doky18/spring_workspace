package com.edu.springboard.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springboard.domain.Notice;

@RestController
public class RestNoticeController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//글쓰기 요청받기
	@PostMapping("/rest/notice/regist")
	public String regist(Notice notice) {
		logger.info("title" + notice.getTitle());
		logger.info("writer" + notice.getWriter());
		logger.info("content" + notice.getContent());
		
		return "test";
		
	}

}
