package com.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.ReplyboardVo;

@Repository
public class ReplyboardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<ReplyboardVo> getlist() {
		return sqlSession.selectList("replyboard.getList");
	}
	
	public ReplyboardVo read(int no) {
		return sqlSession.selectOne("replyboard.read", no);
	}
	
	public int write(ReplyboardVo replyboardVo) {
		return sqlSession.insert("replyboard.insert", replyboardVo);
	}
	
	public int delete(int no) {
		return sqlSession.delete("replyboard.delete", no);
	}
	
	public ReplyboardVo modifyForm(int no) {
		return sqlSession.selectOne("replyboard.modifyForm", no);
	}

	public int modify(ReplyboardVo modifyVo) {
		return sqlSession.update("replyboard.modify", modifyVo);
	}
	
	public int hitUpdate(int no) {
		return sqlSession.update("replyboard.hitUpdate", no);
	}
	
	public int replyUpdate1(ReplyboardVo replyboardVo) {
		return sqlSession.update("replyboard.replyUpdate1", replyboardVo);
	}
	
	public int replyUpdate2(ReplyboardVo replyboardVo) {
		return sqlSession.update("replyboard.replyUpdate2", replyboardVo);
	}
}