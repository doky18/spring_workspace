package com.edu.springshop.model.admin;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springshop.domain.Admin;
import com.edu.springshop.exception.AdminException;

@Repository
public class MybatisAdminDAO implements AdminDAO{
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insert(Admin admin) throws AdminException{
		int result = sqlSessionTemplate.insert("Admin.insert", admin);
		if (result<1) {
			throw new AdminException("관리자 등록 실패");
		}
	}
	
	@Override
	public Admin select(Admin admin) throws AdminException{
		
		logger.info("admin :" + admin);
		
		Admin obj=sqlSessionTemplate.selectOne("Admin.select", admin);
		logger.info("obj is "+obj);
		
		if(obj == null) {
			throw new AdminException("올바르지 않은 정보입니다"); 
		}
		return obj;
	}
}
