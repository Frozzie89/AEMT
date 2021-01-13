package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.entities.User;
import test.UEJB;

@Named
@SessionScoped
public class TestU implements Serializable{
	
	
	@Inject
	private UEJB ejb;
	
	
	public List<User> doSelectAll(){
		return ejb.getAllUsers(); 
	}
	
	

}
