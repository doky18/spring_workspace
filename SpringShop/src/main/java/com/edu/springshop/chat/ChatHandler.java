package com.edu.springshop.chat;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

//웹소켓 요청을 처리할 핸들러
//TextWebSocketHandler : 이미지, 동영상 , 텍스트 다 가능하지만, 우리의 목적은
//채팅이기 때문에 Text~~ 기반의 핸들러를 재정의 한다 
public class ChatHandler extends TextWebSocketHandler{
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	//접속자를 보관할 리스트 
	List<WebSocketSession> sessionList=new ArrayList<WebSocketSession>();
	
	
	//클라이언트가 접속하면... 
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("afterConnectionEstablished 호출");
		sessionList.add(session); //접속자 추가
		logger.info("현재 접속자 수는 "+sessionList.size());
	}
	
	//메시지가 도착하면...
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String msg=message.getPayload();
		logger.info("클라이언트가 보낸 메시지 "+msg);
		
		TextMessage data = new TextMessage("서버의 말:"+message.getPayload());
		
		//접속한 모든 사용자에게 메시지 보내기 (브로드 케스팅)
		for(WebSocketSession ss : sessionList) {
			ss.sendMessage(data);
		}
	}
	
	//접속이 끊기면...
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.info("afterConnectionClosed 호출..");
		sessionList.remove(session);
	}
}






