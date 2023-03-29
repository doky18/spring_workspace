package com.edu.zino.model.member;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.edu.zino.domain.Blacklist;
import com.edu.zino.exception.BlacklistException;

@Service
public class BlacklistServiceImpl implements BlacklistService{


	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private BlacklistDAO blacklistDAO;
	
	//------------------------------------------------------------
	
	@Override
	public List selectAll() {
		return blacklistDAO.selectAll();
	}

	@Override
	public Blacklist select(int blacklist_idx) {
		return blacklistDAO.select(blacklist_idx);
	}

	@Override
	public Blacklist selectByMember(int member_idx) {
		return blacklistDAO.selectByMember(member_idx);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Blacklist blacklist) throws BlacklistException{
		blacklistDAO.insert(blacklist);
	}

	@Override
	public void update(Blacklist blacklist) throws BlacklistException {
		blacklistDAO.update(blacklist);
	}

	@Override
	public void delete(int blacklist_idx) throws BlacklistException{
		blacklistDAO.delete(blacklist_idx);
	}

}