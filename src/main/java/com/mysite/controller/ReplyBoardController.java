package com.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.service.ReplyboardService;
import com.mysite.vo.ReplyboardVo;

@Controller
@RequestMapping("/replyboard")
public class ReplyBoardController {
	
	@Autowired
	private ReplyboardService replyboardService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<ReplyboardVo> list = replyboardService.getlist();
		model.addAttribute("list", list);
		
		return "replyboard/list";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(@RequestParam("no") int no,
					   @RequestParam("userNo") int userNo,
					   @RequestParam("groupNo") int groupNo,
					   @RequestParam("orderNo") int orderNo,
					   @RequestParam("depth") int depth,
					   Model model) {
		ReplyboardVo replyboardVo = replyboardService.read(no);
		replyboardVo.setUserNo(userNo);
		model.addAttribute("vo", replyboardVo);
		
		return "replyboard/read";
	}
	
	@RequestMapping("/writeform")
	public String writeform() {
		
		return "/replyboard/writeform";
	}

	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String write(@ModelAttribute ReplyboardVo replyboardVo) {
		replyboardService.write(replyboardVo);
		
		return "redirect:/replyboard/list";
	}

	@RequestMapping(value = "delete")
	public String delete(int no){
		replyboardService.delete(no);
		
		return "redirect:/replyboard/list";
	}
	
	@RequestMapping(value = "modifyform")
	public String modifyform(int no, Model model){
		ReplyboardVo modifyForm = replyboardService.modifyForm(no);
		model.addAttribute("vo", modifyForm);
		
		return "replyboard/modifyform";
	}

	@RequestMapping(value = "modify")
	public String modify(ReplyboardVo modifyVo, Model model){
		
		replyboardService.modify(modifyVo);
			
		return "redirect:/replyboard/list";
	}
	
	@RequestMapping(value = "replyform")
	public String replyform(int no, Model model){
		model.addAttribute("replyVo", replyboardService.read(no));
		
		return "replyboard/replyform";
	}
	
	@RequestMapping(value = "reply")
	public String reply(ReplyboardVo replyVo, Model model){
		replyboardService.reply(replyVo);
		model.addAttribute("boardRead", replyVo);
		
		return "redirect:/replyboard/list";
	}
	
}