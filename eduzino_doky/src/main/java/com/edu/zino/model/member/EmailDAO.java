package com.edu.zino.model.member;

import com.edu.zino.domain.Email;

public interface EmailDAO {
	public void insert(Email email);
	public void update(Email email);
	public void delete(int email_idx); 

}
