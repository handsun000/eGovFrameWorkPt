package main.service;

import java.util.List;

public interface BoardService {
	public String insertNBoard(BoardVO vo) throws Exception;
	public List<?> selectNBoardList(BoardVO vo) throws Exception;
}
