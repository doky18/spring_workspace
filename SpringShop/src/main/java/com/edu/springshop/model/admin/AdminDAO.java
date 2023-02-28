package com.edu.springshop.model.admin;

import com.edu.springshop.domain.Admin;

public interface AdminDAO {
	public Admin select(Admin admin);
	public void insert(Admin admin);
}
