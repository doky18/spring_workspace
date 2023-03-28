package com.edu.zino.snslogin;

import lombok.Data;

//네이버 서버에서 전송받은 json 문자열을 자바의 객체로 담아놓기 위한 
@Data
public class NaverOAuthToken {
	private String access_token;
	private String refresh_token;	//재발급 시 필요한 정보
	private String token_type;
	private int expires_in;	//유효기간
}
