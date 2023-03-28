package com.edu.zino.model.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.zino.domain.Email;
import com.edu.zino.exception.EmailException;

@Service
public class EmailServiceImpl implements EmailService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EmailDAO emailDAO;
	
	//회원 한 명 가입시키기
	@Override
	public void insert(Email email) throws EmailException{
		emailDAO.insert(email);
	}

	
	
	@Override
	public void update(Email email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int email_idx) {
		// TODO Auto-generated method stub
		
	}

}
