package com.edu.springboard.client.controller;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springboard.domain.Notice;
import com.edu.springboard.exception.NoticeException;
import com.edu.springboard.model.notice.NoticeService;

@RestController
@RequestMapping("/rest")
public class RestNoticeController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private NoticeService noticeService;
	
	//글쓰기 요청받기
	@PostMapping("/notice/regist")
	public String regist(Notice notice) {
		logger.info("title" + notice.getTitle());
		logger.info("writer" + notice.getWriter());
		logger.info("content" + notice.getContent());
		
		//3단계 :
		noticeService.insert(notice);
		
		return "ok";		//성공실패 여부를 보내야함. 그 외에 개발자가 하고싶은 말도 보낼 수 있다
	}
	
	//글목록 요청처리
	@GetMapping("/notice/list")
	public List<Notice> getList(){
		//3단계
		List<Notice> noticeList = noticeService.selectAll();
		
		//4단계 : jsp 뷰로 가져갈 일이 없으므로 이 단계는 필요하지 않음
		return noticeList;
	}
	@ExceptionHandler(NoticeException.class)
	public String handle(NoticeException e) {
		
		return e.getMessage();
	}

}
