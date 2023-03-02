package com.edu.springshop.aop;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.exception.EmailException;
import com.edu.springshop.exception.HashException;
import com.edu.springshop.exception.MemberException;

//쇼핑몰과 관련된 글로벌 (전역적) 예외객체를 정의하되,
//jsp로 에러 결과를 보여줘야하므로, 반환값이 ModelAndView가 되어야 함
@ControllerAdvice(annotations = Controller.class)
public class ShopGlobalException {
	
	@ExceptionHandler(HashException.class)
	public ModelAndView handle(HashException e) {
		ModelAndView mav = new ModelAndView("shop/error/result");
		mav.addObject("e", e);		//에러 심기
		
		return mav;
	}
	
	@ExceptionHandler(EmailException.class)
	public ModelAndView handle(EmailException e) {
		ModelAndView mav = new ModelAndView("shop/error/result");
		mav.addObject("e", e);		//에러 심기
		
		return mav;
	}
	
	@ExceptionHandler(MemberException.class)
	public ModelAndView handle(MemberException e) {
		ModelAndView mav = new ModelAndView("shop/error/result");
		mav.addObject("e", e);		//에러 심기
		
		return mav;
	}

}
