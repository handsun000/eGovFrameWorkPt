package main.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import main.service.BoardService;
import main.service.BoardVO;
import main.service.impl.BoardDAO;

@Controller
public class BoardController {

	@Resource(name = "boardService")
	private BoardService boardService;
	
	@RequestMapping(value = "boardWrite.do")
	public String boardWrite() {
		
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "boardTest.do")
	public String boardTest() {
		return "board/boardTest";
	}
	
	@ResponseBody
	@RequestMapping(value = "boardWriteSave.do")
	public String boardWriteSave(BoardVO vo) throws Exception {
		
		System.out.println("저장해라");
		String result = boardService.insertNBoard(vo);
		String msg = "";
		
		if(result == null) msg = "ok";
		else msg = "fail";
		
		return "msg";
	}

	
	@RequestMapping(value = "boardList.do")
	public String boardList(BoardVO vo, ModelMap model) throws Exception {
		
		List<?> resultList = boardService.selectNBoardList(vo);
		
		System.out.println("resultList = " + resultList);
		
		model.addAttribute("result", resultList);
		
		return "board/boardList";
	}
	
}
