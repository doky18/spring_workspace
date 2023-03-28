package com.edu.zino.model.root;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.zino.domain.TopCategory;

@Repository
public class MybatisTopCategoryDAO implements TopCategoryDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<TopCategory> selectAll() {
		return sqlSessionTemplate.selectList("TopCategory.selectAll");
	}
}
