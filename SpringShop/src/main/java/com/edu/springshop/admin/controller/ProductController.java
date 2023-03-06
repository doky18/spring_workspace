package com.edu.springshop.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.domain.Product;
import com.edu.springshop.model.category.CategoryService;
import com.edu.springshop.model.product.ProductService;

//상품과 관련된 요청을 처리하는 하위 컨트롤러 
@Controller
public class ProductController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/product/registform")
	public ModelAndView getForm(HttpServletRequest request) {
		//3단계 
		List categoryList=categoryService.selectAll();
		
		//4단계 
		ModelAndView mav =new ModelAndView("admin/product/regist");
		mav.addObject("categoryList", categoryList);
		
		return mav;
	}
	
	@GetMapping("/product/list")
	public ModelAndView getList(HttpServletRequest request) {
		//3단계 
		List<Product> productList = productService.selectAll();
		
		//4단계: jsp로 가져가야 하므로 결과저장 
		ModelAndView mav = new ModelAndView("admin/product/list");
		mav.addObject("productList", productList);
		System.out.println("카테고리명 : "+productList.get(0).getCategory().getCategory_name());
		return mav;
	
	}
	
	//상세보기 요청
	@GetMapping("/product/detail")
	public ModelAndView geDetail(HttpServletRequest request, int product_idx) {
		//3단계
		List categoryList = categoryService.selectAll();
		Product product = productService.select(product_idx);
		
		ModelAndView mav = new ModelAndView("admin/product/detail");
		mav.addObject("categoryList", categoryList);
		mav.addObject("product", product);
		
		return mav;
	}
}









