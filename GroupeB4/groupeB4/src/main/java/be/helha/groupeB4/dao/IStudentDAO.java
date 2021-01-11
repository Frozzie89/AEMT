package be.helha.groupeB4.dao;

import java.util.List;

import be.helha.groupeB4.entities.Pae;
import be.helha.groupeB4.entities.Student;

public interface IStudentDAO {
	
	public Student addStudent(Student student);
	public List<Student> getAllStudent();
	public Student deleteStudent(Student student);
	public Student updateStudent(Student oldStudent, Student newStudent);
	public List<Student> getAllStudentByName(String str);
	public Student getStudentByID(int idStudent);
	
	

}
