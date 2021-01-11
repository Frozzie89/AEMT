package be.helha.groupeB4.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LearningUnit implements Serializable{
	@Id
	private String id;
	private String label;
	private int totalCredits;
	private String schoolYear;
	
	@OneToMany(cascade= CascadeType.PERSIST)
	private List<LearningActivity> aaList;
	
	public LearningUnit() {
		aaList = new ArrayList<>();
	}

	public LearningUnit(String id, String label, int totalCredits, String schoolYear) {
		super();
		this.id = id;
		this.label = label;
		this.totalCredits = totalCredits;
		this.schoolYear = schoolYear;
		aaList = new ArrayList<>();
	}
	
	public boolean addLearning(LearningActivity aa) {
		if(aaList.contains(aa) || aa == null) {
			return false;
		}
		aaList.add(aa);
		return true;
	}
	
	public boolean removeLearningActivity(LearningActivity aa) {
		if(!aaList.contains(aa)){
			return false;
		}
		aaList.remove(aa);
		return true;
	}
	
	public double getMeanGrade() {
		double tmp = 0.;
		for(int i = 0 ; i < aaList.size() ; i++){
			tmp += aaList.get(i).getGrade();
		}
		return tmp;
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

	public int getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public List<LearningActivity> getAaList() {
		return aaList;
	}

	public void setAaList(List<LearningActivity> aaList) {
		this.aaList = aaList;
	}
	//----------------------- Fin GET & SET -----------------------

	@Override
	public String toString() {
		return "LearningUnit [id=" + id + ", label=" + label + ", totalCredits=" + totalCredits + ", schoolYear="
				+ schoolYear + ", aaList=" + aaList + "]";
	}
	
	
}
