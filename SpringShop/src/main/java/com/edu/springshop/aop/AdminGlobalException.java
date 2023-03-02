package com.edu.springshop.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.exception.AdminException;
/*
 * 이 클래스는 관리자와 관련된
 * */

@ControllerAdvice(annotations = Controller.class)		//Controller : streotype 으로 import 받아야 한다
public class AdminGlobalException {
	private Logger logger = LoggerFactory.getLogger(getClass());
    //동기, 비동기 상관 없이 작성함

    @ExceptionHandler(AdminException.class)
    public ModelAndView handle(AdminException e) {
    	logger.info("관리자 (일반)글로벌 예외 호출");
    	
        ModelAndView mav = new ModelAndView("admin/error/result");
        mav.addObject("e", e);
        return mav;
    }
}