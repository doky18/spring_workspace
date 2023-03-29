package com.edu.zino.model.member;

import java.util.List;

import com.edu.zino.domain.Member;

public interface MemberService {
	public List selectAll();
	public Member select(int member_idx);
	public Member selectMember(int member_idx);
	public Member selectById(String member_id);
	public void insert(Member member);		//암호화, 이메일, db
	public void update(Member member);
	public void delete(int member_idx);		
}
