package com.edu.zino.domain;

import lombok.Data;

@Data
public class Member {
	private int member_idx;//고유키
	private String member_nickname; //닉네임
	private String member_regdate; //가입일
	private String member_id; //id
	
	private Sns sns; //로그인 방식fk
	
	//이미 멤버가 가지고 있게 되어 만들었음 has a 관계 
	private Birthday birthday; //생년월일 
	private ProfilePhoto profilePhoto; //프로필사진
	private Email email; //이메일
	
	private Blacklist blacklist; //블랙리스트
	
	private Teacher teacher; //강사정보
	
}