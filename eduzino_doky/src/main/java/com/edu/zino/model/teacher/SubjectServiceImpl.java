package com.edu.zino.model.teacher;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectDAO subjectDAO;

	@Override
	public List selectAllByTeacher(int teacher_idx) {
		return subjectDAO.selectAllByTeacher(teacher_idx);
	}
	



}
