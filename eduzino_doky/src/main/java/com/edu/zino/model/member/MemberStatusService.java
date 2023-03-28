package com.edu.zino.model.member;

import com.edu.zino.domain.MemberStatus;

public interface MemberStatusService {
	public String selectAll(MemberStatus memberStatus);
	public MemberStatus selectByMember(int memberstatus_idx);
	public MemberStatus selectByStatus(String memberstatus_detail);
}

