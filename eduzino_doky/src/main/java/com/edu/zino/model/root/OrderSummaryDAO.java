package com.edu.zino.model.root;


import java.util.List;
import java.util.Map;

import com.edu.zino.domain.Member;
import com.edu.zino.domain.OrderSummary;

public interface OrderSummaryDAO {
	public List selectAllByTeacher(int teacher_idx);
	
	public List selectAllBySubjectTitleMemberNickname(Map<String, Object> searchMap);
	
	public List selectAllByMember(Member member);
}
