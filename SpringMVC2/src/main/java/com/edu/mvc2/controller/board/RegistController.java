package com.edu.mvc2.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.edu.mvc2.domain.Board;
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
		
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		//3단계 : 일 시키기
		boardService.insert(board);
		
		//4단계 : 저장할 사항 없음
		ModelAndView mav = new ModelAndView();
		
		//개발자가 redirect를 명시하지 않으면 default는 포워딩 방식이다
		mav.setViewName("redirect:/board/list");//이렇게만 해도 될 수 있도록 로드 아저씨가 만들어 놓음 
		//이렇게 하면 mav에 redirect:/board/list가 심어져서 응답함. 
        //이후로 디스패쳐가 InternalResourceViewResolver에게 일을시켜서 이를 해석하여 사용할 것임
		
		return mav;
	}
}
