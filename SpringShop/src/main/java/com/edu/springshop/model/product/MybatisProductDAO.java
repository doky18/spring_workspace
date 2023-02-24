package com.edu.springshop.model.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springshop.domain.Product;
import com.edu.springshop.exception.ProductException;
@Repository
public class MybatisProductDAO implements ProductDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Product.selectAll");
	}

	@Override
	public Product select(int product_idx) {
		return sqlSessionTemplate.selectOne("Product.select", product_idx);
	}

	@Override
	public void insert(Product product) throws ProductException{
		int result=sqlSessionTemplate.insert("Product.insert", product);
		//result =0; //throws를 배우기 위한 실행
		if(result<1) {
			throw new ProductException("상품등록 실패");
		}
	}

	@Override
	public void update(Product product)throws ProductException{
		int result=sqlSessionTemplate.update("Product.update", product);
		if(result<1) {
			throw new ProductException("상품수정 실패");
		}
	}

	@Override
	public void delete(int product_idx) throws ProductException{
		int result=sqlSessionTemplate.delete("Product.delete", product_idx);
		if(result<1) {
			throw new ProductException("상품삭제 실패");
		}
	}
	
}
