package test;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.excel.InsertStudentFromExcel;

@Stateless
public class STDAO {

	@PersistenceContext(unitName = "groupeB4")
	private EntityManager em; 
	
	private InsertStudentFromExcel stu;
	
	public List<Student> getliste(){
		List<Student> studs = new ArrayList<Student>();
		
		studs = stu.createStudents();
		addStudents(studs);
		
		
		return studs;
	
	}
	
	
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		em.persist(student);
		return student;
	}
	
	
	public List<Student> addStudents(List<Student> students) {
		
		
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
	

}
