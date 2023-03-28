package com.edu.zino.model.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.zino.domain.MemberStatus;
@Service
public class MemberStatusServiceImpl implements MemberStatusService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemberStatusDAO memberStatusDAO;
	
	@Override
	public String selectAll(MemberStatus memberStatus) {
		return memberStatusDAO.selectAll(memberStatus);
	}

	@Override
	public MemberStatus selectByMember(int memberstatus_idx) {
		return memberStatusDAO.selectByMember(memberstatus_idx);
	}

	@Override
	public MemberStatus selectByStatus(String memberstatus_detail) {
		return memberStatusDAO.selectByStatus(memberstatus_detail);
	}

}
