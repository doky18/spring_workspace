package com.edu.zino.model.teacher;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MybatisSubjectDAO implements SubjectDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAllByTeacher(int teacher_idx) {
		return sqlSessionTemplate.selectList("Subject.selectAllByTeacher", teacher_idx);
	}
	


}
