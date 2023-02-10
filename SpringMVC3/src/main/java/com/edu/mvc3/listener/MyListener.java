package com.edu.mvc3.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		String dataPath = application.getInitParameter("dataPath"); 	//web.xml에 지정해둔 경로를 파라미터로 끄집어내기
		String path = application.getRealPath(dataPath);
		application.setAttribute("dataPath", path);  
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
