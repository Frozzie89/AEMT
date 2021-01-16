package be.helha.groupeB4.test;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.helha.groupeB4.dao.LearningActivityDAO;
import be.helha.groupeB4.entities.LearningActivity;

public class LearningActivityDaoTest {

	@Inject
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
    	assertNull(learningActivityDao.getLearningActivity("ZZ999"));
    	
        LearningActivity laInput = new LearningActivity("ZZ999", "TEST", 42);
        learningActivityDao.addLearningActivity(laInput);

        LearningActivity laOutput = learningActivityDao.getLearningActivity("ZZ999");
        assertTrue(laInput.equals(laOutput));
        // fail("Not yet implemented");
    }

    @Test
    public void testgGetLearningActivity() {
    	LearningActivity laOutput = learningActivityDao.getLearningActivity("ZZ999");
    }

    @Test
    public void testGetAllLearningActivities() {
        fail("Not yet implemented");
    }

}
