package com.edu.zino.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.zino.domain.Cart;
import com.edu.zino.domain.Member;
import com.edu.zino.domain.Wish;
import com.edu.zino.model.user.CartService;
import com.edu.zino.model.user.WishService;

@Controller
public class CartController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private WishService wishService;
	
	@Autowired
	private CartService cartService;
	
	//장바구니 페이지 가져오기
	@GetMapping("/cart/list")
	public ModelAndView getCartList(HttpServletRequest request, Member member) {
		//임시
		Member member1=new Member();
		member1.setMember_idx(2);
		
		//3단계
		List<Member> cartList = cartService.selectAll(member1);
		
		ModelAndView mav = new ModelAndView("/user/cart/cartList");
		mav.addObject("cartList",cartList);
		return mav;
	}
	
	//찜목록 가져오기
	@GetMapping("/cart/wishlist")
	public ModelAndView getWish(HttpServletRequest request,Member member) {
		//임시
		Member member1=new Member();
		member1.setMember_idx(2);
		
		//logger.info("wish의 member"+member1);
		
		//3단계
		List<Wish> wishList = wishService.selectAll(member1); 
		
		ModelAndView mav=new ModelAndView("/user/cart/wishList");
		mav.addObject("wishList",wishList);
		return mav;
	}
	
		
		
}
