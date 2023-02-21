package com.edu.springshop.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//쇼핑몰 메인관련 요청 처리 컨트롤러 
@Controller
public class MainController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/main")
	public ModelAndView getMain() {
		logger.info("쇼핑몰 메인 호출됨");
		
		return null;
	}
}




