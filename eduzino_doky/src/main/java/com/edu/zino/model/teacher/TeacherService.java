package com.edu.zino.model.teacher;

import java.util.List;

import com.edu.zino.domain.Teacher;

public interface TeacherService {
	
	public Teacher select(int member_idx);
	
	public List selectAll();	//강사 모두 가져오기 
	public void insert(Teacher teacher);	//강사로 등록
}
