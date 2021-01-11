package be.helha.groupeB4.dao;

import java.util.List;

import be.helha.groupeB4.entities.LearningActivity;

public interface ILearningActivityDAO {
	
	LearningActivity addLearningActivity(LearningActivity aa);
	LearningActivity getLearningActivity(String identification);
	List<LearningActivity> getAllLearningActivities();

}
