package be.helha.groupeB4.dao;

import java.util.List;

import javax.ejb.Stateless;

import be.helha.groupeB4.entities.LearningActivity;
import be.helha.groupeB4.entities.LearningUnit;

@Stateless
public class LearningUnitDAO extends AbstractDAO implements ILearningUnitDAO{

	@Override
	public LearningUnit addLearningUnit(LearningUnit ue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LearningUnit getLearningUnit(String identification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LearningUnit> getAllLearningUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LearningActivity> getAllLearningActivities() {
		// TODO Auto-generated method stub
		return null;
	}

}
