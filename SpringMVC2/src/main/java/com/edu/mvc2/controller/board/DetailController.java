package com.edu.mvc2.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//게시판의 수정 요청을 처리 할 하위 컨트롤러
//2.x 방식 (꽤 옛날 방식)
public class DetailController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}

		
}
