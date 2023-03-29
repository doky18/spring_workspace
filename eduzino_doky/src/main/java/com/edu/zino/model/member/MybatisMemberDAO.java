package com.edu.zino.model.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.zino.domain.Member;
import com.edu.zino.exception.MemberException;

@Repository
public class MybatisMemberDAO implements MemberDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Member.selectAll");
	}
	
	@Override
	public Member selectMember(int member_idx) {
		return sqlSessionTemplate.selectOne("Member.selectMember", member_idx);
	}
	

	@Override
	public Member select(int member_idx) {
		return sqlSessionTemplate.selectOne("Member.select", member_idx);
	}

	//회원 한 명 가입시키기
	@Override
	public void insert(Member member) throws MemberException{
		int result=sqlSessionTemplate.insert("Member.insert", member);
		//result=0;
		if(result<1) {
			throw new MemberException("회원등록 실패");
		}
	}

	@Override
	public void update(Member member) throws MemberException{
		int result=sqlSessionTemplate.update("Member.update", member);
		if(result<1) {
			throw new MemberException("회원정보 수정 실패");
		}
	}

	@Override
	public void delete(int member_idx) throws MemberException{
		int result=sqlSessionTemplate.delete("Member.delete", member_idx);
		if(result<1) {
			throw new MemberException("회원정보 삭제 실패");
		}		
	}

	@Override
	public Member selectById(String id) throws MemberException{
		Member result=sqlSessionTemplate.selectOne("Member.selectById", id);
		return result;
	}


}