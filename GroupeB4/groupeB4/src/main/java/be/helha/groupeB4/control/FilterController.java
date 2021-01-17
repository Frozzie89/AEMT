package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.ejb.StudentEJB;
import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.enumeration.EPaeProgress;
import be.helha.groupeB4.excel.InsertStudentFromExcel;


@ManagedBean
@Named("fc")
@ViewScoped
public class FilterController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private HtmlDataTable table;
	
	@Inject
	private StudentEJB ejb;

	private InsertStudentFromExcel stfu;
	private String nom;
	
	private List<Student> students;
	private List<Student> filteredStudents;
	
	@PostConstruct
    public void postConstruct() {
		students = ejb.getAllStudent(); 
    }

	private int getInteger(String string) {
        try {
            return Integer.valueOf(string);
        }
        catch (NumberFormatException ex) {
            return 0;
        }
    }
	
	// Calls Ejb Method to get all students
	public List<Student> doSelectAll(){
		return ejb.getAllStudent(); 
	}
	
	// Calls Ejb Method to get all students by name
	public List<Student> doSelectAllByName(String nom){
		return ejb.getAllStudentByName(nom); 
	}
	
	// Calls Ejb Method to add students
	public List<Student> addLA() {
		List<Student> maliste = new ArrayList<>();
		maliste = stfu.createStudents();
		ejb.addStudent();
		return maliste;
	}
	
	// Calls Ejb Method to delete a student
	public String delete() {
		Student student = (Student) table.getRowData();
		ejb.deleteStudent(student);
		return "";
	}
	
	// GET & SET
	public HtmlDataTable getTable() {
		return table;
	}

	public void setTable(HtmlDataTable table) {
		this.table = table;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Student> getFilteredStudents() {
		return filteredStudents;
	}

	public void setFilteredStudents(List<Student> filteredStudents) {
		this.filteredStudents = filteredStudents;
	}
	
	// Retourne la liste des progress de l'enum EPaeProgress
	public List<String> getListPaeProgress(){
		List<String> paeProgress = new ArrayList<>();
		
		for (EPaeProgress pae : EPaeProgress.values()) { 
			paeProgress.add(pae.getProgress().toString());
		}
		return paeProgress;
	}
	
	public List<String> getListBloc(){
		List<String> listBloc = new ArrayList<>();
		listBloc.add("1");
		listBloc.add("2");
		listBloc.add("3");
		return listBloc;
	}
	
	public List<String> getListSections(){
		List<String> listSections = new ArrayList<>();
		
		listSections.add("Comptabilite");
		listSections.add("Informatique");
		listSections.add("Assistant");
		return listSections;
	}
	// Fin GET & SET
	
	
	
	
	
}
