package be.helha.groupeB4.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeB4.dao.LearningActivityDAO;
import be.helha.groupeB4.entities.LearningActivity;

@Stateless
public class LearningActivityEJB{

	@EJB
	private LearningActivityDAO dao;

	// Calls Dao method to add a learning activity
	public LearningActivity addLearningActivity(LearningActivity aa) {
		return dao.addLearningActivity(aa);
	}

	// Calls Dao method to get a learning actibity by its identification
	public LearningActivity getLearningActivity(String identification) {
		return dao.getLearningActivity(identification);
	}

	// Calls Dao method to get all learning activities
	public List<LearningActivity> getAllLearningActivities() {
		return dao.getAllLearningActivities();
	}
}
