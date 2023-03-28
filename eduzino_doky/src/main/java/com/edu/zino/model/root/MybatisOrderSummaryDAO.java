package com.edu.zino.model.root;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.zino.domain.Member;
import com.edu.zino.domain.OrderSummary;

@Repository
public class MybatisOrderSummaryDAO implements OrderSummaryDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAllByTeacher(int teacher_idx) {
		return sqlSessionTemplate.selectList("OrderSummary.selectAllByTeacher", teacher_idx);
	}

	@Override
	public List selectAllBySubjectTitleMemberNickname(Map<String, Object> searchMap) {
		return sqlSessionTemplate.selectList("OrderSummary.selectAllBySubjectTitleMemberNickname", searchMap);
	}

	@Override
	//회원 한 명의 주문내역 가져오기
	public List selectAllByMember(Member member) {
		return sqlSessionTemplate.selectList("OrderSummary.selectAllByMember",member);
	}

	


}
