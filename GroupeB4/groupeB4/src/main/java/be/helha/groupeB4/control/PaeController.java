package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.ejb.PaeEJB;
import be.helha.groupeB4.ejb.StudentEJB;
import be.helha.groupeB4.entities.LearningActivity;
import be.helha.groupeB4.entities.LearningUnit;
import be.helha.groupeB4.entities.Pae;
import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.enumeration.EPaeProgress;
import be.helha.groupeB4.enumeration.ESection;

@Named("pc")
@SessionScoped
public class PaeController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private PaeEJB ejb;

	private Student student ;

	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String doSelectPae(Student s){
		
		setStudent(s);
		student = s;
		return "paeCreation.xhtml?faces-redirect-true";
	}
	
	public List<LearningUnit> getlists(){

		return student.getPae().getUeList();
	}
	
	public List<LearningUnit> doGetUEFromLUC(){
		LearningUnitController luc = new LearningUnitController();
		//return luc.doSelectSectionUE(getStudent());
		return luc.doSelectAll();
	}

}
