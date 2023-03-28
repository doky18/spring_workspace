package com.edu.zino.domain;

import lombok.Data;

@Data
public class Blacklist {
	private int blacklist_idx;//고유키
	private String pause;//정지일(1일,2일,..,영구정지)
	private String blacklist_memo;//정지 사유
	
	private Member member;//정지당하는 유저
}
