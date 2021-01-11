package be.helha.groupeB4.control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class TestControle implements Serializable{
	
	 

	
	public String doNext() {
		
		return "test2.xhtml";
	}
	
	
	
	
	
}
