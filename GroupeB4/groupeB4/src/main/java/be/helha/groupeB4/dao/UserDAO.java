package be.helha.groupeB4.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import be.helha.groupeB4.entities.User;

public class UserDAO extends AbstractDAO implements IUserDAO{

	@Override
	public User addUser(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return em.createQuery("SELECT user FROM User user").getResultList();
	}

	@Override
	public User deleteUser(User user) {
		User userToDelete = getUser(user.getUserName());
		if (userToDelete != null)
		{
			em.remove(userToDelete);
			return userToDelete;
		}
		return null;
	}

	@Override
	public User getUser(String userName) {
		String sqlRequestStr = "SELECT user from User user"
                + "WHERE user.userName = ?1 ";
		TypedQuery<User> query = em.createQuery(sqlRequestStr, User.class);
		query.setParameter(1, userName);
		List<User> result = query.getResultList();
		return result.isEmpty()? null:result.get(0);
	}

}
