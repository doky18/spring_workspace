package com.edu.zino.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.zino.model.member.MemberService;

@RestController
@RequestMapping("/rest")
public class RestMemberController {
	
	@Autowired
	private MemberService memberService;
	
	//회원 전체 불러오기
	@GetMapping("/member")
	public List getList() {
		return memberService.selectAll();
	}
	
}
