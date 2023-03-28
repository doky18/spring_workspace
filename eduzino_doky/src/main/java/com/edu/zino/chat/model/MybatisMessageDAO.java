package com.edu.zino.chat.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.zino.domain.Chat;
import com.edu.zino.exception.ChatException;

@Repository
public class MybatisMessageDAO implements MessageDAO {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAllByTeacher(int teacher_idx) {
		return sqlSessionTemplate.selectList("OrderSummary.selectAllByTeacher", teacher_idx);
	}

	@Override
	public void insert(Chat chat) throws ChatException {
		int result = sqlSessionTemplate.insert("Chat.insert", chat);
		if(result <1) {
			throw new ChatException("채팅방 생성 실패");
		}
	}

	@Override
	public List selectByStudent(int member_idx) {
		
		//return sqlSessionTemplate.selectList("Chat.selectByStudent", member_idx);
		List chatListDAO = sqlSessionTemplate.selectList("Chat.selectByStudent", member_idx);
		logger.info("chatListDAO"+chatListDAO);
		return null;
	}

	@Override
	public List selectByTeacher(int member_teacher_idx) {
		return sqlSessionTemplate.selectList("Chat.selectByTeacher", member_teacher_idx);
	}

	@Override
	public Chat select(Chat chat) {
		return sqlSessionTemplate.selectOne("Chat.select", chat);
	}
	
	
}
