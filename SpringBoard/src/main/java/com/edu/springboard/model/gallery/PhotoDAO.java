package com.edu.springboard.model.gallery;

import java.util.List;

import com.edu.springboard.domain.Photo;

public interface PhotoDAO {
	public List selectAll();
	public Photo select(int photo_idx);
	public void insert (Photo photo);
	public void deleteByGallery(int gallery_idx);
}
