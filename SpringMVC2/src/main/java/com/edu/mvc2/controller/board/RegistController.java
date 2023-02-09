package com.edu.mvc2.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.edu.mvc2.model.board.BoardService;

import lombok.Setter;

//게시판의 상세보기 요청을 처리 할 하위 컨트롤러
//2.x 방식 (꽤 옛날 방식)

@Setter
public class RegistController implements Controller{
	private BoardService boardService;		//최상위 객체 뭐????????
	
	Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("게시판 등록처리");
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content = request.getParameter("content");
		
		System.out.println("제목은 "+title);
		System.out.println("작성자는 "+writer);
		System.out.println("내용은 "+content);
		return null;
	}
}
