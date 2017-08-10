package com.mysite.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysite.service.GuestbookService;
import com.mysite.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<GuestbookVo> list = guestbookService.getlist();
		model.addAttribute("list", list);

		return "guestbook/list";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String add(@ModelAttribute GuestbookVo vo) {
		vo.setContent(vo.getContent().replace("\r\n", "<br/>"));

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(cal.getTime());

		vo.setDate(date);

		guestbookService.insert(vo);
		return "redirect:/guestbook/list";
	}

	@RequestMapping(value = "/deleteform&no={no}", method = RequestMethod.GET)
	public String deleteform(@PathVariable("no") int no, Model model) {
		model.addAttribute("no", no);
		return "guestbook/deleteform";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteform(@ModelAttribute GuestbookVo vo) {
		int count = guestbookService.delete(vo);
		System.out.println(count + "건 삭제");
		return "redirect:/guestbook/list";
	}
}