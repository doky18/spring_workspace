package com.edu.db.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{
	//app 내장객체가 아니라 내장객체와 만나는 시점만 결정해주는 애임
	/*
	 * ApplicationContext (스프링 컨테이너)
	 * ServletContext (어플리케이션 내장객체의 자료형)
	 * ServletConfig (init()의 매개변수로서 초기화 파라미터인 init-param값을 가지고 있거나,
	 * 						ServletContext를 얻어올 때 사용되는 환경정보 객체)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		//어플리케이션 내장객체 얻기
		ServletContext application = sce.getServletContext();		//path정보 담아두려고
		String savePath = sce.getServletContext().getInitParameter("savePath");
		savePath = application.getRealPath(savePath);		//경로 덮어쓰기
		
		application.setAttribute("savePath", savePath); 	//공개되어있으면서 (=webapp 밑에 있는 resources)
	}

	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
