package com.edu.springshop.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.model.category.CategoryService;

//상품과 관련된 요청을 처리하는 하위 컨트롤러 
@Controller
public class ProductController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/product/registform")
	public ModelAndView getForm() {
		//3단계 
		List categoryList=categoryService.selectAll();
		
		//4단계 
		ModelAndView mav =new ModelAndView("admin/product/regist");
		mav.addObject("categoryList", categoryList);
		
		return mav;
	}
}







