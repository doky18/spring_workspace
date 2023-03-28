package com.edu.zino.model.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.zino.domain.Sns;

@Repository
public class MybatisSnsDAO implements SnsDAO{
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Sns selectByIdx(int sns_idx) {
		return sqlSessionTemplate.selectOne("Sns.selectByIdx",sns_idx);
	}

	@Override
	public Sns selectByType(String sns_type) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("Sns.selectByType", sns_type);
	}

}
