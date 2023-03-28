package com.edu.zino.model.user;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.zino.domain.Member;
import com.edu.zino.domain.Wish;
import com.edu.zino.exception.WishException;

@Repository
public class MybatisWishDAO implements WishDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	//전체 위시 가져오기
	public List selectAll(Member member) {
		return sqlSessionTemplate.selectList("Wish.selectAll",member);
	}

	@Override
	//체크된 위시 가져오기
	public Wish select(Wish wish) {
		return sqlSessionTemplate.selectOne("Wish.select",wish);
	}

	@Override
	public void delWish(Wish wish) throws WishException{
		int result = sqlSessionTemplate.delete("Wish.delete", wish.getWish_idx());
		if(result<1) {
			throw new WishException("찜 삭제가 실패했습니다");
		}
	}

}
