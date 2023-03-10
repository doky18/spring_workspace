package com.edu.mvc2.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.edu.mvc2.domain.Board;
import com.edu.mvc2.model.board.BoardService;

import lombok.Setter;

//게시판의 글쓰기 요청을 처리 할 하위 컨트롤러
//2.x 방식 (꽤 옛날 방식)
@Setter
public class EditController implements Controller{
	//1.
	private BoardService boardService;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//2. 파라미터 받기
		String board_idx=request.getParameter("board_idx");
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content = request.getParameter("content");
		
		System.out.println("제목은 "+title);
		System.out.println("작성자는 "+writer);
		System.out.println("내용은 "+content);
		
		Board board = new Board();
		board.setBoard_idx(Integer.parseInt(board_idx));
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		//3단계 : 일시키기
		boardService.update(board);
		
		//저장해도 되고, 재접속해도 되고
		ModelAndView mav= new ModelAndView();
		mav.setViewName("redirect:/board/detail?board_idx="+board_idx);
		//저장할 것 없으니까 그대로 넘겨주기
		return mav;
	}

		
}
