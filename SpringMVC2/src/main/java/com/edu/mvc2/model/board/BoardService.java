package com.edu.mvc2.model.board;

import java.util.List;

import com.edu.mvc2.domain.Board;

public interface BoardService {
	//MybatisBoardDAO dao;
	
	//지금 몰라도 된다.. 하여간 써놓고 무시해,,
	public List selectAll();
	public Board select(int board_idx);
	public void insert(Board board);
	public void update(Board board);
	public void delete(int board_idx);
	
}
