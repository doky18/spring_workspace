package com.edu.zino.model.user;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.zino.domain.Cart;
import com.edu.zino.domain.Member;
import com.edu.zino.exception.CartException;

@Repository
public class MybatisCartDAO implements CartDAO{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	//장바구니 전체 목록 가져오기
	public List selectAll(Member member) {
		//logger.info("cart는" + member);
		return sqlSessionTemplate.selectList("Cart.selectAll",member);
	}

	@Override
	//장바구니 1건 등록하기(찜에서 넘어온)
	public void Insert(Cart cart) throws CartException{
		int result = sqlSessionTemplate.insert("Cart.insert", cart);
		if(result<1) {
			throw new CartException("장바구니 이동 실패");
		}
	}

	@Override
	public void delCart(int cart_idx) throws CartException{
		int result = sqlSessionTemplate.delete("Cart.delete",cart_idx);
		if(result<1) {
			throw new CartException("장바구니 삭제 실패");
		}
	}

}
