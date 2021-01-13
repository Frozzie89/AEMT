package test;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeB4.entities.User;

@Stateless
public class UEJB {

	@EJB
	private UDAO dao;
	
	

	
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
