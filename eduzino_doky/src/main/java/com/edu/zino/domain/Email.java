package com.edu.zino.domain;

import lombok.Data;

@Data
public class Email {
	private int email_idx; //고유키
	private String email_addr; //이메일주소
	
	private Member member;
}
