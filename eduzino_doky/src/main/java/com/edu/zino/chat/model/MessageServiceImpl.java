package com.edu.zino.chat.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.zino.domain.Chat;
import com.edu.zino.exception.ChatException;

@Service
public class MessageServiceImpl implements MessageService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MessageDAO messageDAO;

	//수강생 조회
	@Override
	public List selectAllByTeacher(int teacher_idx) {
		return messageDAO.selectAllByTeacher(teacher_idx);
	}
	
	//채팅방생성
	@Override
	public void insert(Chat chat) throws ChatException {
			messageDAO.insert(chat);
	}
	
	
	//채팅방전체조회
	@Override
	public List selectAll(Chat chat) {
		List<Chat> chatList = null;
	
		logger.info("ServiceImpl이 넘겨받은 chat"+chat);
		
		if(chat.getMember_teacher() != null) {
			//선생님이 학생을 조회할때
			//member.member_idx == 0
			//member.member_teacher_idx : session에서 값을 받아서 가져옴
			chatList = messageDAO.selectByTeacher(chat.getMember_teacher().getMember_idx());
		}else {
			//학생이 선생님을 조회할때
			chatList = messageDAO.selectByStudent(chat.getMember().getMember_idx());
		}
		
		logger.info("ServiceImpl chatList"+chatList);
		
		return chatList;
	}
	
	//채팅방 한건 조회
	@Override
	public Chat select(Chat chat) {
		return messageDAO.select(chat);
	}

}
