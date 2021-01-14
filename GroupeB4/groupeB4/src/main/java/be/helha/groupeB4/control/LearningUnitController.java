package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.ejb.LearningUnitEJB;
import be.helha.groupeB4.entities.LearningUnit;
import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.enumeration.ESection;
import be.helha.groupeB4.excel.InsertStudentFromExcel;

@Named("luc")
@SessionScoped
public class LearningUnitController implements Serializable{
	
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
	
	public List<LearningUnit> doSelectSectionUE(Student s){
		List<LearningUnit> listUE = new ArrayList<>();
		List<LearningUnit> listAllUE = doSelectAll();
		
		for(int i = 0; i < listAllUE.size() ; i++) {
			switch(s.getSection()) {
				case COMPTABILITE:
					if(listAllUE.get(i).getId().contains("S")) {
						listUE.add(listAllUE.get(i));
					}
					break;
				case INFORMATIQUE_DE_GESTION:
					if(listAllUE.get(i).getId().contains("IG")) {
						listUE.add(listAllUE.get(i));
					}
					break;
				case ASSISTANT_DE_DIRECTION:
					if(listAllUE.get(i).getId().contains("AD")) {
						listUE.add(listAllUE.get(i));
					}
					break;
				default: 
					listUE.add(listAllUE.get(i));
				break;
			}
				
		}
		return listUE;
	}
}
