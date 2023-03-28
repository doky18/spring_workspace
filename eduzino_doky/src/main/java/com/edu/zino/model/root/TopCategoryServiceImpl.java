package com.edu.zino.model.root;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.zino.domain.TopCategory;

@Service
public class TopCategoryServiceImpl implements TopCategoryService{
	
	@Autowired
	private MybatisTopCategoryDAO topCategoryDAO;
	
	@Override
	public List<TopCategory> selectAll() {
		return topCategoryDAO.selectAll();
	}
	
}
