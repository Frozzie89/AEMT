package be.helha.groupeB4.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeB4.dao.LearningActivityDAO;
import be.helha.groupeB4.entities.LearningActivity;
import test.LADOA;

@Stateless
public class LearningActivityEJB{

	@EJB
	private LearningActivityDAO dao;

	
	public LearningActivity addLearningActivity(LearningActivity aa) {
		// TODO Auto-generated method stub
		return dao.addLearningActivity(aa);
	}

	
	public LearningActivity getLearningActivity(String identification) {
		// TODO Auto-generated method stub
		return dao.getLearningActivity(identification);
	}

	
	public List<LearningActivity> getAllLearningActivities() {
		// TODO Auto-generated method stub
		return dao.getAllLearningActivities();
	}
}
