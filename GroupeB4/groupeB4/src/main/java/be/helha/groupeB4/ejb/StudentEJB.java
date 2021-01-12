package be.helha.groupeB4.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeB4.dao.StudentDAO;
import be.helha.groupeB4.entities.Student;

@Stateless
public class StudentEJB  {

	
	@EJB
	private StudentDAO dao;

	//@Override
	public Student addStudent(Student student) {
	
		return dao.addStudent(student);
	}

	

	//@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return dao.getAllStudent();
	}

	//@Override
	public Student deleteStudent(Student student) {
		dao.deleteStudent(student);
		return student;
	}

	//@Override
	public Student updateStudent(Student oldStudent, Student newStudent) {
		return null;
	}

	//@Override
	public List<Student> getAllStudentByName(String str) {
		
		return dao.getAllStudentByName(str);
	}

	//@Override
	public Student getStudentByID(int idStudent) {
		// TODO Auto-generated method stub
		return dao.getStudentByID(idStudent);
	}
	
	
}
