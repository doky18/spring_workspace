package com.edu.zino.model.teacher;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.zino.domain.Teacher;
import com.edu.zino.exception.TeacherException;

@Repository
public class MybatisTeacherDAO implements TeacherDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	//선생 한명 조회하기
	@Override
	public Teacher select(int member_idx) {
		return sqlSessionTemplate.selectOne("Teacher.select", member_idx);
	}

	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectOne("Teacher.selectAll");
	}

	@Override
	public void insert(Teacher teacher) throws TeacherException{
		int result=sqlSessionTemplate.insert("Teacher.insert", teacher);
		if(result<1) {
			throw new TeacherException("정지계정 등록 실패");
		}		
	}
	


}