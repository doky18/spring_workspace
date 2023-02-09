package com.edu.mvc2.model.board;

import java.util.List;

import com.edu.mvc2.domain.Board;

/*
 * 곧 DAO를 객체를 서비스가 사용할 예정이므로, 
 * Service 입장에서는 DAO에 대한 결합도가 낮아야 하므로 BoardDAO의 최상위 객체를 정의한다
 */

public interface BoardDAO {
	public List selectAll();
	public Board select(int board_idx);
	public void insert(Board board);
	public void update(Board board);
	public void delete(int board_idx);
}
