package be.helha.groupeB4.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grade implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double grade;
	
	public Grade() {
		// TODO Auto-generated constructor stub
	}

	public Grade(double grade) {
		super();
		this.grade = grade;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public boolean passExamen() {
		if(grade < 10) {
			return false;
		}
		return true;
	}
}
