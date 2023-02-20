package com.edu.springboard.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springboard.domain.Notice;
import com.edu.springboard.model.notice.NoticeService;

@RestController
@RequestMapping("/rest")
public class RestAPINoticeController {
	
	@Autowired
	private NoticeService noticeService;
	//REST 를 준수하여 URL을 매핑해보자 (RESTful)
	
	//목록요청
	@GetMapping("/notices")
	public List<Notice> selectAll() {		//json이 제대로 변환돼서 올 수 있음 
		return noticeService.selectAll();
	}
	
	//상세보기 요청 /notice/23
	@GetMapping("/notices/{notice_idx}")
	public Notice select(@PathVariable("notice_idx")int notice_idx) {	//변수가 아닌 경로로 생각
		return noticeService.select(notice_idx);
	}
	
	//삭제하기 요청
	@DeleteMapping("/notice/{notice_idx}")
	public String del(@PathVariable("notice_idx")int notice_idx) {
		noticeService.delete(notice_idx);
		return "deleted";
	}
	
	//수정요청
	@PutMapping("/notices")
	public String edit(Notice notice) {
		noticeService.update(notice);
		return "updated";
	}
	
	//등록요청
	@PostMapping("/notices")
	public String regist(Notice notice) {
		return "regist ok";
	}
}
