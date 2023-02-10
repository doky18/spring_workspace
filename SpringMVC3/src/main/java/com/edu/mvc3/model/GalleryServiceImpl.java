package com.edu.mvc3.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.mvc3.domain.Gallery;

@Service
public class GalleryServiceImpl implements GalleryService{

	@Autowired
	private GalleryDAO galleryDAO;
	
	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public Gallery select(int gallery_idx) {
		return null;
	}

	//파일 저장 + db insert
	@Override
	public void regist(Gallery galley) {
		//FileManager
		
		//GalleryDAO
	}

	@Override
	public void update(Gallery gallery) {
		
	}

	@Override
	public void delete(int gallery_idx) {
		
	}

}
