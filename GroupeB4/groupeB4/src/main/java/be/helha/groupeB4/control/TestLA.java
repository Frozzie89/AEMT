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
	
/*	public LearningActivity addLA() {
		double i = System.currentTimeMillis();
		LearningActivity aa = new LearningActivity("AA"+i,"Test",8,10.);
		ejb.addLearningActivity(aa);
		return aa;
	}*/
	
	public LearningActivity getLA() {
		LearningActivity aa = ejb.getLearningActivity("AA1");
		return aa;
	}
}
