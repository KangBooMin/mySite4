package com.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.service.BoardService;
import com.mysite.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<BoardVo> list = boardService.getlist();
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(@RequestParam("no") int no,
					   @RequestParam("userNo") int userNo, Model model) {
		BoardVo boardVo = boardService.read(no);
		boardVo.setUserNo(userNo);
		model.addAttribute("vo", boardVo);
		
		return "board/read";
	}
	
	@RequestMapping("/writeform")
	public String writeform() {
		
		return "/board/writeform";
	}

	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String write(@ModelAttribute BoardVo boardVo) {
		boardService.write(boardVo);
		
		return "redirect:/board/list";
	}

	@RequestMapping(value = "delete")
	public String delete(int no){
		boardService.delete(no);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "modifyform")
	public String modifyform(int no, Model model){
		BoardVo modifyForm = boardService.modifyForm(no);
		model.addAttribute("vo", modifyForm);
		
		return "board/modifyform";
	}

	@RequestMapping(value = "modify")
	public String modify(BoardVo modifyVo, Model model){
		
		boardService.modify(modifyVo);
			
		return "redirect:/board/list";
	}
	
}
