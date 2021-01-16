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
		
	// adds a student in Db
	public Student addStudent(Student student) {
		// cleanTables();
		em.persist(student);
		return student;
	}
	
	// adds multiple Students at once in db
	public List<Student> addStudents(List<Student> students) {
		//cleanTables();
		for (int i=0; i< students.size() ;i++) {
			em.persist(students.get(i));
		}
		return students;
	}
	
	// returns all Students from db
	public List<Student> getAllStudent() {
		return em.createQuery("SELECT student From Student student").getResultList();
	}

	// Delete student from Db
	public Student deleteStudent(Student student) {
		
		// First check if arg is not null
		if(student ==null)
			 return null;
		 
		
		em.remove(student);
		return student;
	}


	// replace a student with another student
	public Student updateStudent(Student oldStudent, Student newStudent) {
		
		// First check if data is correct
		if(oldStudent == null || newStudent == null || oldStudent.getId()<0) {
			return null;
		}
		// Then find old Student 
		Student tmp = findStudent(oldStudent);
		if(tmp == null) {
			return null;
		}
		
		// Finally, replace old Student by new Student in db
		tmp = newStudent;
		tmp.setId(oldStudent.getId());
		em.merge(tmp);
		return tmp;
		}
	
	
	// Returns a student
	public Student findStudent(Student s) {
		// If Student has been found, returns it, else returns null
		Student sFound = em.find(Student.class, s.getId());
		if(sFound == null) {
			return null;
		}
		return sFound;
	}

	
	// Returns all Student by name
	public List<Student> getAllStudentByName(String str) {
		
		// First, get all Students
		List<Student> toCompareList = new ArrayList<>();
		toCompareList = getAllStudent();
		
		// Then sort the arraylist
		List<Student> sortedList = new ArrayList<>();
		String studentName;
		
		// Finally, filter the sortedList and return it
		for (int i=0; i< toCompareList.size() ;i++) {
		    studentName = toCompareList.get(i).getFirstName();
		    
		    if(studentName.startsWith(str)) {
		    	sortedList.add(toCompareList.get(i));
		    }
		}
		
		return sortedList;
	}

	
	// returns a Student by its ID
	public Student getStudentByID(int idStudent) {
		return null;
	}
	
	// Cleans all Students concerned tables from DB
	public void cleanTables() {

		// prepare queries
        Query q1 = em.createQuery("DELETE * FROM learningactivity");
        Query q2 = em.createQuery("DELETE * FROM learningunit");
        Query q3 = em.createQuery("DELETE * FROM learningunit_learningactivity");
        Query q4 = em.createQuery("DELETE * FROM pae");
        Query q5 = em.createQuery("DELETE * FROM pae_learningunit");
        Query q6 = em.createQuery("DELETE * FROM student");
        
        // executes queries
        q5.executeUpdate();
        q4.executeUpdate();
        q3.executeUpdate();
        q2.executeUpdate();
        q1.executeUpdate();
        q6.executeUpdate();
	}
	
}
