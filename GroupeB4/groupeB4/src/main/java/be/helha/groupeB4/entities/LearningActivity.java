package be.helha.groupeB4.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LearningActivity implements Serializable{
	@Id
	private String id;
	private String label;
	private int credit;
	private double grade;
	
	public LearningActivity() {
		// TODO Auto-generated constructor stub
	}

	public LearningActivity(String id, String label, int credit, double grade) {
		super();
		this.id = id;
		this.label = label;
		this.credit = credit;
		this.grade = grade;
	}
	
	//----------------------- GET & SET -----------------------
	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	//----------------------- Fin GET & SET -----------------------

	@Override
	public String toString() {
		return "\t"+id + " " + label + ", credit=" + credit + ", grade: " + grade + "\n";
	}
}
