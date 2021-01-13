package be.helha.groupeB4.control;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.ejb.UserEJB;
import be.helha.groupeB4.entities.User;

@Named
@SessionScoped
public class UserController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UserEJB ejb;
	
	private User user;
	private String passwordConfirm;
	
	public List<User> doSelectAll(){
		return ejb.getAllUsers(); 
	}
	
	public User addUser() {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    byte[] byteOfTextToHash = passwordConfirm.getBytes(StandardCharsets.UTF_8);
	    byte[] hashedByetArray = digest.digest(byteOfTextToHash);
	
	    String encodedPasswordConfirm = Base64.getEncoder().encodeToString(hashedByetArray);
		
	    
	    if (encodedPasswordConfirm.equals(user.getPassword())) {	    	
			ejb.addUser(user);
	    }
	    
	    return user;
	}
	public void deleteUser(){
		ejb.deleteUser(user);
	}
	
	

}
