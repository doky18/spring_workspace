package com.edu.zino.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.zino.model.admin.AdminboardService;

@Controller
public class AdminController {

	@Autowired
	private  AdminboardService adminboardService;
	
	@GetMapping("/board")
	public ModelAndView getBoard(HttpServletRequest request) {
		
		List adminboardList=adminboardService.selectAll();
		
		ModelAndView mav=new ModelAndView("/admin/board/board_main");
		mav.addObject("adminboardList",adminboardList);
		return mav;
	}	
	 
	@GetMapping("/index")
	public String getIndex() {
		return "/admin/index";
	}

	/* ----------------------------------
				관리자 로그인
	------------------------------------ */

	
	@GetMapping("/login")
	public ModelAndView getLogin(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/member/login");
		return mav;
	}
	
	/* ----------------------------------
	 			전체 회원 관리
	 ------------------------------------ */
	@GetMapping("/member")	//전체 회원 목록
	public ModelAndView getMember(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/member/list");
		return mav;
	}
	
	@GetMapping("/member/detail")	//회원 한 명 상세보기 
	public ModelAndView getMemberDetail(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/member/detail");
		return mav;
	}
	

	@GetMapping("/member/blacklist")	//정지 회원 목록
	public ModelAndView getBlacklist(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/member/blacklist");
		return mav;
	}

	@GetMapping("/member/blackdetail")	//정지 회원 한 명 상세보기 
	public ModelAndView getBlackDetail(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/member/blackdetail");
		return mav;
	}
	
	
}
