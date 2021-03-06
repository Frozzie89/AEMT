package be.helha.groupeB4.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.helha.groupeB4.dao.UserDAO;
import be.helha.groupeB4.entities.User;

public class UserDAOTest {

	@EJB
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
        // fail("Not yet implemented");
        User userInput = new User("TEST_USERNAME", "TEST_PASSWORD", "TEST_ROLE");
        User userTest = null;
        userDao.addUser(userInput);

        List<User> userList = new ArrayList<>();
        userList = userDao.getAllUsers();
        User userOutput = null;

        for (User u : userList) {
            if (u.equals(userOutput))
                userOutput = userInput;
        }

        assertTrue(userInput.equals(userOutput));
    }

    @Test
    public void testGetAllUsers() {
    	 List<User> userList = new ArrayList<>();
         userList = userDao.getAllUsers();

         assertTrue(userList.size() > 0);
    }

    @Test
    public void testDeleteUser() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetUser() {
        fail("Not yet implemented");
    }

}
