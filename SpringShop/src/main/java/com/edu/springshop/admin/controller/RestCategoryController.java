package com.edu.springshop.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springshop.domain.Category;
import com.edu.springshop.exception.CategoryException;
import com.edu.springshop.model.category.CategoryService;
import com.edu.springshop.util.Message;

@RestController
@RequestMapping("/rest")
public class RestCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/category")
	public Message regist(Category category) {
		//3단계
		categoryService.insert(category);
		Message message = new Message();
		message.setMsg("카테고리 등록 성공");
		
		return message;
	}
	
	@GetMapping("/category")
	public List<Category> getList(){
		//3단계
		return categoryService.selectAll();
	}
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<Message> handle(CategoryException e) {
		
		//HTTP 응답정보를 보다 세밀하게 구성하고 싶다면..
		//Http 응답 메시지를 구성할 수 있는 객체를 지원함..
		Message message = new Message();
		message.setMsg(e.getMessage());
		
		ResponseEntity<Message> entity=null;
		entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
	
	/*
	 * Message는 기본적으로 그냥 더많은 정보를 담기위해 객체로 정보를 return하는데
	 * 그렇게되면 우리는 정보는 넘길수있지만 헤더 즉 상태는 항상 성공으로밖에 넘길수가없음
	근데 ResponseEntity를 사용하면 보내고자하는 정보와 함께
	헤더에 성공,실패등의 상태도 같이보낼수있게 됨*/

}
