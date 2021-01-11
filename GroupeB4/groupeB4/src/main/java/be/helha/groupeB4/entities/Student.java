package be.helha.groupeB4.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String registrationNumber;
	private String schoolYear;
	
	private int bloc;
	
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastName, String registrationNumber, String schoolYear, int bloc) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.registrationNumber = registrationNumber;
		this.schoolYear = schoolYear;
		this.bloc = bloc;
	}
	
	
	
}
