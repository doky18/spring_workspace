package com.edu.zino.model.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.zino.domain.Birthday;
import com.edu.zino.exception.BirthdayException;

@Repository
public class MybatisBirthdayDAO implements BirthdayDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	

	@Override
	public void insert(Birthday birthday) throws BirthdayException{
		int result =sqlSessionTemplate.insert("Birthday.insert", birthday);
		if(result<1) {
			throw new BirthdayException("생일등록 실패");
		}
	}

	@Override
	public void update(Birthday birthday) throws BirthdayException{
		int result =sqlSessionTemplate.update("Birthday.update", birthday);
		if(result<1) {
			throw new BirthdayException("생일 수정 실패");
		}
	}

	@Override
	public void delete(int birthday_idx) throws BirthdayException{
		int result =sqlSessionTemplate.delete("Birthday.delete", birthday_idx);
		if(result<1) {
			throw new BirthdayException("생일 삭제 실패");
		}
	}

}
