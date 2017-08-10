package com.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.repository.GuestbookDao;
import com.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	public List<GuestbookVo> getlist() {
		return guestbookDao.getlist();
	}	
	
	public int insert(GuestbookVo guestbookVo) {
		return guestbookDao.insert(guestbookVo);
	}
	
	public int delete(GuestbookVo guestbookVo) {
		return guestbookDao.delete(guestbookVo);
	}
}
