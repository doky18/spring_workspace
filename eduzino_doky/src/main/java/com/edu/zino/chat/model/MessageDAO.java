package com.edu.zino.chat.model;

import java.util.List;

import com.edu.zino.domain.Chat;

public interface MessageDAO {
	//수강생 조회하기
	public List selectAllByTeacher(int teacher_idx); //OrderSummaryMapper
	
	public Chat select(Chat chat); //채팅방 한건 조회
	
	public List selectByStudent(int member_idx); //수강생한명 채팅방 전체 검색
	public List selectByTeacher(int member_teacher_idx); //강사한명 채팅방 전체 검색
	
	public void insert(Chat chat); //채팅방 개설하기 : member_idx(채팅방주인/강사페이지:강사/유저페이지:유저)
	
}
