package com.greenboard.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Main controller API for accessing {@link Board} instances. TODO This needs to
 * be replaced once we start fleshing out real usage scenarios.
 */
@Controller
public class BoardController {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/board/new", method = RequestMethod.POST)
	public String getBoard(@RequestParam("name") String name, @RequestParam("description") String description, Model model) {
		Board board = boardService.createNewBoard(name, description);
		model.addAttribute("board", board);
		return "board";
	}

	@RequestMapping(value = "/board/{name}", method = RequestMethod.GET)
	public String getBoard(@PathVariable String name, Model model) {
		Board board = boardRepository.findByName(name);
		model.addAttribute("board", board);
		return "board";
	}

	@RequestMapping(value = "/boards", method = RequestMethod.GET)
	public @ResponseBody
	List<Board> getBoards() {
		List<Board> boards = boardRepository.findAll();
		return boards;
	}

	public void setBoardRepository(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

}
