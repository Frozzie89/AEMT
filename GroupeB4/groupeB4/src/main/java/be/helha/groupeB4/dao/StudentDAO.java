package be.helha.groupeB4.dao;

import java.util.List;

import javax.ejb.Stateless;

import be.helha.groupeB4.entities.Student;

@Stateless
public class StudentDAO extends AbstractDAO implements IStudentDAO {

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		em.persist(student);
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT student From Student student").getResultList();
	}

	@Override
	public Student deleteStudent(Student student) {
		// TODO Auto-generated method stub
		 if(student ==null)
			 return null;
		 em.remove(student);
	;
		 return student;
		
	}

	@Override
	public Student updateStudent(Student oldStudent, Student newStudent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudentByName(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentByID(int idStudent) {
		// TODO Auto-generated method stub
		return null;
	}

}
