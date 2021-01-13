package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.entities.LearningUnit;
import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.excel.InsertStudentFromExcel;
import test.LUEJB;
import test.STDEJB;

@Named
@SessionScoped
public class TestC implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HtmlDataTable table;
	
	@Inject
	private STDEJB ejb;
	
	@Inject
	private LUEJB ejb2;
	
	private InsertStudentFromExcel stfu;
	private String nom;
	
	
	public List<Student> doSelectAll(){
		System.out.println("Salut");
		return ejb.getAllStudent(); 
	}
	
	public List<Student> doSelectAllName(){
		return ejb.getAllStudentByName(nom); 
	}
	
	public List<Student> addLA() {
		
		
		List<Student> maliste = new ArrayList<>();
		maliste = stfu.createStudents();
		ejb.addStudent();
		return maliste;
	}
	
	public List<LearningUnit> addLU() {
		
		
		List<LearningUnit> maliste = new ArrayList<>();
		maliste = stfu.createLearningUnits();
		ejb2.addLearningUnits();
		return maliste;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	public String delete() {
		Student student = (Student) table.getRowData();
		ejb.deleteStudent(student);
		return "";
	}
	
	public HtmlDataTable getTable() {
		return table;
	}

	public void setTable(HtmlDataTable table) {
		this.table = table;
	}
}
