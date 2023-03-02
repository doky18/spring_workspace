package com.edu.springshop.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springshop.domain.Admin;
import com.edu.springshop.exception.AdminException;
import com.edu.springshop.model.admin.AdminService;
import com.edu.springshop.util.Message;

@RestController
@RequestMapping("/rest")
public class RestAdminController {
	
	@Autowired
	private AdminService adminService;
	
	//로그인 요청 처리
	@PostMapping("/login/admin")
	public ResponseEntity<Message> loginCheck(Admin admin, HttpServletRequest request){
		//3단계 일시키기
		Admin obj = adminService.select(admin);
		
		//세션에 담기
		HttpSession session = request.getSession();
		session.setAttribute("admin", obj);
		
		Message message = new Message();
		message.setMsg("로그인 성공");
		
		ResponseEntity entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		return entity;
	}
	
	/* 예외처리에 대한 중복을 방지하기 위해서 이 페이지를 막음
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<Message> handle(AdminException e){
		Message message = new Message();
		message.setMsg(e.getMessage());
		ResponseEntity entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
	*/
	
	
	
	
	
	
	
	
	
	
}
