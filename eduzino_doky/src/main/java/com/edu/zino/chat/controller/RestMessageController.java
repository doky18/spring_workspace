package com.edu.zino.chat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.zino.chat.model.MessageService;
import com.edu.zino.domain.Chat;
import com.edu.zino.domain.Member;
import com.edu.zino.util.MessageUtil;


@RestController
@RequestMapping("/rest")
public class RestMessageController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MessageService messageService;
	
	
	
	//채팅방조회 & 생성
	@PostMapping("/{teacher_user}/chat/message")
	public List<Chat> insertOrSelectAll(HttpServletRequest request, @PathVariable String teacher_user, @RequestBody Chat chat){
		
		
		
		List<Chat> chatList = null;
		
		logger.info("chat is "+chat);
		
		
		
		//로그인 하면 session에서 로그인 정보를 가져오므로 get으로 가져올 필요는 없음
		Member member = new Member();
		if(chat.getMember_teacher() == null) {
			//선생님이 방 생성 요청 시
			int member_teacher_idx = 1;
			member.setMember_idx(member_teacher_idx);
			chat.setMember_teacher(member);
			
		}else {
			//수강생이 방 생성 요청 시
			int member_idx = 1;
			member.setMember_idx(member_idx);
			chat.setMember(member);
			
		}
		logger.info("chat2 is "+chat);
		
		chatList = messageService.selectAll(chat); //채팅방 전체 조회하기
		
		Chat chatRoom= messageService.select(chat); //채팅방이 있는지 없는 지 판단하기
		logger.info("채팅방이 있나요? "+chatRoom);
		
		//3단계
		if(chatRoom == null && chat.getMember().getMember_idx() !=0 && chat.getMember_teacher().getMember_idx() != 0) {
			messageService.insert(chat); //채팅방 생성하기			
		}
		
		return chatList;
	}
	
	
	
	

}
