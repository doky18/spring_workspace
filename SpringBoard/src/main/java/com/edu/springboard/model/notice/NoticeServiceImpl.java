package com.edu.springboard.model.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.Notice;
import com.edu.springboard.exception.NoticeException;

@Repository
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeDAO noticeDAO;
		
	@Override
	public List selectAll() {
		return noticeDAO.selectAll();
	}

	@Override
	public Notice select(int notice_idx) {
		return noticeDAO.select(notice_idx);
	}

	@Override
	public void insert(Notice notice) throws NoticeException{
		noticeDAO.insert(notice);
	}

	@Override
	public void update(Notice notice) throws NoticeException {
		noticeDAO.update(notice);
	}

	@Override
	public void delete(int notice_idx) throws NoticeException{
		noticeDAO.delete(notice_idx);
	}

}
