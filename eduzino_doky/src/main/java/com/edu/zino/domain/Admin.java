package com.edu.zino.domain;

import lombok.Data;

@Data
public class Admin {
	private int admin_idx;//고유키
	private String admin_id;//아이디
	private String admin_pass;//비번
	
	private Grade grade;//등급
}
