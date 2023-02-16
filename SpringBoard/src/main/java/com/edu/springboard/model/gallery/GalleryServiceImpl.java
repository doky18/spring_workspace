package com.edu.springboard.model.gallery;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.domain.Photo;
import com.edu.springboard.exception.FileUploadException;
import com.edu.springboard.exception.GalleryException;
import com.edu.springboard.exception.PhotoException;
import com.edu.springboard.model.util.FileManager;

@Service
public class GalleryServiceImpl implements GalleryService{
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	@Qualifier("jdbcGalleryDAO")
	private GalleryDAO galleryDAO;		//어떤 dao를 쓸지 모름 - 느슨한 관계 --> @Qualifier에서 정해주면 됨 : 유지보수 ㄱㄴ
	
	@Autowired
	@Qualifier("mybatisPhotoDAO")
	private PhotoDAO photoDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List selectAll() {
		
		return galleryDAO.selectAll();
	}

	@Override
	public Gallery select(int gallery_idx) {
		
		return null;
	}

	@Override
	public void regist(Gallery gallery, String path) throws FileUploadException, GalleryException, PhotoException{
		//1. filemanager 일시키기
		fileManager.save(gallery,path);
		
		//2. gallerydao 시키기
		//mybatis의 selectkey에 의해 insert문 수행 이후에는 GalleryDTO의 gallery_idx의 값이 이미 채워져 있을 것임
		logger.info("insert 이전의 Gallery의 gallery_idx 값" + gallery.getGallery_idx());
		galleryDAO.insert(gallery);
		logger.info("insert 이후의 Gallery의 gallery_idx 값" + gallery.getGallery_idx());
		
		//3. photodao 시키기 
		//필요한 모든건 Gallery에 다 들어있다..
		//insert into photo(photo_idx, gallery_idx, filename)~~
		
		//파일 매니저에 의해 채워진 photoList 활용하기 
		List <Photo> photoList = gallery.getPhotoList();
		for(int i=0;i<photoList.size();i++) {
			Photo photo=photoList.get(i);
			photo.setGallery(gallery);//fk를 위하여.. 넣어주기
			photoDAO.insert(photo);
		}
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
