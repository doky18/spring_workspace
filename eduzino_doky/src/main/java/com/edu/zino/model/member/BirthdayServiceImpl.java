package com.edu.zino.model.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.zino.domain.Birthday;
import com.edu.zino.exception.BirthdayException;

@Service
public class BirthdayServiceImpl implements BirthdayService{


	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BirthdayDAO birthdayDAO;
	
	//회원 한 명 가입시키기	
	@Override
	public void insert(Birthday birthday) throws BirthdayException{
		birthdayDAO.insert(birthday);
	}

	
	
	@Override
	public void update(Birthday birthday) throws BirthdayException{
		birthdayDAO.update(birthday);
	}

	@Override
	public void delete(int birthday_idx) throws BirthdayException{
		birthdayDAO.delete(birthday_idx);
	}

}
