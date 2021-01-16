package be.helha.groupeB4.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.groupeB4.entities.User;

@Stateless
public class UserDAO{
	
	@PersistenceContext(unitName = "groupeB4")
	private EntityManager em; 

	// adds a user into the db
	public User addUser(User user) {
		// First check if user's username is not already in db
		if (getUser(user.getUserName()) != null) {
			return null;
		}
		
		// If not, add user in db
		em.persist(user);
		return user;			
	}

	// returns all users from db
	public List<User> getAllUsers() {
		return em.createQuery("SELECT user FROM User user").getResultList();
	}

	// deletes a User in db
	public User deleteUser(User user) {
		// first check if User exists
		User userToDelete = getUser(user.getUserName());
		
		// If User exists remove it from db
		if (userToDelete != null)
		{
			em.remove(userToDelete);
			return userToDelete;
		}
		
		// Else, return null, meaning that the User hasn't been found
		return null;
	}

	// returns a user by its username
	public User getUser(String userName) {
		String sqlRequestStr = "SELECT user from User user WHERE user.userName = ?1 ";
		TypedQuery<User> query = em.createQuery(sqlRequestStr, User.class);
		query.setParameter(1, userName);
		List<User> result = query.getResultList();
		return result.isEmpty()? null:result.get(0);
	}

}
