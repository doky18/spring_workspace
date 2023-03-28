package com.edu.zino.model.user;

import java.util.List;

import javax.smartcardio.CardException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.zino.domain.Cart;
import com.edu.zino.domain.Member;
import com.edu.zino.domain.Subject;
import com.edu.zino.domain.Wish;
import com.edu.zino.exception.CartException;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private WishDAO wishDAO;
	
	//전체 카트 목록 가져오기
	public List selectAll(Member member) {
		return cartDAO.selectAll(member);
	}

	//찜목록 > 카트로 이동하기
	@Override
	public void regist(Cart[] cart) throws CartException{
		for(int i=0; i<cart.length; i++) {
			cartDAO.Insert(cart[i]);
		}
	}

	@Override
	public void delCart(int cart_idx) throws CartException{
			cartDAO.delCart(cart_idx);
		}
	
}
