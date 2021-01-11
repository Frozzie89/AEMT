package be.helha.groupeB4.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeB4.dao.LearningUnitDAO;
import be.helha.groupeB4.entities.LearningActivity;
import be.helha.groupeB4.entities.LearningUnit;

@Stateless
public class LearningUnitEJB implements ILearningUnitRemote {

	@EJB
	private LearningUnitDAO dao;
	
	@Override
	public LearningUnit addLearningUnit(LearningUnit ue) {
		// TODO Auto-generated method stub
		return dao.addLearningUnit(ue);
	}

	@Override
	public LearningUnit getLearningUnit(String identification) {
		// TODO Auto-generated method stub
		return dao.getLearningUnit(identification);
	}

	@Override
	public List<LearningUnit> getAllLearningUnits() {
		// TODO Auto-generated method stub
		return dao.getAllLearningUnits();
	}

	@Override
	public List<LearningActivity> getAllLearningActivities() {
		// TODO Auto-generated method stub
		return dao.getAllLearningActivities();
	}

}
