package be.helha.groupeB4.control;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.ejb.LearningUnitEJB;
import be.helha.groupeB4.ejb.StudentEJB;
import be.helha.groupeB4.entities.LearningUnit;
import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.excel.InsertStudentFromExcel;

@Named
@SessionScoped
public class LearningUnitController {
	
	private static final long serialVersionUID = 1L;
	private HtmlDataTable table;
	
	@Inject
	private LearningUnitEJB ejb;
	
	private InsertStudentFromExcel stfu;
	
	public List<LearningUnit> doSelectAll(){
		return ejb.getAllLearningUnits();
	}
	
	public List<LearningUnit> getLearningUnits() {
		List<LearningUnit> maliste = new ArrayList<>();
		maliste = stfu.createLearningUnits();
		ejb.addLearningUnits();
		return maliste;
	}
}
