package com.edu.zino.model.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.zino.domain.ProfilePhoto;
import com.edu.zino.exception.ProfilePhotoException;
@Repository
public class MybatisProfilePhotoDAO implements ProfilePhotoDAO{


	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	//회원 한 명 가입시키기	
	@Override
	public void insert(ProfilePhoto profilePhoto) throws ProfilePhotoException{
		int result=sqlSessionTemplate.insert("ProfilePhoto.insert", profilePhoto);
		if(result<1){
			throw new ProfilePhotoException("프사 등록 실패");
		}
	}

	@Override
	public void update(ProfilePhoto profilePhoto) throws ProfilePhotoException{
		int result=sqlSessionTemplate.update("ProfilePhoto.update", profilePhoto);
		if(result<1){
			throw new ProfilePhotoException("프사 수정 실패");
		}
		
	}

	@Override
	public void delete(int profilePhoto_idx) throws ProfilePhotoException{
		int result=sqlSessionTemplate.delete("ProfilePhoto.delete", profilePhoto_idx);
		if(result<1){
			throw new ProfilePhotoException("프사 삭제 실패");
		}
	}
	
	//----------------------------------------------------------------------------------

	@Override
	public ProfilePhoto select(int profilePhoto_idx) {
		return null;
	}

}
