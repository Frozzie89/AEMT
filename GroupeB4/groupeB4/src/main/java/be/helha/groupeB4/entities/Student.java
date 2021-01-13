package be.helha.groupeB4.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import be.helha.groupeB4.enumeration.EPaeProgress;
import be.helha.groupeB4.enumeration.ESection;

@Entity
public class Student implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String registrationNumber;
	private String schoolYear;
	
	private int bloc;
	
	@OneToOne(cascade= CascadeType.ALL)
	private Pae pae;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="student_learningActivity",
			joinColumns = {@JoinColumn(name="student_id", referencedColumnName ="id")},
			inverseJoinColumns = {@JoinColumn(name = "learningActivity_id", referencedColumnName ="id")})
	@MapKey(name="id")
	private Map<LearningActivity, Grade> bulletin;
	
	private ESection section;
	
	public Student() {
		// TODO Auto-generated constructor stub
		pae = new Pae(EPaeProgress.A_FAIRE);
		bulletin = new HashMap<>();
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
		bulletin = new HashMap<>();
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
	
	public String getSectionValue() {
		return section.getSection();
	}

	public void setSection(ESection section) {
		this.section = section;
	}
	
	public Map<LearningActivity, Grade> getBulletin() {
		return bulletin;
	}

	public void setBulletin(Map<LearningActivity, Grade> bulletin) {
		this.bulletin = bulletin;
	}
	

	//----------------------- Fin GET & SET -----------------------	

	@Override
	public String toString() {
		return "\nStudent " + id 
				+ ", " + firstName + ", " + lastName 
				+ ", " + registrationNumber + ", " + schoolYear 
				+ ", bloc=" + bloc 
				+ " section=" + section.getSection() + "\n"
				+ ", pae:" + pae
				+" grade: " +bulletin.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
