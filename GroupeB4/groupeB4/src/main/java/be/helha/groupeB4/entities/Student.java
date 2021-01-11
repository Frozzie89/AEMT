package be.helha.groupeB4.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import be.helha.groupeB4.enumeration.EPaeProgress;
import be.helha.groupeB4.enumeration.ESection;

@Entity
public class Student implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String registrationNumber;
	private String schoolYear;
	
	private int bloc;
	
	@OneToOne
	private Pae pae;
	
	private ESection section;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastName, String registrationNumber, String schoolYear, int bloc, ESection section) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.registrationNumber = registrationNumber;
		this.schoolYear = schoolYear;
		this.bloc = bloc;
		this.section = section;
		pae = new Pae(EPaeProgress.A_FAIRE);
	}

	
	//----------------------- GET & SET -----------------------
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public int getBloc() {
		return bloc;
	}

	public void setBloc(int bloc) {
		this.bloc = bloc;
	}

	public Pae getPae() {
		return pae;
	}

	public void setPae(Pae pae) {
		this.pae = pae;
	}

	public ESection getSection() {
		return section;
	}

	public void setSection(ESection section) {
		this.section = section;
	}

	//----------------------- Fin GET & SET -----------------------	

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", registrationNumber="
				+ registrationNumber + ", schoolYear=" + schoolYear + ", bloc=" + bloc + ", pae=" + pae + ", section="
				+ section.getSection() + "]";
	}
}
