package com.greenboard.board;

import org.springframework.data.repository.Repository;

/**
 * Repository for performing finder operations to fetch registered boards.
 * 
 */
public interface BoardRepository extends Repository<Board, Long> {

	/**
	 * Finds a {@link Board} by its identifying name.
	 * 
	 * @param name the name of the board to be retrieved.
	 * @return a valid board for the given name or null if the board does not exist.
	 */
	public Board findByName(String name);
}
