package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.ejb.UserEJB;
import be.helha.groupeB4.entities.User;

@Named
@SessionScoped
public class UserController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UserEJB ejb;
	
	public List<User> doSelectAll(){
		return ejb.getAllUsers(); 
	}
	
	
	public User addUser() {
		User u = new User();
		ejb.addUser(u);
		return u;
	}
	public void deleteUser(String userName){
		User u = ejb.getUser(userName);
		ejb.deleteUser(u);
		return;
	}
	
	

}
