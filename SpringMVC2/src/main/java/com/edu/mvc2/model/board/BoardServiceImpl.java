package com.edu.mvc2.model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.edu.mvc2.domain.Board;
import com.edu.mvc2.exception.BoardException;
import com.edu.mvc2.mybatis.MybatisConfig;

import lombok.Setter;
@Setter
public class BoardServiceImpl implements BoardService{
	//MybatisConfig config = MybatisConfig.getInstance();
	//DI 주입받자
	private MybatisConfig config;		//싱글턴도 주입 가능
	private BoardDAO boardDAO;
	
	
	@Override
	public List selectAll() {
		SqlSession sqlSession = config.getSqlSession();
		
		MybatisBoardDAO dao=(MybatisBoardDAO)boardDAO;
		dao.setSqlSession(sqlSession);
		List list =dao.selectAll();
		config.release(sqlSession);  //반납
		
		return list;
	}

	@Override
	public Board select(int board_idx) {
		SqlSession sqlSession=config.getSqlSession();
		
		MybatisBoardDAO dao=(MybatisBoardDAO)boardDAO;
		dao.setSqlSession(sqlSession);
		Board board = dao.select(board_idx);
		config.release(sqlSession);  //반납
		
		return board;
	}

	@Override
	public void insert(Board board) throws BoardException{
		SqlSession sqlSession = config.getSqlSession();
		
		MybatisBoardDAO dao = (MybatisBoardDAO)boardDAO;
		dao.setSqlSession(sqlSession);
		dao.insert(board);
		
		sqlSession.commit();
		config.release(sqlSession);
	}

	@Override
	public void update(Board board) throws BoardException{
		SqlSession sqlSession = config.getSqlSession();
		
		MybatisBoardDAO dao = (MybatisBoardDAO)boardDAO;
		dao.setSqlSession(sqlSession);
		dao.update(board);
		
		sqlSession.commit();
		config.release(sqlSession);
	}

	@Override
	public void delete(int board_idx) throws BoardException{
		SqlSession sqlSession = config.getSqlSession();
		
		MybatisBoardDAO dao = (MybatisBoardDAO)boardDAO;
		dao.setSqlSession(sqlSession);
		
		try {
			dao.delete(board_idx);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
		config.release(sqlSession);
		}
	}

}
