package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.entities.LearningUnit;
import be.helha.groupeB4.entities.Student;
import test.LUEJB;
import test.STDEJB;

@Named
@RequestScoped
public class TestLU implements Serializable{
	
	@Inject
	private LUEJB ejb;
	
	public List<LearningUnit> doSelectAll(){
		return ejb.getAllLearningUnits(); 
	}

}
