package com.edu.zino.domain;

import lombok.Data;

@Data
public class Message {
	private int message_idx;
	private String message_content;//메세지내용
	private String message_regdate;//보낸시간
	private int message_check;//확인여부
	private Member me;//누가
	private Member you;//누구에게
	private Chat chat;//어느 채팅방에서
}
