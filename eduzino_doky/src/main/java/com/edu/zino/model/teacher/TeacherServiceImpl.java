package com.edu.zino.model.teacher;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.zino.domain.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherDAO teacherDAO;

	@Override
	public Teacher select(int member_idx) {
		return teacherDAO.select(member_idx);
	}


}
