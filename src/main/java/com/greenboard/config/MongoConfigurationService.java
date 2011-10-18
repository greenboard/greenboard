/**
 * 
 */
package com.greenboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.greenboard.board.Board;

import javax.annotation.PostConstruct;

/**
 * Service used to ensure mongo collections and indexes are all configured.
 * @author adrianp
 *
 */
@Service
public class MongoConfigurationService {
	@Autowired
	private MongoOperations mongoOperations;

	@PostConstruct
	public void configure()
	{
		if (!mongoOperations.collectionExists(Board.class))
		{
			mongoOperations.createCollection(Board.class);
		}
	}

	/**
	 * @param mongoOperations the mongoOperations to set
	 */
	public void setMongoOperations(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}
}
