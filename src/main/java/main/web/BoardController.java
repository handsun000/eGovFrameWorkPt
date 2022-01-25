package main.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import main.service.BoardService;
import main.service.BoardVO;

@Controller
public class BoardController {

	@Resource(name = "boardService")
	private BoardService boardService;
	
	@RequestMapping(value = "boardWrite.do")
	public String boardWrite() {
		
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "boardWriteSave.do")
	@ResponseBody
	public String boardWriteSave(BoardVO vo) throws Exception {
		
		System.out.println("저장해라");
		String result = boardService.insertNBoard(vo);
		String msg = "";
		
		if(result == null) msg = "ok";
		else msg = "fail";
		
		return "msg";
	}
	
}
