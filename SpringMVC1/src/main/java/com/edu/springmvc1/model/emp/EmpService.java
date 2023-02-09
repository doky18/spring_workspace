package com.edu.springmvc1.model.emp;

import java.util.List;

import com.edu.springmvc1.domain.Emp;

//컨트롤러가 사용할 이 객체는, DI를 적용하기 위해 즉 컨트롤러와
//의존성을 약화시키기 위함이다
public interface EmpService {
	public void regist(Emp emp);
	public List selectAll();
	public Emp select(int empno);
	public void remove(Emp emp);
}
