package com.edu.springboard.model.reboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.springboard.domain.ReBoard;
import com.edu.springboard.exception.ReBoardException;

@Service
public class ReBoardServiceImpl implements ReBoardService{

	@Autowired
	private MybatisReBoardDAO reboardDAO;
	
	@Override
	public List selectAll() {
		return reboardDAO.selectAll();
	}

	@Override
	public ReBoard select(int reboard_idx) {
		return reboardDAO.select(reboard_idx);
	}

	@Override
	public void insert(ReBoard reboard) {
		reboardDAO.insert(reboard);
	}

	@Override
	public void update(ReBoard reboard) throws ReBoardException{
		reboardDAO.update(reboard);
	}

	@Override
	public void delete(int reboard_idx) throws ReBoardException{
		reboardDAO.delete(reboard_idx);
	}

	@Override
	public void registReply(ReBoard reboard) throws ReBoardException {
		//자리확보
		reboardDAO.updateStep(reboard);
		
		//답변등록
		reboardDAO.reply(reboard);
	}

}
