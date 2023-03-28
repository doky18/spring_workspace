package com.edu.zino.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.zino.domain.Admin;
import com.edu.zino.domain.Adminboard;
import com.edu.zino.domain.Target;
import com.edu.zino.model.admin.AdminboardService;


@Controller
@RequestMapping("/board")
public class BoardController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminboardService adminboardService;

	private String userType;
	
	
	//목록 요청 처리
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView getList(HttpServletRequest request) {
		logger.info("목록 요청을 받음");
		List adminboardList=adminboardService.selectAll();
		
		ModelAndView mav=new ModelAndView("admin/board/list");
		mav.addObject("adminboardList",adminboardList);
		return mav;
	}
	
	//글쓰기 폼 요청
	@GetMapping("/registform")
	public ModelAndView getRegist(HttpServletRequest request) {
		return new ModelAndView("/admin/board/regist");
	}
	//글쓰기 요청 처리
	@PostMapping("/regist")
	public ModelAndView getInsert(HttpServletRequest request,HttpServletResponse response, Adminboard adminboard) throws Exception{
		 
		Admin admin=new Admin();
		admin.setAdmin_idx(1);
	
		adminboard.setAdmin(admin);
		
		Target target=new Target();
		target.setTarget_idx(1);
		
		//3단계 일시키기
		adminboardService.insert(adminboard);
		ModelAndView mav=new ModelAndView("redirect:/admin/board/list");

		return mav;
	}
	
	//상세보기 요청 처리
	@GetMapping("/detail")
	public ModelAndView getDetail(int adminboard_idx,HttpServletRequest request) {
		//3단계
		Adminboard adminboard=adminboardService.select(adminboard_idx);
		
		//4단계- 결과 저장
		ModelAndView mav=new ModelAndView("/admin/board/detail");
		mav.addObject("adminboard",adminboard);
		return mav;
	}
	
	//게시믈 보기
	@GetMapping("/view")
	public ModelAndView getView(HttpServletRequest request,int adminboard_idx) {
		Adminboard adminboard=adminboardService.select(adminboard_idx);
		ModelAndView mav=new ModelAndView("/admin/board/view");
		mav.addObject("adminboard",adminboard);
		return mav;
	}
	
	//수정 폼 요청 처리
	@GetMapping("/editform")
	public ModelAndView getEditForm(int adminboard_idx,HttpServletRequest request) {
		logger.info("수정폼요청");
		
		Adminboard adminboard=adminboardService.select(adminboard_idx);
		ModelAndView mav=new ModelAndView("/admin/board/editform");
		mav.addObject("adminboard", adminboard);
		return mav;
	}
	
	//삭제폼 요청 처리
	@GetMapping("/delform")
	public ModelAndView getDelForm(int adminboard_idx, HttpServletRequest request) {
		Adminboard adminboard=adminboardService.select(adminboard_idx);
		ModelAndView mav=new ModelAndView("/admin/board/delform");
		mav.addObject("adminboard",adminboard);
		return mav;
	}
	
	//한건 수정 하기
	@PostMapping("/edit")
	public ModelAndView getEdit(HttpServletRequest requestm, Adminboard adminboard) {
		Admin admin=new Admin();
		admin.setAdmin_idx(1);
	
		adminboard.setAdmin(admin);
		
		//3단계: 일시키기
		adminboardService.update(adminboard);
		
		//4단계: 결과 
		ModelAndView mav=new ModelAndView("redirect:/admin/board/list");
		return mav;
	}
	
	//삭제 요청 처리
	@PostMapping("/del")
	public ModelAndView getDel(HttpServletRequest request, int adminboard_idx, Adminboard adminboard) {
		Admin admin=new Admin();
		admin.setAdmin_idx(1);
		adminboard.setAdmin(admin);
		
		//3단계 일시키기
		adminboardService.delete(adminboard_idx);
		//4단계 결과
		return new ModelAndView("redirect:/admin/board/list");
	}
	
}
