package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.List;

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
	
	
	public String doSelectPae(Student s){
/*	
		Student s1 = new Student("s1", "s1", "la1", "y1", 1, ESection.INFORMATIQUE_DE_GESTION);
		System.out.println("s1: " + s1.toString());
		
		Pae p1 = new Pae(EPaeProgress.TERMINE);
		
		LearningUnit ue1 = new LearningUnit("UE1", "ue1Label", 10, "y1");
		LearningUnit ue2 = new LearningUnit("UE2", "ue2Label", 10, "y2");
		
		LearningActivity aa1 = new LearningActivity("AA1", "aa1Label", 5);		
		LearningActivity aa2 = new LearningActivity("AA2", "aa2Label", 5);	
		LearningActivity aa3 = new LearningActivity("AA3", "aa3Label", 5);	
		
		ue1.addLearning(aa1);
		ue1.addLearning(aa2);
		ue2.addLearning(aa3);
		
		p1.addLearningUnit(ue1);
		p1.addLearningUnit(ue2);
		
		s1.setPae(p1);
		
		
		
		return s1.getPae();*/
		setStudent(s);
		return "paeCreation.xhtml?faces-redirect-true";
			//ejb.getPAE(student.getPae()); 
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
