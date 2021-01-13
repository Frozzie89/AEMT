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
	
	private String userName, userPassword;
	private String passwordConfirm;
	
	public List<User> doSelectAll(){
		return ejb.getAllUsers(); 
	}
	
	public String addUser() {
		
		User userToCreate = new User(userName, userPassword, "ADMIN");
		
	    if (passwordConfirm.equals(userToCreate.getPassword())) {	    	
			ejb.addUser(userToCreate);
	    }
	    
	    return "home.xhtml";
	}
	
	private String encryptSHA256(String stringValue) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    byte[] byteOfTextToHash = stringValue.getBytes(StandardCharsets.UTF_8);
	    byte[] hashedByetArray = digest.digest(byteOfTextToHash);
	
	    return Base64.getEncoder().encodeToString(hashedByetArray);
	}
	public void deleteUser(){
		// ejb.deleteUser(user);
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = encryptSHA256(passwordConfirm);
	}
	
	


}
