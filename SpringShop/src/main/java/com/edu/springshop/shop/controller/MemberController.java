package com.edu.springshop.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.domain.Member;
import com.edu.springshop.model.member.MemberService;

//회원관 관련된 요청을 처리하는 하위 컨트롤러 
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//회원가입 폼 요청처리
	@GetMapping("/member/joinform")
	public ModelAndView getJoinForm(HttpServletRequest request) {
		
		return new ModelAndView("shop/member/joinform");
	} 
	
	//로그인 폼 요청처리
	@GetMapping("/member/loginform")
	public ModelAndView getLoginForm(HttpServletRequest request) {
		
		return new ModelAndView("shop/member/loginform");
	}
	
	//회원가입 요청 처리 
	//HttpServletRequest를 넣어야 하는이유?  AOP적용을 위한 CategoryAdvice 코드에
	//요청을 낚아채어, request 를 사용중이므로...
	@PostMapping("/member/regist")
	public ModelAndView regist(HttpServletRequest request, Member member) {
		//3단계: 
		memberService.regist(member);
		ModelAndView mav = new ModelAndView("redirect:/member/loginform");
		return mav;
	}
	
	//상담게시판 페이지 요청 처리 
	@GetMapping("/member/chatform")
	public ModelAndView getChatForm(HttpServletRequest request){
		ModelAndView mav=new ModelAndView("shop/member/chat");
		return mav;
	}
	
}






