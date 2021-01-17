package be.helha.groupeB4.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
public class LearningUnit implements Serializable{
	@Id
	private String id;
	private String label;
	private int totalCredits;
	private String schoolYear;
	
	
	@OneToMany( fetch = FetchType.EAGER, orphanRemoval= true,cascade= {CascadeType.ALL})
	@CascadeOnDelete
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
	
	public boolean addLearningActivity(LearningActivity aa) {
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

	
	public String toStringAAList() {
		String tmp ="";
		
		for(LearningActivity a : aaList) {
			tmp += a.toString()+"\n";
		}
		return tmp;
	}

	@Override
	public String toString() {
		return "LearningUnit [id=" + id + ", label=" + label + ", totalCredits=" + totalCredits + ", schoolYear="
				+ schoolYear + ", aaList=" + aaList + "]";
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
		LearningUnit other = (LearningUnit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
