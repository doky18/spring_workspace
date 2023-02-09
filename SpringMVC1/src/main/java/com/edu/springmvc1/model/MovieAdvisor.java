package com.edu.springmvc1.model;

public class MovieAdvisor {
	public String getAdvice(String movie) {	//파라미터에 String movie 적음으로서 중립적으로 만듦
		//----------------------로직-----------------------------    
	    String msg=null; //결과 메시지를 담을 변수
	    if(movie.equals("슬램덩크")){
	        msg="정대만 멋있다";
	    }else if(movie.equals("아바타2")){
	        msg="용아맥 자리없음";
	    }else if(movie.equals("앤트맨3")){
	        msg="용아맥으로 봐야지";
	    }else if(movie.equals("테넷")){
	        msg="또 보고 싶다";
	    }
	    
	    return msg;
	}
}
