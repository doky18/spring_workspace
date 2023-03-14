package com.edu.springshop.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springshop.domain.Member;
import com.edu.springshop.model.member.MemberService;
import com.edu.springshop.sns.GoogleLogin;
import com.edu.springshop.sns.KaKaoLogin;
import com.edu.springshop.sns.NaverLogin;
import com.edu.springshop.util.Message;

@RestController
@RequestMapping("/rest")
public class RestMemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private GoogleLogin googleLogin;
	
	@Autowired
	private KaKaoLogin kakaoLogin;
	
	@Autowired
	private NaverLogin naverLogin;
	
	//회원가입 요청 처리 
	@PostMapping("/member")
	public ResponseEntity<Message> regist(HttpServletRequest request, Member member){
		//3단계: 일 시키기
		memberService.regist(member);
		Message message = new Message();
		message.setMsg("회원가입 성공");
		
		ResponseEntity entity=new ResponseEntity<Message>(message, HttpStatus.OK);
		return entity;
	} 
	
	//로그인폼에서 사용할 SNS 인증화면의 링크 주소 요청을 처리1
	@GetMapping("/member/authform/google")
	public ResponseEntity<Message> getGoogleUrl(HttpServletRequest request, Member member){
		//사용자가 보게될 인증화면에 대한 주소 구하기 
		String url = googleLogin.getGrantUrl();	//인증화면으로 가기위한 링크주소 얻기 
		
		Message message = new Message();
		message.setMsg(url);
		
		ResponseEntity entity=new ResponseEntity<Message>(message, HttpStatus.OK);
		return entity;
	} 
	
	//로그인폼에서 사용할 SNS 인증화면의 링크 주소 요청을 처리2
	@GetMapping("/member/authform/kakao")
	public ResponseEntity<Message> getKaKaoUrl(HttpServletRequest request, Member member){
		//사용자가 보게될 인증화면에 대한 주소 구하기 
		String url = kakaoLogin.getGrantUrl();	//인증화면으로 가기위한 링크주소 얻기 
		
		Message message = new Message();
		message.setMsg(url);
		
		ResponseEntity entity=new ResponseEntity<Message>(message, HttpStatus.OK);
		return entity;
	} 
	
	
	//로그인폼에서 사용할 SNS 인증화면의 링크 주소 요청을 처리3
	@GetMapping("/member/authform/naver") //{naver}
	public ResponseEntity<Message> getNaverUrl(HttpServletRequest request, Member member){
		//사용자가 보게될 인증화면에 대한 주소 구하기 
		String url = naverLogin.getGrantUrl();	//인증화면으로 가기위한 링크주소 얻기 
		
		Message message = new Message();
		message.setMsg(url);
		
		ResponseEntity entity=new ResponseEntity<Message>(message, HttpStatus.OK);
		return entity;
	} 	 
	
	/*
	@ExceptionHandler(HashException.class)
	public ResponseEntity<Message> handle(HashException e){
		
		Message message = new Message();
		message.setMsg("회원가입 실패");
		
		ResponseEntity entity=new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	};
	
	@ExceptionHandler(EmailException.class)
	public ResponseEntity<Message> handle(EmailException e){
		
		Message message = new Message();
		message.setMsg("회원가입 실패");
		
		ResponseEntity entity=new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	};
	
	@ExceptionHandler(MemberException.class)
	public ResponseEntity<Message> handle(MemberException e){
		
		Message message = new Message();
		message.setMsg("회원가입 실패");
		
		ResponseEntity entity=new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	};
	*/
}








