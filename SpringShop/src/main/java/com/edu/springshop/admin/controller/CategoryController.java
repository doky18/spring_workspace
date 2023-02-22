package com.edu.springshop.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
	
	//카테고리관리 메인 요청 
	@GetMapping("/category/main")
	public ModelAndView getMain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/category/category_main");
		
		return mav;
	}
}





