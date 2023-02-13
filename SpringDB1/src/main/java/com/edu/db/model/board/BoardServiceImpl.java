package com.edu.db.model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.db.domain.Board;
import com.edu.db.exception.BoardException;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	@Qualifier("mybatisBoardDAO")
	private BoardDAO boardDAO;
	//No qualifying bean of type 'com.edu.db.model.board.BoardService' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: 
	//소문자로 적어줘야함
	
	@Override
	public List selectAll() {
		return boardDAO.selectAll();
	}


	@Override
	public Board select(int board_idx) {
		return boardDAO.select(board_idx);
	}

	@Override
	public void insert(Board board) throws BoardException{
		boardDAO.insert(board);
	}
	
	@Override
	public void update(Board board) throws BoardException{
		boardDAO.update(board);
	}

	@Override
	public void delete(int board_idx) throws BoardException{
		boardDAO.delete(board_idx);
	}

}
