package com.edu.zino.model.teacher;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.zino.domain.Teacher;

@Repository
public class MybatisTeacherDAO implements TeacherDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	//선생 한명 조회하기
	@Override
	public Teacher select(int member_idx) {
		return sqlSessionTemplate.selectOne("Teacher.select", member_idx);
	}
	


}
