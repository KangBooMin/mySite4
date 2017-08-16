package com.mysite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public int replyUpdate(int groupNo, int orderNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("groupNo", groupNo);
		map.put("orderNo", orderNo);
		
		return sqlSession.update("replyboard.replyUpdate", map);
	}
	
	public int replyInsert(ReplyboardVo replyVo){
		
		int orderNo = replyVo.getOrderNo();
		int depth = replyVo.getDepth();
		++orderNo;
		++depth;
		replyVo.setOrderNo(orderNo);
		replyVo.setDepth(depth);
		
		return sqlSession.insert("replyboard.replyInsert",replyVo);
	}
	
}