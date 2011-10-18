package com.greenboard.board;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/spring/boardRepository.xml"})
public class MongoBoardRepositoryTest {

	private static final String CHOPPINGBOARD = "choppingboard";
	private static final String CHEESEBOARD = "cheeseboard";
	@Autowired
	private MongoOperations mongoOperations;

	@Autowired
	private BoardRepository boardRepository;
	private Collection<String> allBoardNames;
	
	@Before
	public void setUp() throws Exception {
		
		mongoOperations.dropCollection(Board.class);
		Collection<Board> testData = new HashSet<Board>();
		testData.add(new Board(CHOPPINGBOARD));
		testData.add(new Board(CHEESEBOARD));
		mongoOperations.insertAll(testData );
		
		allBoardNames = new HashSet<String>();
		allBoardNames.add(CHEESEBOARD);
		allBoardNames.add(CHOPPINGBOARD);
	}

	@Test
	public void shouldReturnNullFromFindByNameIfNameDoesNotExist() {
		Board board = boardRepository.findByName("unknownName");
		assertNull("Did not expect a board to match the name", board);
	}
	
	@Test
	public void shouldReturnNullFromFindByNameIfNameIsNull() {
		Board board = boardRepository.findByName(null);
		assertNull("Did not expect a board to match the name", board);
	}
	
	@Test
	public void shouldFindBoardsByName() {
		// given a board name that exists in the repository
		String boardName = CHEESEBOARD;
		// when findByName is invoked with this name
		Board board = boardRepository.findByName(boardName);
		// then the corresponding board should be returned
		assertNotNull("findByName() returned null for cheeseboard", board);
		assertEquals(boardName, board.getName());
	}

	@Test
	public void shouldFindAllBoards() {
		// given 2 boards exist in the repository with the names cheeseboard and choppingboard
		// when findAll is invoked
		List<Board> allBoards = boardRepository.findAll();
		// then the 2 boards should be returned.
		assertEquals("Unexpected number of results returned", 2, allBoards.size());
		Set<String> boardNames = new HashSet<String>();
		for (Board board : allBoards) {
			boardNames.add(board.getName());
		}
		assertTrue("All boards returned does not contain the expected boards", boardNames.containsAll(allBoardNames));
	}

}
