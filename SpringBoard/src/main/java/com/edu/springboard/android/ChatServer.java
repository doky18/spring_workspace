package com.edu.springboard.android;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {
	ServerSocket server;		//대화용이 아닌, 접속 감지용 서버소캣
	Thread thread;				//실행부를 루프나 대기 상태에 빠지지 않기 위한 스레드 생성
	
	//접속자 명단
		//ArrayList 좋은 방법이긴 하지만, 스레드간에 충돌을방지
		//원천 방지하기 (서로 간섭) 위해서는 Vector()를 사용하자
		Vector<ChatThread> clientList = new Vector<ChatThread>();
	
		public ChatServer() {
			thread = new Thread() {
				@Override
				public void run() {
					try {
						server= new ServerSocket(8000);
						System.out.println("서버소켓 생성");
						
						while(true) {//다수의 접속자 무한 감지
	                        Socket socket = server.accept();
	                        ChatThread chatThread = new ChatThread(socket,ChatServer.this);
	                        clientList.add(chatThread);
	                        System.out.println("접속자 수 : "+clientList.size());
	                    }
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        };
	        thread.start();
	    }
	    
	    public static void main(String[] args) {
	        new ChatServer();
	    }
	}