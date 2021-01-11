package be.helha.groupeB4.ejb;

import java.util.List;

import be.helha.groupeB4.entities.Student;

public interface IStudentRemote {
	
	

	Student addStudent(Student student);
	List<Student> getAllStudent();
	Student deleteStudent(Student student);
	Student updateStudent(Student oldStudent, Student newStudent);
	List<Student> getAllStudentByName(String str);
	Student getStudentByID(int idStudent);
	

}
