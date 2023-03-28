package com.edu.zino.domain;

import java.util.List;

import lombok.Data;

@Data
public class Chat {
	private int chat_idx;
	private String chat_regdate;//생성일
	private Member member;//수강생정보
	private Member member_teacher;//강사회원정보
	
	private List<Message> messageList; //메세지정보
}
 