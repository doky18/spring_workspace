package com.edu.db.client.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.db.domain.Board;
import com.edu.db.exception.BoardException;
import com.edu.db.model.board.BoardService;

//커뮤ㅗ넌트 스캔의 대상이 될때는 어노테이션을 붙이면 된다
@Controller
public class BoardController {
	Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	
	//6. 일시키기 위해서 연결 
	@Autowired
	private BoardService boardService;
	
	//글쓰기 폼 요청처리
	@RequestMapping(value="/board/registform", method=RequestMethod.GET)
	public String registForm() {	//registForm은 view 영역(폼을 보여주기만), 얘는 마중물 같은 존재인가요? 
		return "board/regist";			//regist는 db랑 연결되어서,,, 
	}
	
	//글쓰기 요청처리
	@RequestMapping(value="/board/regist", method=RequestMethod.POST)
	public ModelAndView	regist(Board board) {
		logger.info("글쓰기 요청받음1");		//->: com.edu.db.client.controller.BoardController - 글쓰기 요청받음1 ()
		//System.out.println("글쓰기 요청 받음 2");		->글쓰기 요청 받음 2
		boardService.insert(board);			//BoardEcveption이 발생될 수 있
		ModelAndView mav = new ModelAndView("redirect:/board/list");

		return mav;
	}
	
	//목록 요청처리
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public String getList(Model model) {		//ModelAndView를 나눔. String형으로 가고 Model은 매개변수로
		//3단계:
		List boardList = boardService.selectAll();
		
		//4단계:
		//ModelAndView mav = new ModelAndView();		매개변수로 가져왔으니까 이렇게 안해도 됨
		model.addAttribute("boardList", boardList);
		
		return "board/list";
	}
	
	//상세보기
	@RequestMapping(value="/board/detail", method=RequestMethod.GET)
	public ModelAndView getDetail(int board_idx) {
		//3단계:
		Board board = boardService.select(board_idx);
		
		//4단계:
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);		//결과저장 : model처리
		mav.setViewName("board/detail");		//view 처리
		
		return mav;
	}
	
	//수정요청 처리
	@RequestMapping(value="/board/edit", method=RequestMethod.POST)
	public ModelAndView edit(Board board) {
		//3단계:
		boardService.update(board);
		
		//4단계: 생략, 즉 상세보기를 재접속 redirect
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/detail?board_idx=" +board.getBoard_idx());
		return mav;
	}
	
	//삭제요청 처리
	@RequestMapping(value="/board/delete", method = RequestMethod.POST)
	public String del(int board_idx) {
		//3단계
		boardService.delete(board_idx);
		
		//4단계가 없으므로 재접속 시도
		return "redirect:/board/list";
	}
	
	//현재 컨트롤러 클래스 내에서 발생되는 예외 중, @ExceptionHandler에 명시된 예외의 자료형이 발견되면
	//아래의 지정된 메서드가 수행됨
	@ExceptionHandler(BoardException.class)
	public ModelAndView handle(BoardException e) {
		
		//에러 정보를 저장하고, 에러 전용페이지 보여주기
		ModelAndView mav = new ModelAndView();
		mav.addObject("e", e);			//request 객체에 저장하게 됨
		mav.setViewName("error/result");
		
		return mav;
	}

}
