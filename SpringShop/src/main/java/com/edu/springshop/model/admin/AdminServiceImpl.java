package com.edu.springshop.model.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.springshop.domain.Admin;
import com.edu.springshop.exception.AdminException;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public Admin select(Admin admin) throws AdminException{
		return adminDAO.select(admin);
	}

	@Override
	public void insert(Admin admin) throws AdminException {
		adminDAO.insert(admin);
	}

}
