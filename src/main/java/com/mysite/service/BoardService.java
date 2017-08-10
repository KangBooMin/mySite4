package com.mysite.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.repository.BoardDao;
import com.mysite.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	public List<BoardVo> getlist() {
		return boardDao.getlist();
	}	
	
	public BoardVo read(int no) {
		return boardDao.read(no);
	}
	
	public int write(BoardVo boardVo) {
		String content = boardVo.getContent().replace("\r\n", "<br/>");
		boardVo.setContent(content);
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(cal.getTime());
		
		boardVo.setDate(date);
		
		return boardDao.write(boardVo);
	}
	
}
