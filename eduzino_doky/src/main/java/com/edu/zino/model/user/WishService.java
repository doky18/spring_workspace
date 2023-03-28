package com.edu.zino.model.user;

import java.util.List;

import com.edu.zino.domain.Member;
import com.edu.zino.domain.Wish;

public interface WishService {
	public List selectAll(Member member);
	public Wish select(Wish wish);
	public void delWish(Wish[] wish);
}
