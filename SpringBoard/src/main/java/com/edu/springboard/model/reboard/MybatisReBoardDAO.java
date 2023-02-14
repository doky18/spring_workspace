package com.edu.springboard.model.reboard;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.ReBoard;
import com.edu.springboard.exception.ReBoardException;

@Repository
public class MybatisReBoardDAO implements ReBoardDAO{
	/*
	 * xml로 표현했다면 아래와 같이 했었어야 헀다
	 * <bean class="~~MybatisReBoardDAO">
	 * 		<property name="sqlSessionTemplate" ref="sqlSessionTemplate"/>
	 * <bean>
	 */
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("ReBoard.selectAll");
	}

	@Override
	public ReBoard select(int reboard_idx) {
		return sqlSessionTemplate.selectOne("ReBoard.select", reboard_idx);
	}

	@Override
	public void insert(ReBoard reboard) throws ReBoardException{
		int result=sqlSessionTemplate.insert("ReBoard.insert", reboard);
		if(result<1) {
			throw new ReBoardException("글 등록 실패");
		}
	}

	@Override
	public void update(ReBoard reboard) throws ReBoardException{
		int result=sqlSessionTemplate.update("ReBoard.update", reboard);
		if(result<0) {
			throw new ReBoardException("글 수정 실패");
		}
	}

	@Override
	public void delete(int reboard_idx) throws ReBoardException{
		int result=sqlSessionTemplate.delete("ReBoard.delete", reboard_idx);
		if(result<1) {
			throw new ReBoardException("글 삭제 실패");
		}
	}

	@Override
	public void updateStep(ReBoard reboard) {
		sqlSessionTemplate.update("ReBoard.updateStep", reboard);
	}

	@Override
	public void reply(ReBoard reboard)  throws ReBoardException{
		int result=sqlSessionTemplate.insert("ReBoard.reply", reboard);
		if(result<1) {
			throw new ReBoardException("답변 등록 실패");
		}
	}

}
