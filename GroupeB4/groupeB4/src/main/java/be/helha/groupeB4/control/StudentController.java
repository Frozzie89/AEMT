package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.ejb.StudentEJB;
import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.excel.InsertStudentFromExcel;


@Named
@SessionScoped
public class StudentController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private HtmlDataTable table;
	
	@Inject
	private StudentEJB ejb;

	private InsertStudentFromExcel stfu;
	private String nom;
	
	public List<Student> doSelectAll(){
		return ejb.getAllStudent(); 
	}
	
	public List<Student> doSelectAllByName(String nom){
		return ejb.getAllStudentByName(nom); 
	}
	
	public List<Student> addLA() {
		List<Student> maliste = new ArrayList<>();
		maliste = stfu.createStudents();
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
