/**
 * 
 */
package com.greenboard.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

/**
 * @author pillinger_a
 *
 */
@Repository
public class BoardRepositoryImpl implements BoardRepository 
{
	@Autowired
	private MongoOperations mongoOperations;

	/* (non-Javadoc)
	 * @see com.greenboard.board.BoardRepository#findByName(java.lang.String)
	 */
	public Board findByName(String name) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.greenboard.board.BoardRepository#findAll()
	 */
	public List<Board> findAll() {
		List<Board> boards = mongoOperations.findAll(Board.class);
		return boards;
	}

}
