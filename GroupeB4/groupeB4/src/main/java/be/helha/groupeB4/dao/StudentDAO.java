package be.helha.groupeB4.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.excel.InsertStudentFromExcel;

@Stateless
public class StudentDAO{
	
	@PersistenceContext(unitName = "groupeB4")
	private EntityManager em; 
	
	private InsertStudentFromExcel stu;
		
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		// cleanTables();
		em.persist(student);
		return student;
	}
	
	
	
	
	
	public List<Student> addStudents(List<Student> students) {
		//cleanTables();
		for (int i=0; i< students.size() ;i++) {
			em.persist(students.get(i));
		}
		return students;
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
		 return student;
	}


	public Student updateStudent(Student oldStudent, Student newStudent) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Student> getAllStudentByName(String str) {
		// TODO Auto-generated method stub
		List<Student> toCompareList = new ArrayList<>();
		
		toCompareList = getAllStudent();
		
		List<Student> sortedList = new ArrayList<>();
		String studentName;
		
		for (int i=0; i< toCompareList.size() ;i++) {
		    studentName = toCompareList.get(i).getFirstName();
		    
		    if(studentName.startsWith(str)) {
		    	sortedList.add(toCompareList.get(i));
		    }
		}
		
		
		return sortedList;
	}

	
	public Student getStudentByID(int idStudent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void cleanTables() {

        Query q1 = em.createQuery("DELETE * FROM learningactivity");
        Query q2 = em.createQuery("DELETE * FROM learningunit");
        Query q3 = em.createQuery("DELETE * FROM learningunit_learningactivity");
        Query q4 = em.createQuery("DELETE * FROM pae");
        Query q5 = em.createQuery("DELETE * FROM pae_learningunit");
        Query q6 = em.createQuery("DELETE * FROM student");
        
        q5.executeUpdate();
        q4.executeUpdate();
        q3.executeUpdate();
        q2.executeUpdate();
        q1.executeUpdate();
        q6.executeUpdate();
	}
	
}
