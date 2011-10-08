package com.greenboard.board;

/**
 * Service used to create and update Boards.
 * @author adrianp
 *
 */
public interface BoardService {
	/**
	 * Create a new board and persist it. Return the persisted board.
	 * @param name The name of the board.
	 * @param description A description of the board.
	 * @return The persisted board.
	 */
	public Board createNewBoard(String name, String description);
}
