package com.edu.springshop.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springshop.domain.Category;
import com.edu.springshop.exception.CategoryException;
import com.edu.springshop.model.category.CategoryService;
import com.edu.springshop.util.Message;

@RestController
@RequestMapping("/rest")
public class RestCategoryController {
	private Logger logger=LoggerFactory.getLogger(getClass());
	//syso를 엄청 많이 쓰게 되면 성능이 저하됨
	
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
	
	//수정요청 처리
	//@RequestBody : 자바객체 --> JSON
	//@RequestBody : JSON --> 자바객체
	@PutMapping("/category")
	public ResponseEntity<Message> edit(@RequestBody Category category){
		logger.debug("category is "+category);
		//3단계:
		categoryService.update(category);
		
		//결과 메시지 처리
		Message message = new Message();
		message.setMsg("수정성공");
		ResponseEntity<Message> entity=null;
		entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		
		return entity;
	}
	
	//삭제요청 처리
	//파라미터가 평소(?변수명=값)와는 다르게 디렉토리의 일부로 전달된다..
	//따라서 스프링측에서 경로에 포함된 파라미터를 변수로 인식할 필요가 있다
	//이 문제를 가능하게 해주는 코드 경로에 변수부분을 {변수}로 표현
	//@PathVariable
	@DeleteMapping("/category/{category_idx}")			
	public ResponseEntity<Message> del(@PathVariable int category_idx){
		logger.info("넘겨받은 category)idx is"+category_idx);
		
		//3단계
		categoryService.delete(category_idx);

		//결과 메시지 처리
		Message message = new Message();
		message.setMsg("삭제성공");
		ResponseEntity<Message> entity=null;
		entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		
		return entity;
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
