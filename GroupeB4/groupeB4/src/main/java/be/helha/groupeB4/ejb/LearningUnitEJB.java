package be.helha.groupeB4.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeB4.dao.LearningUnitDAO;
import be.helha.groupeB4.entities.LearningActivity;
import be.helha.groupeB4.entities.LearningUnit;
import test.LUDAO;

@Stateless
public class LearningUnitEJB {

	@EJB
	private LearningUnitDAO dao;
	
	
	public LearningUnit addLearningUnit(LearningUnit ue) {
		// TODO Auto-generated method stub
		return dao.addLearningUnit(ue);
	}
	
	public List<LearningUnit> addLearningUnits(List<LearningUnit> ue) {
		return dao.addLearningUnits(ue);
	}

	
	public LearningUnit getLearningUnit(String identification) {
		// TODO Auto-generated method stub
		return dao.getLearningUnit(identification);
	}

	
	public List<LearningUnit> getAllLearningUnits() {
		// TODO Auto-generated method stub
		return dao.getAllLearningUnits();
	}


}
