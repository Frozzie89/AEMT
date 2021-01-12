package be.helha.groupeB4.control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.entities.LearningActivity;
import be.helha.groupeB4.entities.LearningUnit;
import test.LAEJB;
import test.LUEJB;

@Named
@RequestScoped
public class TestLA {

	
	@Inject
	private LAEJB ejb;
	
	public List<LearningActivity> doSelectAll(){
		return ejb.getAllLearningActivities(); 
	}
}
