package com.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
/*	public int delete(int no, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("password", password);
		
		return sqlSession.delete("guestbook.delete", map);
	}*/

	public int insert(GuestbookVo vo) {
		return sqlSession.insert("guestbook.insert", vo);
	}

	public List<GuestbookVo> getlist() {
		return sqlSession.selectList("guestbook.getList");
	}

	public int delete(GuestbookVo vo) {
		return sqlSession.insert("guestbook.delete", vo);
	}
}