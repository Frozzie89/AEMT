package be.helha.groupeB4.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.excel.InsertStudentFromExcel;

@Stateless
public class StudentDAO{
	
	@PersistenceContext(unitName = "groupeB4")
	private EntityManager em; 
	
	private InsertStudentFromExcel stu;
	UserTransaction utx;
		
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
		
		if(oldStudent == null || newStudent == null || oldStudent.getId()<0) {
			return null;
		}
		
		Student tmp = findStudent(oldStudent);
		if(tmp == null) {
			return null;
		}
		tmp = newStudent;
		tmp.setId(oldStudent.getId());
		em.merge(tmp);
		return tmp;
		}
	
	
	public Student findStudent(Student s) {
		Student sFound = em.find(Student.class, s.getId());
		if(sFound == null) {
			return null;
		}
		return sFound;
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
	
	public void cleanTables()  {
		

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("groupeB4");
		EntityManager eManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = eManager.getTransaction();

		   	Query q1 = eManager.createQuery("DELETE FROM Student");
		    Query q4 = eManager.createQuery("DELETE FROM LearningActivity");
		    Query q2 = eManager.createQuery("DELETE FROM Pae");
		    Query q3 = eManager.createQuery("DELETE FROM LearningUnit");

		    q1.executeUpdate();
		    q2.executeUpdate();
		    q3.executeUpdate();
		    q4.executeUpdate();

		    tx.commit();
			
			eManager.close();
			entityManagerFactory.close();
		

		
	}
	
}
