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
	
	public LearningActivity() {
		// TODO Auto-generated constructor stub
	}

	public LearningActivity(String id, String label, int credit) {
		super();
		this.id = id;
		this.label = label;
		this.credit = credit;
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

	public void setCredits(int credit) {
		this.credit = credit;
	}

	//----------------------- Fin GET & SET -----------------------

	@Override
	public String toString() {
		
		return id + " " + label + ", credit=" + credit + "     " ;
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
		LearningActivity other = (LearningActivity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
