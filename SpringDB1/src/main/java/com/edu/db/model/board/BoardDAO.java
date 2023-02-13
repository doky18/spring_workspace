package com.edu.db.model.board;

import java.util.List;

import com.edu.db.domain.Board;

public interface BoardDAO {
	public List selectAll();
	public Board select(int board_idx);
	public void insert (Board board);
	public void update(Board board);
	public void delete(int board_idx);
}
