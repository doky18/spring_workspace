package com.edu.springshop.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.model.category.CategoryService;

//쇼핑몰의 메인을 처리하는 하위 컨트롤러 

@Controller
public class MainController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public ModelAndView getMain(HttpServletRequest request) {
		//3단계
		List categoryList = categoryService.selectAll();
		
		//4단계: 저장할 것이 있다 (왜? jsp로 가져가야 하니깐..)
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoryList", categoryList);
		mav.setViewName("shop/index");
		
		return mav;
	}
	
}







