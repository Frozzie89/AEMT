package be.helha.groupeB4.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeB4.dao.LearningUnitDAO;
import be.helha.groupeB4.entities.LearningUnit;

@Stateless
public class LearningUnitEJB {

	@EJB
	private LearningUnitDAO dao;
	
	// Calls Dao Method to add a unit activity
	public LearningUnit addLearningUnit(LearningUnit ue) {
		return dao.addLearningUnit(ue);
	}
	
	// Calls Dao Method to add mutliple units activities
	public List<LearningUnit> addLearningUnits(List<LearningUnit> ue) {
		return dao.addLearningUnits(ue);
	}

	// Calls Dao Method to get a learning unit  by its identification
	public LearningUnit getLearningUnit(String identification) {
		return dao.getLearningUnit(identification);
	}

	// Calls Dao Method to get all learning units
	public List<LearningUnit> getAllLearningUnits() {
		// TODO Auto-generated method stub
		return dao.getAllLearningUnits();
	}


}
