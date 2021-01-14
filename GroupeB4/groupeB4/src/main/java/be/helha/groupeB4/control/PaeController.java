package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.ejb.PaeEJB;
import be.helha.groupeB4.ejb.StudentEJB;
import be.helha.groupeB4.entities.LearningUnit;
import be.helha.groupeB4.entities.Pae;
import be.helha.groupeB4.entities.Student;

@ManagedBean
@Named("pc")
@ViewScoped
public class PaeController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private PaeEJB ejb;
	
	
	
	
	private Student student;


	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	public Pae doSelectPae(){
		return ejb.getPAE(student.getPae()); 
	}
	
	public List<LearningUnit> getlists(){
		Pae pae = doSelectPae();
		
		return pae.getUeList();
	}
	
	
	
	

}
