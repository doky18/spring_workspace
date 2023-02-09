package com.mvc3.model.emp;

import org.apache.ibatis.session.SqlSession;

import com.mvc3.domain.Dept;
import com.mvc3.exception.DeptException;
import com.mvc3.exception.EmpException;

public class DeptDAO {
	//1.세션 세터 준비하기
	//왜 얻어와? 트랜잭션을 위해서 주입 받아야함
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void insert(Dept dept) throws DeptException{
		int result = sqlSession.insert("Dept.insert", dept);
		if(result<1) {
			throw new DeptException("부서등록실패");
		}
	}
	
	public void delete(int deptno) throws DeptException{
		int result=sqlSession.delete("Emp.delete", deptno);
		if(result<0) {
			throw new DeptException("사원삭제 실패");
		}
	}
}
