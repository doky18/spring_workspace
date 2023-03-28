package com.edu.zino.model.user;

import java.util.List;

import com.edu.zino.domain.Cart;
import com.edu.zino.domain.Member;

public interface CartDAO {
	public List selectAll(Member member);
	public void Insert(Cart cart);
	public void delCart(int cart_idx);
}
