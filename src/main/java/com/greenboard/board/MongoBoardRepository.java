/**
 * 
 */
package com.greenboard.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author pillinger_a
 *
 */
@Repository
public class MongoBoardRepository implements BoardRepository 
{
	@Autowired
	private MongoOperations mongoOperations;

	/* (non-Javadoc)
	 * @see com.greenboard.board.BoardRepository#findByName(java.lang.String)
	 */
	public Board findByName(String name) {
		Query query = new Query(Criteria.where("name").is(name));
		Board result = mongoOperations.findOne(query, Board.class);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.greenboard.board.BoardRepository#findAll()
	 */
	public List<Board> findAll() {
		List<Board> boards = mongoOperations.findAll(Board.class);
		return boards;
	}

	/**
	 * @param mongoOperations the mongoOperations to set
	 */
	public void setMongoOperations(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

}
