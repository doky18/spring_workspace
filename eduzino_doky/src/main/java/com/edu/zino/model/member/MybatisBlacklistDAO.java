package com.edu.zino.model.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.zino.domain.Blacklist;
import com.edu.zino.exception.BlacklistException;
import com.edu.zino.exception.MemberException;

@Repository
public class MybatisBlacklistDAO implements BlacklistDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Blacklist.selectAll");
	}

	@Override
	public Blacklist select(int blacklist_idx) {
		return sqlSessionTemplate.selectOne("Blacklist.select", blacklist_idx);
	}

	@Override
	public Blacklist selectByMember(int member_idx) throws BlacklistException{
		Blacklist result = sqlSessionTemplate.selectOne("Blacklist.selectByMember", member_idx);
		return result;
	}

	@Override
	public void insert(Blacklist blacklist) throws BlacklistException{
		int result=sqlSessionTemplate.insert("Blacklist.insert", blacklist);
		if(result<1) {
			throw new MemberException("정지계정 등록 실패");
		}		
	}

	@Override
	public void update(Blacklist blacklist) throws BlacklistException{
		int result=sqlSessionTemplate.update("Blacklist.update", blacklist);
		if(result<1) {
			throw new MemberException("정지계정 수정 실패");
		}		
	}

	@Override
	public void delete(int blacklist_idx) throws BlacklistException{
		int result=sqlSessionTemplate.delete("Blacklist.delete", blacklist_idx);
		if(result<1) {
			throw new MemberException("정지계정 삭제 실패");
		}		
	}

}