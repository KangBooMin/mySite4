package com.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVo> getlist() {
		return sqlSession.selectList("board.getList");
	}
	
	public BoardVo read(int no) {
		return sqlSession.selectOne("board.read", no);
	}
	
	public int write(BoardVo boardVo) {
		return sqlSession.insert("board.insert", boardVo);
		
	}
	
}