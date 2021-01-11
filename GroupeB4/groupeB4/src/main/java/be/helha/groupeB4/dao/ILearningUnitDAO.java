package be.helha.groupeB4.dao;

import java.util.List;

import be.helha.groupeB4.entities.LearningActivity;
import be.helha.groupeB4.entities.LearningUnit;

public interface ILearningUnitDAO {

	LearningUnit addLearningUnit(LearningUnit ue);
	LearningUnit getLearningUnit(String identification);
	List<LearningUnit> getAllLearningUnits();
	List<LearningActivity> getAllLearningActivities();
}
