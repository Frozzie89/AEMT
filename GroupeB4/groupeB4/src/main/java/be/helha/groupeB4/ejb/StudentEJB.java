package be.helha.groupeB4.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeB4.dao.StudentDAO;
import be.helha.groupeB4.entities.Student;

@Stateless
public class StudentEJB {

	
	@EJB
	private StudentDAO dao;

	public Student addStudent(Student student) {
	
		return dao.addStudent(student);
	}
	
	public List<Student> addStudents(List<Student> students){
		return dao.addStudents(students);
	}
	
	public List<Student> addStudent() {
		
		return dao.getliste();
	}

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return dao.getAllStudent();
	}
	
	

	
	public Student deleteStudent(Student student) {
		dao.deleteStudent(student);
		return student;
	}

	
	public Student updateStudent(Student oldStudent, Student newStudent) {
		return null;
	}

	
	public List<Student> getAllStudentByName(String str) {
		
		return dao.getAllStudentByName(str);
	}

	
	public Student getStudentByID(int idStudent) {
		// TODO Auto-generated method stub
		return dao.getStudentByID(idStudent);
	}
	
	
}
