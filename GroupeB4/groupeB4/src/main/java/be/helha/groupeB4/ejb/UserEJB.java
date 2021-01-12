package be.helha.groupeB4.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeB4.dao.UserDAO;
import be.helha.groupeB4.entities.User;

@Stateless
public class UserEJB implements IUserRemote {
	
	@EJB
	private UserDAO dao;

	@Override
	public User addUser(User user) {
		return dao.addUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public User deleteUser(User user) {
		return dao.deleteUser(user);
	}

	@Override
	public User getUser(String userName) {
		return dao.getUser(userName);
	}

}
