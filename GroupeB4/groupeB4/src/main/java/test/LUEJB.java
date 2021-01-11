package test;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeB4.entities.LearningActivity;
import be.helha.groupeB4.entities.LearningUnit;

@Stateless
public class LUEJB {
	
	
	@EJB
	private LUDAO dao;
	
	
	public LearningUnit addLearningUnit(LearningUnit ue) {
		// TODO Auto-generated method stub
		return dao.addLearningUnit(ue);
	}

	
	public LearningUnit getLearningUnit(String identification) {
		// TODO Auto-generated method stub
		return dao.getLearningUnit(identification);
	}

	
	public List<LearningUnit> getAllLearningUnits() {
		// TODO Auto-generated method stub
		return dao.getAllLearningUnits();
	}

	
	public List<LearningActivity> getAllLearningActivities() {
		// TODO Auto-generated method stub
		return dao.getAllLearningActivities();
	}


}
