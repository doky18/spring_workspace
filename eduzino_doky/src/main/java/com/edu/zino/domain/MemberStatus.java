package com.edu.zino.domain;

import lombok.Data;

@Data
public class MemberStatus {
	private int memberstatus_idx;	//회원상태 고유키 
	private String memberstatus_detail;	//회원상태 1: 대기, 2: 접수, 3: 거절
	
	private Member member;
}
