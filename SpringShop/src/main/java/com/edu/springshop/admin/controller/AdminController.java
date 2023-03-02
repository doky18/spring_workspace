package com.edu.springshop.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.domain.Admin;
import com.edu.springshop.exception.AdminException;
import com.edu.springshop.model.admin.AdminService;

@Controller
public class AdminController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminService adminService;
	
	//로그인 폼 요청처리
	@GetMapping("/loginform")
	public ModelAndView getLoginForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/login/loginform");
		return mav;
	}
	
	//로그인 요청처리
	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest request, Admin admin) {
										//aop가 실시간으로 우릴 낚아채고 있기때문에 해주는 것
										//낚아채서 뭘 하는데? -> 관리자 측 aop (AdminLoginCheckAdvice) :
										//로그인 하러 왔는데 로그인 해주세요 할 수 없으니까 이건 제외시켜 주어야 함
		//3단계:
		adminService.select(admin);
		
		ModelAndView mav = new ModelAndView("redirect:/admin/main");
		return mav;
	}
	
	@GetMapping("/main")
	public ModelAndView getMain(HttpServletRequest request) {	//매개변수가 없으면 전달하려는 낚아챌 수 없음
											//로그인이 필요한 서비스라면 이건 필수로 있어야 한다
		logger.info("관리자 메인 호출됨");
		
		//로그인 인증 여부를 따져봐야 한다...
		HttpSession session = request.getSession();
		Admin admin=(Admin)session.getAttribute("admin");
		ModelAndView mav = new ModelAndView();
		
		if(admin==null) {
			throw new AdminException("로그인이 필요한 서비스입니다");
		}else {
			mav.setViewName("admin/index");  //정상링크
		}
		return mav;
	}
	
	/*
	   @ExceptionHandler(AdminException.class)
    public ModelAndView handle(AdminException e) {
        ModelAndView mav = new ModelAndView("admin/error/result");
        mav.addObject("e", e);
        return mav;
    }
	*/
}




