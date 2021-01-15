package be.helha.groupeB4.junitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.helha.groupeB4.dao.LearningUnitDAO;

public class LearningUnitDaoTest {
	
	private LearningUnitDAO learningUnitDao;

	@Before
	public void setUp() throws Exception {
		learningUnitDao = new LearningUnitDAO();
	}

	@After
	public void tearDown() throws Exception {
		learningUnitDao = null;
	}

	@Test
	public void testAddLearningUnit() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAddLearningUnits() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetLearningUnit() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetAllLearningUnits() {
		fail("Not yet implemented");
	}

}
