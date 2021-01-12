package test;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.groupeB4.entities.Student;

@Stateless
public class STDAO {

	@PersistenceContext(unitName = "groupeB4")
	private EntityManager em; 
	
	
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		em.persist(student);
		return student;
	}

	
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT student From Student student").getResultList();
	}

	
	public Student deleteStudent(Student student) {
		// TODO Auto-generated method stub
		 if(student ==null)
			 return null;
		 em.remove(student);
	;
		 return student;
		
	}


	public Student updateStudent(Student oldStudent, Student newStudent) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Student> getAllStudentByName(String str) {
		// TODO Auto-generated method stub
		List<Student> toCompareList = new ArrayList<>();
		toCompareList = em.createQuery("SELECT student From Student student").getResultList();
		
		List<Student> sortedList = new ArrayList<>();
		
		for(Student s : toCompareList) {
			if(s.getFirstName().startsWith("str"))
					sortedList.add(s);
		}
		
		
		return sortedList;
	}

	
	public Student getStudentByID(int idStudent) {
		// TODO Auto-generated method stub
		return null;
	}
}
