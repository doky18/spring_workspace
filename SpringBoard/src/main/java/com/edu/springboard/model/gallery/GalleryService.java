package com.edu.springboard.model.gallery;

import java.util.List;

import com.edu.springboard.domain.Gallery;

//@Service 부모한테 붙일 수 없음 new 할 수 없으니까
public interface GalleryService {
	public List selectAll();		//dao와 동일
	public Gallery select(int gallery_idx);
	public void regist(Gallery gallery, String path);		//insert + upload
	public void update(Gallery gallery);		//dao와는 다르다..
	public void delete(Gallery gallery);		//db + file
}
