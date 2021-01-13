package be.helha.groupeB4.control;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.ejb.UserEJB;
import be.helha.groupeB4.entities.User;


@Named
@RequestScoped
public class UserControl implements Serializable {
	
	@Inject
	private UserEJB userEJB;
	
	private User user;
	private String passwordConfirm;

	public void addUser() {
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
	    	userEJB.addUser(user);
	    }
		
	}
	
	// GETTERS AND SETTERS
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	
	
}
