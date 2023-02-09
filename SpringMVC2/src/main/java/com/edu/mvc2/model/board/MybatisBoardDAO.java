package com.edu.mvc2.model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.edu.mvc2.domain.Board;
import com.edu.mvc2.exception.BoardException;

import lombok.Setter;


@Setter
public class MybatisBoardDAO implements BoardDAO{
	private SqlSession sqlSession;
	

	@Override
	public List selectAll() {
		return sqlSession.selectList("Board.selectAll");
	}

	@Override
	public Board select(int board_idx) {
		return sqlSession.selectOne("Board.select", board_idx);
	}

	@Override
	public void insert(Board board) throws BoardException{
		int result = sqlSession.insert("Board.insert", board);
		if(result<1) {
			throw new BoardException("실패");
		}
	}

	@Override
	public void update(Board board) throws BoardException{
		int result = sqlSession.insert("Board.update", board);
		if(result<1) {
			throw new BoardException("실패");
		}
	}

	@Override
	public void delete(int board_idx) {
		int result = sqlSession.insert("Board.delete", board_idx);
		if(result<1) {
			throw new BoardException("실패");		
	}

	}}
