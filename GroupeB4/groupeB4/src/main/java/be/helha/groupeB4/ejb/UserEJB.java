package be.helha.groupeB4.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeB4.dao.UserDAO;
import be.helha.groupeB4.entities.User;

@Stateless
public class UserEJB{
	
	@EJB
	private UserDAO dao;

	// Calls Dao Method to add a user
	public User addUser(User user) {
		return dao.addUser(user);
	}
	
	// Calls Dao Method to get all users
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	// Calls Dao Method to delete a user
	public User deleteUser(User user) {
		return dao.deleteUser(user);
	}

	// Calls Dao Method to get a user
	public User getUser(String userName) {
		return dao.getUser(userName);
	}

}
