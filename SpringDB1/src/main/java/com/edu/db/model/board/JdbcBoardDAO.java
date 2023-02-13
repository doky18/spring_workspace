package com.edu.db.model.board;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.db.domain.Board;

//만들어놓기만
@Repository
public class JdbcBoardDAO implements BoardDAO{

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board select(int board_idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int board_idx) {
		// TODO Auto-generated method stub
		
	}

}
