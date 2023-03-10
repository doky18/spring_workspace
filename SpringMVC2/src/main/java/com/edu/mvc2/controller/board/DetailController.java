package com.edu.mvc2.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.edu.mvc2.domain.Board;
import com.edu.mvc2.model.board.BoardService;

import lombok.Setter;

//게시판의 수정 요청을 처리 할 하위 컨트롤러
//2.x 방식 (꽤 옛날 방식)
@Setter
public class DetailController implements Controller{
	//1. 상위 머시기 가져오기
	private BoardService boardService;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//2.파라미터 받기
		String board_idx=request.getParameter("board_idx");
		
		//3단계 : 일 시키기
		Board board = boardService.select(Integer.parseInt(board_idx));
		
		//4단계 : 결과 저장(jsp로 가져갈 결과)
		ModelAndView mav= new ModelAndView();		//request말고 얘가 이제 결과 받아줌
		mav.addObject("board", board);
		mav.setViewName("board/detail");
		
		return mav;
	}
}


