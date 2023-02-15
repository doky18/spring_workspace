package com.edu.springboard.model.gallery;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.Photo;
import com.edu.springboard.exception.PhotoException;
@Repository
public class MybatisPhotoDAO implements PhotoDAO{

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List selectAll() {
        return sqlSessionTemplate.selectList("Photo.selectAll");
    }

	@Override
	public Photo select(int photo_idx) {
		return sqlSessionTemplate.selectOne("Photo.select", photo_idx);
	}

	@Override
	public void insert(Photo photo) throws PhotoException{
		int result=sqlSessionTemplate.insert("Photo.insert", photo);
		if(result<1) {
			throw new PhotoException("이미지 등록 실패");
		}
	}

	@Override
	public void deleteByGallery(int gallery_idx) {
		int result=sqlSessionTemplate.delete("Photo.deleteByGallery", gallery_idx);
		if(result<1) {
			throw new PhotoException("이미지 삭제 실패");
		}
		
	}

}
