/**
 * 
 */
package com.greenboard.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Board Service used to create new boards
 * @author adrianp
 *
 */
@Service
public class MongoBoardService implements BoardService {
	@Autowired
	private MongoOperations mongoOperations;

	/* (non-Javadoc)
	 * @see com.greenboard.board.BoardService#createNewBoard(java.lang.String, java.lang.String)
	 */
	public Board createNewBoard(String name, String description) {
		Assert.hasText(name, "name should not be blank");
		Assert.hasText(description, "description should not be blank");
		
		Board board = new Board(name);
		board.setDescription(description);
		
		mongoOperations.insert(board);
		
		return board;
	}

	
	/**
	 * @param mongoOperations the mongoOperations to set
	 */
	public void setMongoOperations(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

}
