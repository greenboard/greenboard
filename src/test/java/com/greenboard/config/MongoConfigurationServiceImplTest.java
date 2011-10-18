package com.greenboard.config;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoOperations;

import com.greenboard.board.Board;

@RunWith(MockitoJUnitRunner.class)
public class MongoConfigurationServiceImplTest extends MongoConfigurationServiceImpl {

	@Mock
	private MongoOperations mongoOperations;
	
	@InjectMocks
	private MongoConfigurationServiceImpl service = new MongoConfigurationServiceImpl();

	@Test
	public void shouldCreateBoardCollection() {
		// given that the Board collection does not yet exist
		BDDMockito.given(mongoOperations.collectionExists(Board.class)).willReturn(false);
		
		// when service.configure() is invoked
		service.configure();
		
		// then the board collection should be created
		Mockito.verify(mongoOperations).createCollection(Board.class);
	}

	@Test
	public void shouldNotCreateBoardCollection() {
		// given that the Board collection does not yet exist
		BDDMockito.given(mongoOperations.collectionExists(Board.class)).willReturn(true);
		
		// when service.configure() is invoked
		service.configure();
		
		// then the board collection should be created
		Mockito.verify(mongoOperations, Mockito.times(0)).createCollection(Board.class);
	}

}
