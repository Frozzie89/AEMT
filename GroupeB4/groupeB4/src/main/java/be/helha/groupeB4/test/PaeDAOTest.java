package be.helha.groupeB4.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.helha.groupeB4.dao.PaeDAO;

public class PaeDAOTest {
	
	private PaeDAO paeDao;
	
	@Before
	public void setUp() throws Exception {
		paeDao = new PaeDAO();
	}

	@After
	public void tearDown() throws Exception {
		paeDao = null;
	}

	@Test
	public void testAddPAE() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetAllPaes() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDeletePae() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdatePae() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFindPae() {
		fail("Not yet implemented");
	}

}
