package com.edu.zino.model.member;

import com.edu.zino.domain.ProfilePhoto;

public interface ProfilePhotoDAO {
	public ProfilePhoto select(int profilePhoto_idx);
	
	public void insert(ProfilePhoto profilePhoto);
	public void update(ProfilePhoto profilePhoto);
	public void delete(int profilePhoto_idx); 
}
