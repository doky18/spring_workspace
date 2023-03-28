package com.edu.zino.util;

import lombok.Data;

//클라이언트에게 응답으로 보낼 메세지 객체
@Data
public class MessageUtil {
	private int code;
	private String msg;
}
