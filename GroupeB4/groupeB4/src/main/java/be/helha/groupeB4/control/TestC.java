package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.entities.LearningActivity;
import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.excel.studentExcel;
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
	
	private studentExcel stfu;
	
	
	public List<Student> doSelectAll(){
		System.out.println("Salut");
		return ejb.getAllStudent(); 
	}
	
	public List<Student> doSelectAllName(){
		return ejb.getAllStudentByName("s"); 
	}
	
	public List<Student> addLA() {
		
		
		List<Student> maliste = new ArrayList<>();
		maliste = stfu.test();
		ejb.addStudent();
		return maliste;
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
