package com.edu.zino.model.root;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.zino.domain.Member;
import com.edu.zino.domain.OrderSummary;

@Service
public class OrderSummaryServiceImpl implements OrderSummaryService {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderSummaryDAO orderSummaryDAO;

	//과목에 따른 전체 수강생조회
	@Override
	public List selectAllByTeacher( int teacher_idx) {
		return orderSummaryDAO.selectAllByTeacher(teacher_idx);
	}
	
	//과목이나 이름을 통한 수강생조회
	@Override
	public List selectAllBySearch(Map<String, Object> searchMap) {
		
		List<OrderSummary> orderSummaryList = null;
		
		String subject_idx = (String)searchMap.get("subject_idx");
		String member_nickname = (String)searchMap.get("member_nickname");
		int teacher_idx = (Integer)searchMap.get("teacher_idx");
		
		if(subject_idx == null && member_nickname == null || subject_idx.equals("0") && member_nickname == null) {
		orderSummaryList = orderSummaryDAO.selectAllByTeacher(teacher_idx);
		}else {
		orderSummaryList = orderSummaryDAO.selectAllBySubjectTitleMemberNickname(searchMap);
		}
		
		return orderSummaryList;
	}

	@Override
	//회원별 주문내역 가져오기
	public List selectAllByMember(Member member) {
		return orderSummaryDAO.selectAllByMember(member);
	}
	



}
