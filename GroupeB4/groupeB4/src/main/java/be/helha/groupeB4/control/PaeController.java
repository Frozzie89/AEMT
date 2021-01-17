package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

// import org.jboss.weld.module.EjbSupport;

import be.helha.groupeB4.ejb.PaeEJB;
import be.helha.groupeB4.ejb.StudentEJB;
import be.helha.groupeB4.entities.LearningUnit;
import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.enumeration.EPaeProgress;

@Named("pc")
@SessionScoped
public class PaeController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PaeEJB ejb;

	@Inject
	private StudentEJB ejbStudent;

	private Student student ;
	private Student studentCopy ;
	private List<LearningUnit> paeList;
	
	private List<LearningUnit> listUEAvailable;

	public void addUEToPAE(LearningUnit lu){
		student.getPae().addLearningUnit(lu);
		updatePae();
	}
	
	public void removeUEFromPAE(LearningUnit lu){
		student.getPae().removeLearningUnit(lu);
		updateStudent();
	}
	
	public void getAllUEFromSection(){
		LearningUnitController luc = new LearningUnitController();
		List<LearningUnit> tmp = new ArrayList<>();
		tmp = student.getPae().getUeList();
		listUEAvailable =  luc.doSelectSectionUE(student);
		for (int i = 0; i < tmp.size(); i++) {
			if(listUEAvailable.contains(tmp.get(i))) {
				listUEAvailable.remove(tmp.get(i));
			}
		}
	}
	
	// Update
	public void updatePae() {
		ejb.updatePae(studentCopy.getPae(), student.getPae());
	}
	
	public void updateStudent() {
		ejbStudent.updateStudent(studentCopy, student);
	}

	public int calculCredit() {
		
		int total = 0;
		
		for(LearningUnit ue : student.getPae().getUeList()) {
			total += ue.getTotalCredits();
		}
		
		return total;
	}

	// GET & SET
	public List<LearningUnit> getlists(){
		setPaeList(student.getPae().getUeList());
		return student.getPae().getUeList();
	}
	
	public List<LearningUnit> getPaeList() {
		return paeList;
	}

	public void setPaeList(List<LearningUnit> paeList) {
		this.paeList = paeList;
	}
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}

	public Student getStudentCopy() {
		return studentCopy;
	}

	public void setStudentCopy(Student studentCopy) {
		this.studentCopy = studentCopy;
	}

	public List<LearningUnit> getListUEAvailable() {
		return listUEAvailable;
	}

	public void setListUEAvailable(List<LearningUnit> listUEAvailable) {
		this.listUEAvailable = listUEAvailable;
	}

	
	// Redirect method
	public String endPae() {
		student.getPae().setPaeProgress(EPaeProgress.TERMINE);
		updateStudent();
		return "paeCreation.xhtml?faces-redirect-true";
	}
	
	public String doSelectPae(Student s){
		
		setStudent(s);
		setStudentCopy(s);
		student.getPae().setPaeProgress(EPaeProgress.EN_COURS);
		return "paeCreation.xhtml?faces-redirect-true";
	}
	
}
