/**
 * 
 */
package com.greenboard.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * @author adrianp
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MongoBoardServiceTest extends MongoBoardService {
	
	@InjectMocks
	private MongoBoardService boardService = new MongoBoardService();
	
	@Mock
	private MongoOperations mongoOperations;

	@Captor
	private ArgumentCaptor<Board> boardCaptor;
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldExceptionOnNullName()
	{
		// given a null name
		// and a valid description
		String nullName = null;
		String desc = "this is a test bpard";
		
		// when createNewBoard is invoked with these values
		boardService.createNewBoard(nullName, desc);

		// then an IllegalArgumentException should be thrown
	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldExceptionOnEmptyBlankName()
	{
		// given a blank name
		// and a valid description
		String blankName = "  ";
		String desc = "this is a test bpard";
		
		// when createNewBoard is invoked with these values
		boardService.createNewBoard(blankName, desc);

		// then an IllegalArgumentException should be thrown
	}

	
	@Test(expected=IllegalArgumentException.class)
	public void shouldExceptionOnNullDescription()
	{
		// given a valid name
		// and a null description
		String name = "board 1";
		String nullDesc = null;
		
		// when createNewBoard is invoked with these values
		boardService.createNewBoard(name, nullDesc);

		// then an IllegalArgumentException should be thrown
	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldExceptionOnEmptyBlankDescription()
	{
		// given a valid name
		// and a blank description
		String name = "board 1";
		String blankDesc = "   ";
		
		// when createNewBoard is invoked with these values
		boardService.createNewBoard(name, blankDesc);

		// then an IllegalArgumentException should be thrown
	}

	@Test
	public void shouldCreateNewBoard() {
		// given a valid name
		// and description
		String name = "board 1";
		String desc = "this is a test bpard";
		
		// when createNewBoard is invoked with these values
		Board result = boardService.createNewBoard(name, desc);

		// then a new board should be persisted via mongoOperations.insert()
		Mockito.verify(mongoOperations).insert(boardCaptor.capture());
		// and the board persisted should contain the correct name and description values
		Board persistedBoard = boardCaptor.getValue();
		assertNotNull(persistedBoard);
		assertEquals("Unexpected name in board persisted", name, persistedBoard.getName());
		assertEquals("Unexpected description in board persisted", desc, persistedBoard.getDescription());
		
		// and the persisted board should be returned with the correct name and description values
		assertNotNull(result);
		assertEquals("Unexpected name in board returned", name, result.getName());
		assertEquals("Unexpected description in board returned", desc, result.getDescription());
	}
	
	@Test
	public void shouldCreateCollectionIfItDoesNotExist() {
		// given that the board collection does not yet exist
		BDDMockito.given(mongoOperations.collectionExists(Board.class)).willReturn(false);
		
		// when createNewBoard is invoked with valid values
		boardService.createNewBoard("name", "description");
		
		// then the board collection should be created
		Mockito.verify(mongoOperations).createCollection(Board.class);
	}

	@Test
	public void shouldNotCreateCollectionIfItAlreadyExists() {
		// given that the board collection already exists
		BDDMockito.given(mongoOperations.collectionExists(Board.class)).willReturn(true);
		
		// when createNewBoard is invoked with valid values
		boardService.createNewBoard("name", "description");
		
		// then the board collection should not be created
		Mockito.verify(mongoOperations, Mockito.times(0)).createCollection(Board.class);
	}

}
