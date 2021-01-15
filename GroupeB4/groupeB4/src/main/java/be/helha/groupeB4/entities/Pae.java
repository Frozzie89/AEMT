package be.helha.groupeB4.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.eclipse.persistence.annotations.CascadeOnDelete;

import be.helha.groupeB4.enumeration.EPaeProgress;

@Entity
public class Pae implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval= true,cascade= {CascadeType.ALL})
	private List<LearningUnit> ueList;
	
	private EPaeProgress paeProgress;

	public Pae() {
		super();
		paeProgress = paeProgress.A_FAIRE;
		this.ueList = new ArrayList<LearningUnit>();
	}
	
	public Pae(EPaeProgress paeProgress) {
		super();
		this.paeProgress = paeProgress;
		this.ueList = new ArrayList<LearningUnit>();
	}
	public Pae(EPaeProgress paeProgress, List<LearningUnit> ueList) {
		super();
		this.paeProgress = paeProgress;
		this.ueList = ueList;
	}

	public boolean addLearningUnit(LearningUnit ue) {
		if(ueList.contains(ue) || ue == null || ue.getAaList() == null) {
			return false;
		}
		ueList.add(ue);
		return true;
	}
	
	public boolean removeLearningUnit(LearningUnit ue) {
		if(!ueList.contains(ue)) {
			return false;
		}
		
		ueList.remove(ue);
		return true;
	}
	
	//----------------------- GET & SET -----------------------
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public List<LearningUnit> getUeList() {
		return ueList;
	}

	public void setUeList(List<LearningUnit> ueList) {
		this.ueList = ueList;
	}
	
	public EPaeProgress getPaeProgress() {
		return paeProgress;
	}
	public String getPaeProgressValue() {
		return paeProgress.getProgress();
	}

	public void setPaeProgress(EPaeProgress paeProgress) {
		this.paeProgress = paeProgress;
	}

	//----------------------- Fin GET & SET -----------------------

	@Override
	public String toString() {
		return ueList + "\n, Etat du PAE: " + paeProgress.getProgress() + "\n";
	}
	
	
}
