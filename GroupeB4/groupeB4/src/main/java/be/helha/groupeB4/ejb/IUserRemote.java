package be.helha.groupeB4.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.groupeB4.entities.User;

@Remote
public interface IUserRemote {
	public User addUser(User user);
	public List<User> getAllUsers();
	public User deleteUser(User user);
	public User getUser(String userName);
}
