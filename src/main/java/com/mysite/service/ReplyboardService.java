package com.mysite.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.repository.ReplyboardDao;
import com.mysite.vo.ReplyboardVo;

@Service
public class ReplyboardService {
	
	@Autowired
	private ReplyboardDao replyboardDao;
	
	public List<ReplyboardVo> getlist() {
		return replyboardDao.getlist();
	}	
	
	public ReplyboardVo read(int no) {
		replyboardDao.hitUpdate(no);
		
		return replyboardDao.read(no);
	}
	
	public int write(ReplyboardVo replyboardVo) {
		String content = replyboardVo.getContent().replace("\r\n", "<br/>");
		replyboardVo.setContent(content);
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(cal.getTime());
		
		replyboardVo.setDate(date);
		
		return replyboardDao.write(replyboardVo);
	}
	
	public int delete(int no) {
		return replyboardDao.delete(no);
	}
	
	public ReplyboardVo modifyForm(int no) {
		return replyboardDao.modifyForm(no);
	}

	public int modify(ReplyboardVo modifyVo) {
		return replyboardDao.modify(modifyVo);
	}
	
	public int reply(ReplyboardVo replyVo) {
		
		replyboardDao.replyUpdate(replyVo.getGroupNo(), replyVo.getOrderNo());
		
		return replyboardDao.replyInsert(replyVo);
	}
}