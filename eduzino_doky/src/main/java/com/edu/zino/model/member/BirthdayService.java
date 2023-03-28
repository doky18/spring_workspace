package com.edu.zino.model.member;

import com.edu.zino.domain.Birthday;

public interface BirthdayService {
	public void insert(Birthday birthday);
	public void update(Birthday birthday);
	public void delete(int birthday_idx); 
}
