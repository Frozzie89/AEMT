package be.helha.groupeB4.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.groupeB4.entities.LearningActivity;

@Remote
public interface ILearningActivityRemote {
	
	LearningActivity addLearningActivity(LearningActivity aa);
	LearningActivity getLearningActivity(String identification);
	List<LearningActivity> getAllLearningActivities();
}
