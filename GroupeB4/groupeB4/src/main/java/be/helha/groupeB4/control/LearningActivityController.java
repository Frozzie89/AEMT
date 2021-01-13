package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.ejb.LearningActivityEJB;
import be.helha.groupeB4.entities.LearningActivity;
import be.helha.groupeB4.entities.User;

@Named
@SessionScoped
public class LearningActivityController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private LearningActivityEJB ejb;
	
	
	public List<LearningActivity> doSelectAll(){
		return ejb.getAllLearningActivities(); 
	}
	

}
