package com.edu.springshop.model.member;

import java.util.List;

import com.edu.springshop.domain.Member;

public interface MemberDAO {
	public List selectAll();
	public Member select(Member member);
	public void insert(Member member);
	public void update(Member member);
	public void delete(Member member);
}




