package main.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import main.service.BoardService;
import main.service.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Resource(name = "boardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public String insertNBoard(BoardVO vo) throws Exception {
		return boardDAO.insertNBoard(vo);
	}

}
