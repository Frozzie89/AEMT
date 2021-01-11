package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.ejb.StudentEJB;
import be.helha.groupeB4.entities.Student;

@Named
@RequestScoped
public class TestC implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private StudentEJB ejb;
	
	public List<Student> doSelectAll(){
		return ejb.getAllStudent(); 
	}
	
	

}
