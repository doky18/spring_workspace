package com.edu.zino.model.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.zino.domain.Adminboard;
import com.edu.zino.exception.AdminboardException;

@Repository
public class MybatisAdminboardDAO implements AdminboardDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	
	public List selectAll() {
		return sqlSessionTemplate.selectList("Adminboard.selectAll");
	}

	@Override
	public Adminboard select(int adminboard_idx) {
		
		return sqlSessionTemplate.selectOne("Adminboard.select",adminboard_idx);
	}

	
	public void insert(Adminboard adminboard) throws AdminboardException{
		System.out.println(adminboard);
		
		int result=sqlSessionTemplate.insert("Adminboard.insert",adminboard);
		if(result<1) {
			throw new AdminboardException("공지사항 등록 실패 ");
		}
		
	}

	@Override
	public void update(Adminboard adminboard) throws AdminboardException{
		System.out.println(adminboard);
		int result=sqlSessionTemplate.update("Adminboard.update",adminboard);
		if(result<1) {
			throw new AdminboardException("공지사항 수정 실패");
		}
		
	}

	@Override
	public void delete(int adminboard_idx) throws AdminboardException{
		int result=sqlSessionTemplate.delete("Adminboard.delete",adminboard_idx);
		if(result<1) {
			throw new AdminboardException("공지사항 삭제 실패");
		}
		
	}

}
