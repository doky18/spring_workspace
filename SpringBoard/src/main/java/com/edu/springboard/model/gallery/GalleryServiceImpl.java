package com.edu.springboard.model.gallery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.model.util.FileManager;

@Service
public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	@Qualifier("mybatisGalleryDAO")
	private GalleryDAO galleryDAO;		//어떤 dao를 쓸지 모름 - 느슨한 관계 --> @Qualifier에서 정해주면 됨 : 유지보수 ㄱㄴ
	
	@Autowired
	@Qualifier("mybatisPhotoDAO")
	private PhotoDAO photoDAO;
	
	@Autowired
	private FileManager filemanager;
	
	@Override
	public List selectAll() {
		
		return null;
	}

	@Override
	public Gallery select(int gallery_idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void regist(Gallery gallery, String path) {
		//gallerydao 일 시키기
		
		//photodao 시키기 
		
		//filemanager 일시키기
	}

	@Override
	public void update(Gallery gallery) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Gallery gallery) {
		// TODO Auto-generated method stub
		
	}

}
