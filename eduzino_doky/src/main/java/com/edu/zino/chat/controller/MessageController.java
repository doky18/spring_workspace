package com.edu.zino.chat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.zino.chat.model.MessageService;
import com.edu.zino.domain.Chat;
import com.edu.zino.domain.Member;
import com.edu.zino.domain.OrderSummary;

@Controller
public class MessageController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MessageService messageService;
	
	//선생님의 수강생목록 가져오기
	@GetMapping("/chat/message")
	public ModelAndView getMessage(HttpServletRequest request) {
		
		//로그인 하면 session에서 teacher_idx를 가져오므로 getMapping으로 가져올 필요는 없음
		int teacher_idx = 1;
		
		List<OrderSummary> orderSummaryList = messageService.selectAllByTeacher(teacher_idx);
		
		
		ModelAndView mav = new ModelAndView("/teacher/chat/message");
		mav.addObject("orderSummaryList", orderSummaryList);
		
		return mav;
	}
	
	
}
