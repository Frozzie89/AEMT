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

	public User addUser(User user) {
		return dao.addUser(user);
	}

	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	public User deleteUser(User user) {
		return dao.deleteUser(user);
	}

	public User getUser(String userName) {
		return dao.getUser(userName);
	}

}
