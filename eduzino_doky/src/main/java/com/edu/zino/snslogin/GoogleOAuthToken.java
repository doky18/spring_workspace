package com.edu.zino.snslogin;

import lombok.Data;

//구글 서버에서 전송받은 json 문자열을 자바의 객체로 담아놓기 위한 
@Data
public class GoogleOAuthToken {
	private String access_token;
	private int expires_in;	//유효기간
	private String scope;
	private String token_type;
	private String id_token;
}