package be.helha.groupeB4.dao;

import java.util.List;

import be.helha.groupeB4.entities.User;


public interface IUserDAO {
	
	public User addUser(User user);
	public List<User> getAllUsers();
	public User deleteUser(User user);
	public User getUser(String userName);

}
