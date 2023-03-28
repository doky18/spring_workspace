package com.edu.zino.model.admin;

import java.util.List;

import com.edu.zino.domain.Adminboard;

public interface AdminboardService {
	public List selectAll();
	public Adminboard select(int adminboard_idx);
	public void insert(Adminboard adminboard);
	public void update(Adminboard adminboard);
	public void delete(int adminboard_idx);
	
}
