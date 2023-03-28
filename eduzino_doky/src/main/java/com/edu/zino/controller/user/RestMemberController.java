package com.edu.zino.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.zino.domain.Member;
import com.edu.zino.model.member.MemberService;
import com.edu.zino.snslogin.GoogleLogin;
import com.edu.zino.snslogin.KaKaoLogin;
import com.edu.zino.snslogin.NaverLogin;
import com.edu.zino.util.MessageUtil;

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
	public ResponseEntity<MessageUtil> regist(HttpServletRequest request, Member member){
		//3단계: 일 시키기
		memberService.insert(member);
		MessageUtil message = new MessageUtil();
		message.setMsg("회원가입 성공");
		
		ResponseEntity entity=new ResponseEntity<MessageUtil>(message, HttpStatus.OK);
		return entity;
	} 
	
	//로그인폼에서 사용할 SNS 인증화면의 링크 주소 요청을 처리1
	@GetMapping("/member/authform/google")
	public ResponseEntity<MessageUtil> getGoogleUrl(HttpServletRequest request, Member member){
		//사용자가 보게될 인증화면에 대한 주소 구하기 
		String url = googleLogin.getGrantUrl();	//인증화면으로 가기위한 링크주소 얻기 
		
		MessageUtil message = new MessageUtil();
		message.setMsg(url);
		
		ResponseEntity entity=new ResponseEntity<MessageUtil>(message, HttpStatus.OK);
		return entity;
	} 
	
	//로그인폼에서 사용할 SNS 인증화면의 링크 주소 요청을 처리2
	@GetMapping("/member/authform/kakao")
	public ResponseEntity<MessageUtil> getKaKaoUrl(HttpServletRequest request, Member member){
		//사용자가 보게될 인증화면에 대한 주소 구하기 
		String url = kakaoLogin.getGrantUrl();	//인증화면으로 가기위한 링크주소 얻기 
		
		MessageUtil message = new MessageUtil();
		message.setMsg(url);
		
		ResponseEntity entity=new ResponseEntity<MessageUtil>(message, HttpStatus.OK);
		return entity;
	} 
	
	
	//로그인폼에서 사용할 SNS 인증화면의 링크 주소 요청을 처리3
	@GetMapping("/member/authform/naver") //{naver}
	public ResponseEntity<MessageUtil> getNaverUrl(HttpServletRequest request, Member member){
		//사용자가 보게될 인증화면에 대한 주소 구하기 
		String url = naverLogin.getGrantUrl();	//인증화면으로 가기위한 링크주소 얻기 
		
		MessageUtil message = new MessageUtil();
		message.setMsg(url);
		
		ResponseEntity entity=new ResponseEntity<MessageUtil>(message, HttpStatus.OK);
		return entity;
	} 	 
}







