package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.ejb.StudentEJB;
import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.enumeration.ESection;
import test.STDEJB;

@Named
@RequestScoped
public class TestC implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private STDEJB ejb;
	
	public List<Student> doSelectAll(){
		return ejb.getAllStudent(); 
	}
	
	public List<Student> doSelectAllName(){
		return ejb.getAllStudentByName("s"); 
	}
	
	public Student add() {
		Student s2 = new Student("s2", "levecq", "1776458", "20/21", 2,ESection.INFORMATIQUE_DE_GESTION );		
		ejb.addStudent(s2);
		return s2;
		
	}
	
	

}
