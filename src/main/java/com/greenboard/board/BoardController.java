package com.greenboard.board;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory
			.getLogger(BoardController.class);

	@Autowired
	private BoardRepository boardRepository;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/board/{name}", method = RequestMethod.GET)
	public String getBoard(@PathVariable String name, Model model) {
		logger.info("finding board: "+ name);
		Board board = boardRepository.findByName(name);
		model.addAttribute("board", board);
		return "board";
	}

	@RequestMapping(value = "/boards", method = RequestMethod.GET)
	public @ResponseBody
	List<Board> getBoards() {
		logger.info("finding all boards");
		List<Board> boards = boardRepository.findAll();
		return boards;
	}

	public void setBoardRepository(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

}
