package be.helha.groupeB4.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeB4.dao.StudentDAO;
import be.helha.groupeB4.entities.Student;
@Stateless
public class StudentEJB implements IStudentRemote{

	
	@EJB
	private StudentDAO dao;
	

	@Override
	public Student addStudent(Student student) {
	
		return dao.addStudent(student);
	}

}
