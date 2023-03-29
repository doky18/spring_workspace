package com.edu.zino.model.member;

import java.util.List;

import com.edu.zino.domain.Blacklist;

public interface BlacklistDAO {
	public List selectAll();	//정지 회원 모두 가져오기 
	public Blacklist select(int blacklist_idx);	//정지 회원 한 명 가져오기 
	public Blacklist selectByMember(int member_idx);	//member_idx로 한 명 가져오기 

	public void insert(Blacklist blacklist);
	public void update(Blacklist blacklist);
	public void delete(int blacklist_idx);
}
