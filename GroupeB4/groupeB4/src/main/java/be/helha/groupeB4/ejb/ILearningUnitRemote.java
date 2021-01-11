package be.helha.groupeB4.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.groupeB4.entities.LearningActivity;
import be.helha.groupeB4.entities.LearningUnit;

@Remote
public interface ILearningUnitRemote {

	LearningUnit addLearningUnit(LearningUnit ue);
	LearningUnit getLearningUnit(String identification);
	List<LearningUnit> getAllLearningUnits();
	List<LearningActivity> getAllLearningActivities();
}
