package com.edu.mvc3.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.mvc3.domain.Gallery;
import com.edu.mvc3.exception.GalleryException;

import lombok.Setter;

//component-scan에 의해 검색되어 자동으로 인스턴스 생성됨 
@Repository
@Setter
public class MybatisGalleryDAO implements GalleryDAO{
	
	private SqlSession sqlSession;		
	//sqlSession은 누가 주입해줌? 서비스요~ 근데 이게 맘에 안든대.. 
	//다음주 스프링이 지원하는 db 연동기술을 배우면 이 문제가 해결됨 

	@Override
	public List selectAll() {
		return sqlSession.selectList("Gallery.selectAll");
	}

	@Override
	public Gallery select(int gallery_idx) {
		return sqlSession.selectOne("Gallery.select", gallery_idx);
	}

	@Override
	public void insert(Gallery galley) {
		int result=sqlSession.insert("Gallery.insert", galley);
		if(result<1) {
			throw new GalleryException("등록실패");
		}
	}

	@Override
	public void update(Gallery gallery) {
		int result=sqlSession.update("Gallery.update", gallery);
		if(result<1) {
			throw new GalleryException("수정실패");
		}
	}

	@Override
	public void delete(int gallery_idx) {
		int result=sqlSession.delete("Gallery.delete", gallery_idx);
		if(result<1) {
			throw new GalleryException("삭제실패");
		}
	}

}
