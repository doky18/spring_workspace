package com.edu.springboard.android;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Vector;

//소켓을 보관하고 + 각각 독립적으로 해당 소켓을 이용하여 
//메시지를 주고받는 객체가 되어야 함 == 스레드
public class ChatThread implements Runnable{
	//Runnable은 이미 해당 클래스가 누군가의 자식일 경우 스레드를 상속할 수 없을 때 
	//사용할 수 있는 인터페이스이다.
	//주의할 점은 Runnable은 스레드 자체가 아닌, 그냥 run()메서드만을 보유한 객체이다
	//따라서 Runnable을 구현하더라도 thread 객체는 필요하다
	
	Thread thread;
	Socket socket;		//서버소켓이 접속자를 발견하면, 그때 넘겨받게 되는 소켓 
	BufferedReader buffr;		//버퍼처리된 문자기반의 입력스트림
	BufferedWriter buffw;		//버퍼처리된 문자기반의 출력스트림
	
	ChatServer chatServer;
	
	public ChatThread(Socket socket, ChatServer charServer) {	//생성자
		thread = new Thread(this);			//러너블 구현 객체를 매개변수로 넣는다
												//이때부터 Runnable의 run메서드와 스레드 객체가 연계된다
		this.socket=socket;
		this.chatServer=chatServer;
		try {
			buffr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		thread.start();
	}

	 //듣기
    public void listen() {
        String msg = null;
        try {
            msg = buffr.readLine();
            
            //디자인 제어는 오직 메인스레드에서만 가능하다
            //아래의 코드는 현재 클래스가 개발자 정의 스레드이므로, 즉 메인이 아닌 스레드이므로, 디자인을 제어할 수 없다
            //따라서 직접 디자인을 제어하려 하지말고, 메인 스레드에게 부탁해야 한다...
            //이때 사용되는 객체가 바로 Handler.os 패키지의 Handler 객체이다
            System.out.println("클라이언트 msg :"+msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //나에게만 보내지말고 모든 쓰레드 객체가 가진 send()메서드를 호출하자
        //-> Broad Casting
        for(int i=0;i<chatServer.clientList.size();i++) {
            ChatThread ct = chatServer.clientList.get(i);
            ct.send(msg);
        }
    }
		
		//말하기
		public void send(String msg) {
			try {
				buffw.write(msg+"\n");
				buffw.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	//무한청취 시작
	public void run() {
		while(true) {
			listen();		
			
		}
	}

}
