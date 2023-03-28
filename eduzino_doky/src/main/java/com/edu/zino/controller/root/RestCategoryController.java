package com.edu.zino.controller.root;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.zino.domain.TopCategory;
import com.edu.zino.model.root.TopCategoryService;

@RestController
@RequestMapping("/rest")
public class RestCategoryController {
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/category")
	public ResponseEntity<List<TopCategory>> getTopCategory(HttpServletRequest request){
		List<TopCategory> topCategoryList = topCategoryService.selectAll();
		ResponseEntity<List<TopCategory>> entity = new ResponseEntity<>(topCategoryList,HttpStatus.OK);
		return entity;
	}
	
}
