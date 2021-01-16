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

	public List<Student> addStudent() {
		return dao.getAllStudent();
	}

	// Calls Dao Method to add a student
	public Student addStudent(Student student) {
		return dao.addStudent(student);
	}
	
	// Calls Dao Method to add multiple students
	public List<Student> addStudents(List<Student> l_students) {
		return dao.addStudents(l_students);
	}
	
	// Calls Dao Method to get all students
	public List<Student> getAllStudent() {
		return dao.getAllStudent();
	}
	
	// Calls Dao Method to clean all student concerned tables
	public void clean() {
		dao.cleanTables();
		return;
	}
	
	// Calls Dao Method to delete a student
	public Student deleteStudent(Student student) {
		dao.deleteStudent(student);
		return student;
	}

	// Calls Dao Method to update a student
	public Student updateStudent(Student oldStudent, Student newStudent) {
		return dao.updateStudent(oldStudent, newStudent);
	}

	// Calls Dao Method to get a list of student by name
	public List<Student> getAllStudentByName(String str) {
		return dao.getAllStudentByName(str);
	}

	// Calls Dao Method to get a student by its ID
	public Student getStudentByID(int idStudent) {
		return dao.getStudentByID(idStudent);
	}
	
	
}
