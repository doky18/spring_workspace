package com.edu.springboard.model.notice;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.Notice;
import com.edu.springboard.exception.NoticeException;
import com.edu.springboard.exception.ReBoardException;

@Repository
public class MybatisNoticeDAO implements NoticeDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Notice.selectAll");
	}

	@Override
	public Notice select(int notice_idx) {
		return sqlSessionTemplate.selectOne("Notice.select", notice_idx);
	}

	@Override
	public void insert(Notice notice) throws NoticeException {
		int result=sqlSessionTemplate.insert("Notice.insert", notice);
		if(result<1) {
			throw new ReBoardException("글 등록 실패");
		}
	}

	@Override
	public void delete(int notice_idx) throws NoticeException{
		int result=sqlSessionTemplate.delete("Notice.delete", notice_idx);
		if(result<1) {
			throw new ReBoardException("글 삭제 실패");
		}
	}

	@Override
	public void update(Notice notice) throws NoticeException{
		int result=sqlSessionTemplate.update("Notice.update", notice);
		if(result<1) {
			throw new ReBoardException("글 수정 실패");
		}
	}

}
