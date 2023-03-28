package com.edu.zino.chat.model;

import java.util.List;

import com.edu.zino.domain.Chat;

public interface MessageService {
	//수강생조회하기
	public List selectAllByTeacher(int teacher_idx); //OrderSummaryMapper
	
	public Chat select(Chat chat); //채팅방 한건 조회
	
	public List selectAll(Chat chat); //채팅방조회 : 강사,유저구분
	
	public void insert(Chat chat); //채팅방 개설하기 : member_idx(채팅방주인/강사페이지:강사/유저페이지:유저)
}
