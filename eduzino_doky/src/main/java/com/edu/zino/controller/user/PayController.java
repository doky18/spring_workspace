package com.edu.zino.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PayController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//결제창 보여주기
	@GetMapping("/pay/payment")
	public ModelAndView getPay(HttpServletRequest request) {
		return new ModelAndView("/user/pay/payment");
	}
	

	@GetMapping("/pay/payment1")
	public ModelAndView cartTopay(HttpServletRequest request){
		
		logger.info("토스로부터 받은 결제완료 콜백");
		//성공했으니 db에 내용 추가하면 된다
		
		//4단계
	
		return null;
	}
}
