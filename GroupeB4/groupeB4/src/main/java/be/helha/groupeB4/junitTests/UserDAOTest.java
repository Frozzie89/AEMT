package be.helha.groupeB4.junitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.helha.groupeB4.dao.UserDAO;
public class UserDAOTest {
	
	private UserDAO userDao;

	@Before
	public void setUp() throws Exception {
		userDao = new UserDAO();
	}

	@After
	public void tearDown() throws Exception {
		userDao = null;
	}

	@Test
	public void addUser() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetAllUsers(){
		fail("Not yet implemented");
	}
	
	@Test
	public void testDeleteUser(){
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetUser(){
		fail("Not yet implemented");
	}
	

}
