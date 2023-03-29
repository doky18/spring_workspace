package com.edu.zino.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.zino.domain.Blacklist;
import com.edu.zino.domain.Member;
import com.edu.zino.domain.Teacher;
import com.edu.zino.model.member.BlacklistService;
import com.edu.zino.model.member.MemberService;
import com.edu.zino.model.teacher.TeacherService;
import com.edu.zino.util.MessageUtil;

@RestController
@RequestMapping("/rest")
public class RestAdminMemberController {


	@Autowired
	private MemberService memberService;
	
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private BlacklistService blacklistService;
    
  //회원 전체 불러오기
  	@GetMapping("/member")
  	public List getList() {
  		return memberService.selectAll();
  	}

    //회원->강사
    @PostMapping("/toteacher")
    public ResponseEntity<MessageUtil> regist(HttpServletRequest request, Teacher teacher){
        //3단계: 일 시키기
        teacherService.insert(teacher);
        MessageUtil message = new MessageUtil();
        message.setMsg("강사전환 성공");

        ResponseEntity entity=new ResponseEntity<MessageUtil>(message, HttpStatus.OK);
        return entity;
    } 

    //회원->정지
        @PostMapping("/blacklist")
        public ResponseEntity<MessageUtil> regist(HttpServletRequest request, Blacklist blacklist){
            //3단계: 일 시키기
            blacklistService.insert(blacklist);
            MessageUtil message = new MessageUtil();
            message.setMsg("정지회원 등록 성공");

            ResponseEntity entity=new ResponseEntity<MessageUtil>(message, HttpStatus.OK);
            return entity;
        } 




}