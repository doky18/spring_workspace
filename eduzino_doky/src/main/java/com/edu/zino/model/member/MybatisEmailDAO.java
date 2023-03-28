package com.edu.zino.model.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.zino.domain.Email;
import com.edu.zino.exception.EmailException;
@Repository
public class MybatisEmailDAO implements EmailDAO{

	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insert(Email email) throws EmailException{
		int result =sqlSessionTemplate.insert("Email.insert", email);
		if(result<1) {
			throw new EmailException("메일 등록 실패");
		}		
	}

	@Override
	public void update(Email email) throws EmailException{
		int result =sqlSessionTemplate.update("Email.update", email);
		if(result<1) {
			throw new EmailException("메일 수정 실패");
		}
	}

	@Override
	public void delete(int email_idx) throws EmailException{
		int result =sqlSessionTemplate.delete("Email.delete", email_idx);
		if(result<1) {
			throw new EmailException("메일 삭제 실패");
		}
	}

}
