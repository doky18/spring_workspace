package com.edu.zino.model.user;

import java.util.List;

import com.edu.zino.domain.Cart;
import com.edu.zino.domain.Member;
import com.edu.zino.domain.Subject;
import com.edu.zino.domain.Wish;

public interface CartService {
	public List selectAll(Member member);
	public void regist(Cart[] cart); //여러건이라 배열로 간다
	public void delCart(int cart_idx);

}
