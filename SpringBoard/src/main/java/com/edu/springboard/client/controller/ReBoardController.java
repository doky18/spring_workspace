package com.edu.springboard.client.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springboard.domain.ReBoard;
import com.edu.springboard.exception.ReBoardException;
import com.edu.springboard.model.reboard.ReBoardService;

//답변게시판의 CRUD를 수행할 하위 컨트롤러
//component-scan의 대상이 됨
@Controller
public class ReBoardController {
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	//느슨한 관계로...
	@Autowired		//xml에 빈을 등록한 적 없으므로, 자동주입받자
	private ReBoardService reBoardService;
	
	
	//목록페이지 요청 처리
	@RequestMapping(value="/reboard/list", method=RequestMethod.GET)
	public ModelAndView getList() {
		logger.info("요청받음");
		
		List reboardList = reBoardService.selectAll();		//3단계 : 일 시키기
		
		//4단계 : 결과 저장
		ModelAndView mav = new ModelAndView("reboard/list");
		mav.addObject("reboardList", reboardList);
		
		return mav;
	}
	
	//글쓰기 폼 요청
	@GetMapping("/reboard/registform")
	public ModelAndView registForm() {
		return new ModelAndView("reboard/regist");
	}
	
	//글쓰기 
	@PostMapping("/reboard/regist")
	public ModelAndView regist(ReBoard reboard) {
		//3단계: 일시키기
		reBoardService.insert(reboard);
		
		//4단계 없음
		return new ModelAndView("redirect:/reboard/list");
	}
	
	//상세보기 요청처리
	@GetMapping("/reboard/detail")
	public ModelAndView getDetail(int reboard_idx) {		//파라미터가 있다는거,,
		
		//3단계 : 일시키기 
		ReBoard reboard = reBoardService.select(reboard_idx);
		
		//4단계 : 결과저장
		ModelAndView mav = new ModelAndView("reboard/detail");		//포워딩 할 주소
		mav.addObject("reboard", reboard);
		
		return mav;
	}
	
	//삭제요청
	@RequestMapping(value = "/reboard/del", method = RequestMethod.POST)
	public ModelAndView del(int reboard_idx) {
		reBoardService.delete(reboard_idx); //3단계 : 일시키기 
		return new ModelAndView("redirect:/reboard/list");
	}
	
	//한 건 수정요청
	@PostMapping("/reboard/edit")
	public ModelAndView edit(ReBoard reboard) {
		reBoardService.update(reboard); //3단계 : 일시키기 

		return new ModelAndView("redirect:/reboard/detail?reboard_idx="+ reboard.getReboard_idx());		//4단계 없음
	}
	
	//답변등록 요청
	@RequestMapping (value = "/reboard/reply", method = RequestMethod.POST)
	public ModelAndView reply() {
		
		/* 컨트롤러가 할 수 있지만 이까지 하면 너무 많이 함 = 모델화 됨
		 * 구체적인 일을 할 필요가 없으므로 이 부분은 model인 service에게 맡기자
		 * 
		reboardDAO.update();
		*/
		
		
		return null;
	}
	
	
	//글쓰기, 수정, 삭제의 경우 ReBoardException을 처리
	@ExceptionHandler(ReBoardException.class)
	public ModelAndView handle(ReBoardException e) {
		//에러저장
		ModelAndView mav=new ModelAndView();
		mav.addObject("e", e);
		mav.setViewName("error/result");
		
		return mav;
	}
	
}
