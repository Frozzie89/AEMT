package test;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.groupeB4.entities.User;

@Stateless
public class UDAO {
	
	@PersistenceContext(unitName = "groupeB4")
	private EntityManager em; 
	
	public User addUser(User user) {
		em.persist(user);
		return user;
	}

	
	public List<User> getAllUsers() {
		return em.createQuery("SELECT user FROM User user").getResultList();
	}

	
	public User deleteUser(User user) {
		User userToDelete = getUser(user.getUserName());
		if (userToDelete != null)
		{
			em.remove(userToDelete);
			return userToDelete;
		}
		return null;
	}

	
	public User getUser(String userName) {
		String sqlRequestStr = "SELECT user from User user"
                + "WHERE user.userName = ?1 ";
		TypedQuery<User> query = em.createQuery(sqlRequestStr, User.class);
		query.setParameter(1, userName);
		List<User> result = query.getResultList();
		return result.isEmpty()? null:result.get(0);
	}


}
