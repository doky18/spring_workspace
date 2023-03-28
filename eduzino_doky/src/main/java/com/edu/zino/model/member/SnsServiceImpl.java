package com.edu.zino.model.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.zino.domain.Sns;

@Service
public class SnsServiceImpl implements SnsService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SnsDAO snsDAO;

	

	@Override
	public Sns selectByIdx(int sns_idx) {
		// TODO Auto-generated method stub
		return snsDAO.selectByIdx(sns_idx);
	}

	@Override
	public Sns selectByType(String sns_type) {
		Sns sns = snsDAO.selectByType(sns_type);
		return sns;
	}
}
