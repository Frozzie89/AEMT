package be.helha.groupeB4.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeB4.dao.LearningActivityDAO;
import be.helha.groupeB4.entities.LearningActivity;

@Stateless
public class LearningActivityEJB implements ILearningActivityRemote {

	@EJB
	private LearningActivityDAO dao;

	@Override
	public LearningActivity addLearningActivity(LearningActivity aa) {
		// TODO Auto-generated method stub
		return dao.addLearningActivity(aa);
	}

	@Override
	public LearningActivity getLearningActivity(String identification) {
		// TODO Auto-generated method stub
		return dao.getLearningActivity(identification);
	}

	@Override
	public List<LearningActivity> getAllLearningActivities() {
		// TODO Auto-generated method stub
		return dao.getAllLearningActivities();
	}
	
}
