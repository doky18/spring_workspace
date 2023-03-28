package com.edu.zino.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.zino.domain.Cart;
import com.edu.zino.domain.Member;
import com.edu.zino.domain.Subject;
import com.edu.zino.domain.Wish;
import com.edu.zino.exception.CartException;
import com.edu.zino.exception.WishException;
import com.edu.zino.model.user.CartService;
import com.edu.zino.model.user.WishService;
import com.edu.zino.util.MessageUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/rest")
public class RestCartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private WishService wishService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//카트목록 비동기로 가져오기
	@GetMapping("/cart/list")
	public List<Cart> getCartList(){
		Member member=new Member();
		member.setMember_idx(2);
		return cartService.selectAll(member);
	}
	
	
	//기본 장바구니 추가
 
		
	//장바구니 삭제
	@DeleteMapping("/cart/list/{cart_idx}")
	public ResponseEntity<MessageUtil> delCart(HttpServletRequest request, @PathVariable int cart_idx){
		//3단계
		logger.info("삭제할 cart_idx"+cart_idx);
		cartService.delCart(cart_idx);
		
		//4단계
		MessageUtil msg = new MessageUtil();
		msg.setMsg("장바구니 삭제 실패");
		
		ResponseEntity entity = new ResponseEntity<MessageUtil>(msg,HttpStatus.OK);
		return entity;
	}
	
	
	/*---------------찜--------------------*/
	//찜목록 비동기로 가져오기
	@GetMapping("/cart/wishlist")
	@ResponseBody
	public List<Cart> getWishList(){
		Member member=new Member();
		member.setMember_idx(2);
		return wishService.selectAll(member);
	}
	
	//찜목록 장바구니에 등록
	@PostMapping("/cart/wishTocart")
	@ResponseBody
	public ResponseEntity<String> toCart(HttpServletRequest request, @RequestBody Wish[] wishList){
		Cart[] cartList=new Cart[wishList.length];
		//임시데이터
		Member member1=new Member();
		member1.setMember_idx(2);
		
		for(int i=0; i<wishList.length; i++) {
			Wish wish = new Wish();
			wish= wishList[i];
			
			//logger.info("wish는? "+ wish);

			Subject subject = new Subject();
			subject.setSubject_idx(wish.getSubject().getSubject_idx());
			
			logger.info("subject는? " + subject);
			
			Cart cart = new Cart();
			cart.setSubject(subject);
			cart.setMember(member1);
			
			//logger.info("cart는 "+cart);
			
			cartList[i]=cart;
			logger.info("cartList는 "+cartList[i]);
		}		
		
		
		//3단계
		cartService.regist(cartList);
		//logger.info("cartList는 "+cartList);
		
		//4단계
		MessageUtil msg = new MessageUtil();
		msg.setMsg("장바구니 등록 실패");
		
		ResponseEntity entity = new ResponseEntity<MessageUtil>(msg,HttpStatus.OK);
		return entity;
	}
	
	//찜목록 삭제하기
	@DeleteMapping("/cart/wish_list")
	@ResponseBody
	public ResponseEntity<String> delWish(HttpServletRequest request, @RequestBody Wish[] wishList){	
		logger.info("길이는"+wishList.length);
		for(Wish wish  : wishList) {
			logger.info("chkwish =  "+wishList);
		}		
		//3단계
		wishService.delWish(wishList);

		//4단계
		MessageUtil msg = new MessageUtil();
		msg.setMsg("찜 삭제 실패");
		
		ResponseEntity entity = new ResponseEntity<MessageUtil>(msg,HttpStatus.OK);
		return entity;
	}
	
	/*-----------exception-------------------*/
	@ExceptionHandler(CartException.class)
	public ResponseEntity<MessageUtil> handle(CartException e){
		
		MessageUtil msg = new MessageUtil();
		msg.setMsg("장바구니 작업 실패");
		
		ResponseEntity entity = new ResponseEntity<MessageUtil>(msg,HttpStatus.OK);
		return entity;
	}
	
	@ExceptionHandler(WishException.class)
	public ResponseEntity<MessageUtil> handle(WishException e){
		
		MessageUtil msg = new MessageUtil();
		msg.setMsg("찜 작업 실패");
		
		ResponseEntity entity = new ResponseEntity<MessageUtil>(msg,HttpStatus.OK);
		return entity;
	}
	
	
}
