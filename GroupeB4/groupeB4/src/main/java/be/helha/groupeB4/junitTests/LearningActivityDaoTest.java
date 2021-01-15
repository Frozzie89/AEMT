package be.helha.groupeB4.junitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.helha.groupeB4.dao.LearningActivityDAO;
import be.helha.groupeB4.entities.LearningActivity;

public class LearningActivityDaoTest {

	private LearningActivityDAO learningActivityDao;

	@Before
	public void setUp() throws Exception {
		learningActivityDao = new LearningActivityDAO();
	}

	@After
	public void tearDown() throws Exception {
		learningActivityDao = null;
	}

	@Test
	public void testAddLearningActivity() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testgGetLearningActivity() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetAllLearningActivities() {
		fail("Not yet implemented");
	}

}
