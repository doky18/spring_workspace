package com.edu.zino.model.teacher;

import java.util.List;

public interface SubjectDAO {
	public List selectAllByTeacher(int teacher_idx);
}
