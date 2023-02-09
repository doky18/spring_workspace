package com.mvc3.model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mvc3.domain.Board;
import com.mvc3.exception.BoardException;

public class BoardDAO {
	private SqlSession sqlSession;
	
	//주입받기 위한 세터 준비
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	//SelectAll
	public List selectAll() {
		return sqlSession.selectList("Board.selectAll");
	}
	
	//select
	public Board select(int board_idx) {
		return sqlSession.selectOne("Board.select", board_idx);
	}
	
	//insert
	public void insert(Board board) {
		int result = sqlSession.insert("Board.insert", board);
		if(result<1) {
			throw new BoardException("등록실패");
		}
	}
	
	//update
	public void update(Board board) {
		int result = sqlSession.update("Board.update", board);
		if(result<1) {
			throw new BoardException("수정실패");
		}
	}
	
	//delete
	public void delete(int board_idx) {
		int result = sqlSession.delete("Board.delete", board_idx);
		if(result<1) {
			throw new BoardException("삭제실패");
		}
	}

}
