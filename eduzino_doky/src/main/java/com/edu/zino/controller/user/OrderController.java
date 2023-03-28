package com.edu.zino.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.zino.domain.Member;
import com.edu.zino.model.root.OrderSummaryService;

@Controller
public class OrderController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderSummaryService orderSummaryService;
	
	/*--------- 주문내역-----------------*/
	
	//회원별 주문내역 가져오기
	@GetMapping("/order/orderlist")
	public ModelAndView getOrderList(HttpServletRequest request, Member member) {
		//임시 member데이터
		Member member1 = new Member();
		member1.setMember_idx(2);
		
		//3단계
		List<Member> orderList = orderSummaryService.selectAllByMember(member1);
		
		//4단계
		ModelAndView mav = new ModelAndView("/user/order/orderList");
		mav.addObject("orderList",orderList);
		return mav;
	}
	
	
	/*--------- 포인트------------------*/
	
	//포인트 내역 보여주기
	@GetMapping("/order/point")
	public ModelAndView getPointList() {
		return new ModelAndView("/user/order/point");
	}
}
