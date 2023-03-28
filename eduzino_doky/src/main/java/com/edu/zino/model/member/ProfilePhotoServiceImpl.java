package com.edu.zino.model.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.zino.domain.ProfilePhoto;
import com.edu.zino.exception.ProfilePhotoException;

@Service
public class ProfilePhotoServiceImpl implements ProfilePhotoService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProfilePhotoDAO profilePhotoDAO;
	
	//회원 한 명 가입시키기	
	@Override
	public void insert(ProfilePhoto profilePhoto) throws ProfilePhotoException{
		profilePhotoDAO.insert(profilePhoto);	//DAO에게 일 시키기 
	}

	@Override
	public void update(ProfilePhoto profilePhoto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int profilePhoto_idx) {
		// TODO Auto-generated method stub
		
	}

}
