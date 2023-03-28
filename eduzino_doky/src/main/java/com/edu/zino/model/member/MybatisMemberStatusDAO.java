package com.edu.zino.model.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.zino.domain.MemberStatus;

@Repository
public class MybatisMemberStatusDAO implements MemberStatusDAO{
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public String selectAll(MemberStatus memberStatus) {
		return null;
	}

	@Override
	public MemberStatus selectByMember(int memberstatus_idx) {
		return sqlSessionTemplate.selectOne("MemberStatus.selectByMember", memberstatus_idx);
	}

	@Override
	public MemberStatus selectByStatus(String memberstatus_detail) {
		return sqlSessionTemplate.selectOne("MemberStatus.selectByStatus", memberstatus_detail);
	}

}
